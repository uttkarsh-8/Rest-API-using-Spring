package com.apiRest.restful.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersioningPersonController {
    //URI based versioning
    @GetMapping("/v1/person")
    public PersonV1 getFirstVersionOfPerson(){
        return new PersonV1("John Doe");
    }

    @GetMapping("/v2/person")
    public PersonV2 getSecondVersionOfPerson(){
        return new PersonV2(new Name("Lamds","Oklama"));
    }

    //Param based versioning
    @GetMapping(value = "/person", params = "version=1")
    public PersonV1 getFirstVersionOfPersonRequestParameter(){
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "/person", params = "version=2")
    public PersonV2 getSecondVersionOfPersonRequestParameter(){
        return new PersonV2(new Name("Labda", "Ooklama"));
    }

    //Header based Versioning
    @GetMapping(value = "/person", headers = "X-API-VERSION=1")
    public PersonV1 getFirstVersionOfPersonRequestHeader(){
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "/person", headers = "X-API-VERSION=2")
    public PersonV2 getSecondVersionOfPersonRequestHeader(){
        return new PersonV2(new Name("Labda", "Ooklama"));
    }

    //Media type versioning
    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v1+json")
    public PersonV1 getFirstVersionOfPersonAcceptHeader(){
        return new PersonV1("John Doe");
    }

    @GetMapping(value = "/person/accept", produces = "application/vnd.company.app-v2+json")
    public PersonV2 getSecondVersionOfPersonAcceptHeader(){
        return new PersonV2(new Name("Lamda", "OOklama"));
    }
}
