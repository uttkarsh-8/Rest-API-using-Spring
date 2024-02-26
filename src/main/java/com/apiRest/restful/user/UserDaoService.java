package com.apiRest.restful.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class UserDaoService {
    // jpa and hibernate => Database
    // for now we will creat e a static list, the User DAOservice will talk to the static list at the moment

    private static List<User> users = new ArrayList<>();
    static {
        users.add(new User(1, "Uttu", LocalDate.now().minusYears(19)));
        users.add(new User(2, "Isha", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Aarav", LocalDate.now().minusYears(18)));
    }

    // public List<User> findAll()
    public List<User> findAll(){
        return users;
    }
    // public User save(User user)
    // public User findOne(int id)

}
