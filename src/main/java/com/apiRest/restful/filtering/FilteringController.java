package com.apiRest.restful.filtering;

import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class FilteringController {

    @GetMapping("/filtering")
    public MappingJacksonValue filtering(){
        // for dynamic filtering we will use MappingJacksonValue
        SomeBean someBean = new SomeBean("val1", "val2", "val3");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(someBean);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field1", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }


    @GetMapping("/filtering-list")
    public MappingJacksonValue filteringList(){

        List<SomeBean> list = Arrays.asList(
                new SomeBean("val1", "val2", "val3"),
                new SomeBean("valA", "valB", "valC"),
                new SomeBean("valX", "valY", "valZ"),
                new SomeBean("valP", "valQ", "valR")
        );

        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(list);

        SimpleBeanPropertyFilter filter = SimpleBeanPropertyFilter.filterOutAllExcept("field2", "field3");
        FilterProvider filters = new SimpleFilterProvider().addFilter("SomeBeanFilter",filter);

        mappingJacksonValue.setFilters(filters);

        return mappingJacksonValue;
    }
}
