package com.apiRest.restful.HelloWorldController;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class HelloWorldbean {

    private String message;
    public HelloWorldbean(String message) {
        this.message = message;
    }
}
