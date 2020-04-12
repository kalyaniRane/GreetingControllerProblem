package com.example.greeting.service.implementations;

import com.example.greeting.exception.GreetingException;
import com.example.greeting.model.Greeting;
import com.example.greeting.model.User;
import com.example.greeting.repository.IGreetingRepository;
import com.example.greeting.service.IGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService implements IGreetingService {

    private AtomicLong counter=new AtomicLong();
    private String template="Hello, %s!";

    @Autowired
    private IGreetingRepository greetingRepository;

    @Override
    public Greeting addGreeting(User user) {

        String message = user.toString().isEmpty() ? "Hello World" : user.getFirstName() + " " + user.getLastName();

        Greeting greeting=new Greeting(counter.incrementAndGet(),
                String.format(template,message));
        return greetingRepository.save(greeting);
    }

    @Override
    public List<Greeting> getAllGreetings() {
        return greetingRepository.findAll();
    }

    @Override
    public Greeting getGreetingById(Long id) {
        return greetingRepository.findById(id).orElseThrow(()->new GreetingException("No Record Available"));
    }

}