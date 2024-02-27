package com.apiRest.restful.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {
    // jpa and hibernate => Database
    // for now we will creat e a static list, the User DAOservice will talk to the static list at the moment

    private static int usersCount = 0;

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(++usersCount, "Uttu", LocalDate.now().minusYears(19)));
        users.add(new User(++usersCount, "Isha", LocalDate.now().minusYears(25)));
        users.add(new User(++usersCount, "Aarav", LocalDate.now().minusYears(18)));
    }

    // public List<User> findAll()
    public List<User> findAll(){
        return users;
    }
    // public User save(User user)
    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    // public User findOne(int id)
    public User findOne(int id){
        Predicate<? super User> predicate = user -> user.getId() == id;
        return users.stream().filter(predicate).findFirst().orElse(null); // if the user is not found, return null instead of an empty object
    }

    // deleting a user
    public void deleteByid(int id){
        Predicate<? super User> predicate = user -> user.getId() == id;
        users.removeIf(predicate);
    }

}
