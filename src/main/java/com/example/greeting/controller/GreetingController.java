package com.example.greeting.controller;

import com.example.greeting.model.Greeting;
import com.example.greeting.model.User;
import com.example.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GreetingController {

    @Autowired
    private IGreetingService greetingService;

    @GetMapping("/greeting")
    public Greeting addGreeting(@RequestParam(value = "fname",defaultValue = "World") String firstName,
                             @RequestParam("lname")String lastName){
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.addGreeting(user);
    }

    @RequestMapping("/findAll/greeting")
    public List<Greeting> findGreeting(){
       return greetingService.getAllGreetings();
    }

    @RequestMapping(value = "/find/greeting/byId",method = RequestMethod.GET)
    public Greeting findByIdGreeting(@RequestParam(value = "id") Long id){
        return greetingService.getGreetingById(id);
    }

    @GetMapping("/update/greeting")
    public Greeting updateGreeting(@RequestParam(value="id")Long id,@RequestParam(value = "fname")String firstName,@RequestParam(value = "lname") String lastName){
        User user=new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        return greetingService.updateGreeting(user,id);
    }

}
