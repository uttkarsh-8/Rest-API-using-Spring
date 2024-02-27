package com.apiRest.restful.user;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    private int id;
    @Size(min = 2, message = "Name shall have a minimum of 2 characters")
    private String name;
    @Past(message = "Birthdate has to be in the past")
    private LocalDate birthDate;
}
