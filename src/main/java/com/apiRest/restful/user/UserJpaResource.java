package com.apiRest.restful.user;

import com.apiRest.restful.repository.PostRepository;
import com.apiRest.restful.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

@RestController
public class UserJpaResource {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PostRepository postRepository;
    //GET /USER
    @GetMapping("/jpa/users")
    public List<User> retrieveAllUsers(){
        return userRepository.findAll();
    }

    // going to implement Hateos
    //http://localhost:8080/users

    // 2 things we have to use for Heateos is EntityModel and WebMvcLinkBuilder
    // we are wrapping the User in EntityModel
    @GetMapping("/jpa/users/{id}")
    public EntityModel<Optional<User>> retrieveUsers(@PathVariable int id){

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()){
            throw new UserNotFoundException("id: "+ id);
        }

        EntityModel<Optional<User>> entityModel = EntityModel.of(user);

        WebMvcLinkBuilder link = WebMvcLinkBuilder
                .linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).retrieveAllUsers());

        entityModel.add(link.withRel("all-user"));

        return entityModel;
    }

    //POST/ USERs
    @PostMapping("/jpa/users")
    public ResponseEntity<Object> createUser(@Valid @RequestBody User user){
        User savedUser = userRepository.save(user);
        // location - /users/4
        // we are creating a specific URI or a specific link to view your new user's profile.
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedUser.getId())
                .toUri();
        //ServletUriComponentsBuilder helps in making URI's
        //fromCurrentRequest gets the base address like,"Start with the address of the place where we are right now." and add the id path /{id}

        //buildAndExpand(savedUser.getId()): This part replaces the {id} placeholder with the actual ID of the saved user. For instance, if the savedUser.getId() returns 4, {id} gets replaced with 4.

        // The buildAndExpand method essentially customizes the template created by .path("/{id}") with specific values, finalizing the URI to point directly to the newly created user.

        //toUri - converts it to URI

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/jpa/users/{id}")
    public void user(@PathVariable int id){
        userRepository.deleteById(id);
    }

    @GetMapping("/jpa/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id){
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()){
            throw new UserNotFoundException("id: "+ id);
        }

        List<Post> posts = user.get().getPosts();
        return posts;
    }

    @PostMapping("/jpa/users/{id}/posts")
    public ResponseEntity<Object> createPostsForUsers(@Valid @RequestBody Post post, @PathVariable int id){

        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty()){
            throw new UserNotFoundException("ID: "+id);
        }

        post.setUser(user.get());
        Post savedPost = postRepository.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(savedPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @GetMapping("/jpa/users/{id}/posts/{pid}")
    public Optional<Post> getPosts(@PathVariable int id , @PathVariable int pid){

        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()){
            throw new UserNotFoundException("ID+ "+ id);
        }


        Predicate<? super Post> predicate = post -> post.getId() == pid;

        Optional<Post> post = user.get().getPosts().stream().filter(predicate).findFirst();

        return post;
    }
}
