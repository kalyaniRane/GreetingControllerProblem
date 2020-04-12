package com.example.greeting.repository;

import com.example.greeting.model.Greeting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IGreetingRepository extends JpaRepository<Greeting,Long> {
}
