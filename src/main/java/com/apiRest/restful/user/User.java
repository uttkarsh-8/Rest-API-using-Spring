package com.apiRest.restful.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity(name = "user_details")
public class User {
    @Id
    @GeneratedValue
    private int id;
    @Size(min = 2, message = "Name shall have a minimum of 2 characters")
    @JsonProperty("user_name")
    private String name;
    @Past(message = "Birthdate has to be in the past")
    @JsonProperty("birth_date")
    private LocalDate birthDate;
}
