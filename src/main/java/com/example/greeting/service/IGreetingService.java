package com.example.greeting.service;

import com.example.greeting.model.Greeting;
import com.example.greeting.model.User;

import java.util.List;
import java.util.Optional;

public interface IGreetingService {
    Greeting addGreeting(User user);
    List<Greeting> getAllGreetings();
    Greeting getGreetingById(Long id);
}
