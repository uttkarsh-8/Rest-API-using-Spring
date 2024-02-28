package com.apiRest.restful.helloWorldController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class HelloWorldController {

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/hello-world-in18ed")
    public String helloWorldInternationalized(){

        Locale locale = LocaleContextHolder.getLocale();

        return   messageSource.getMessage("good.morning.message",null,"Default Message",locale);

    }
}
