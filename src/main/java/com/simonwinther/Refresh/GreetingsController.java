package com.simonwinther.Refresh;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

//This code uses Spring @RestController annotation, which marks the
// class as a controller where every method returns a domain object
// instead of a view.
// It is shorthand for including both @Controller and @ResponseBody.
@RestController
public class GreetingsController {

    private final AtomicLong counter = new AtomicLong(0);

    public record GreetingDTO(long id, String name){}

    //@RequestMapping(method= RequestMethod.GET)
    @GetMapping("/hello")
    public GreetingDTO hello(@RequestParam(value = "name", defaultValue = "World!") String name){
        return new GreetingDTO(counter.incrementAndGet(), name);
    }
}
