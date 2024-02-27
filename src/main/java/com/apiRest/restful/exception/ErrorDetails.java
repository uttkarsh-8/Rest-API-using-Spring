package com.apiRest.restful.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

// whenever an webservice throws an exception, we want to return a standard error structure
// this is the structure of the error message that we want to return
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetails {
    //timestamp
    //message
    //details
    private LocalDateTime timestamp;
    private String message;
    private String details;

}
