package com.apiRest.restful.HelloWorldController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Rest API
@RestController
public class HelloWorldController {
    // Hello world
    @GetMapping("/hello-world")
    public String helloWorld(){

        return "Hello World";
    }

    @GetMapping("/hello-world-bean")
    public HelloWorldbean helloWorldBean(){
        return new HelloWorldbean("Hello World");
    }
    //Path parameters
    // /user/{id}/todos/{id} => /user/1/todos/202
    // /hello-world/path-variable/{name}
    // /hello-world/path-variable/uttu

    @GetMapping("/hello-world/path-variable/{name}")
    public HelloWorldbean helloWorldPathVariable(@PathVariable String name){
        return new HelloWorldbean(String.format("Hello World %s", name));
    }
}
