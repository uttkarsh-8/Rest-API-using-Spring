package com.apiRest.restful.filtering;

import com.fasterxml.jackson.annotation.JsonFilter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@JsonFilter("SomeBeanFilter")
//@JsonIgnoreProperties("field1") // other way to hide a field upon calling the API
public class SomeBean {
    private String field1;
//    @JsonIgnore //used to hide any data you want your API to show, comes under static filtering
    private String field2;
    private String field3;
}
