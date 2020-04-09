package com.example.greeting.controller;

import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private AtomicLong counter=new AtomicLong();
    private String template="Hello, %s!";

    @GetMapping("/param/greeting")
    public Greeting greeting(@RequestParam(value = "name",defaultValue = "World") String name){
        return new Greeting(counter.incrementAndGet(),
                String.format(template,name));
    }

    @GetMapping("/greeting")
    public Greeting greeting(){
        return new Greeting(counter.incrementAndGet(),
                String.format(template," "));
    }

    @PostMapping("/post/greeting")
    public Greeting greeting(@RequestBody Greeting greeting){
        return new Greeting(counter.incrementAndGet(),
                String.format(template,greeting.getContent()));
    }

}
