package com.example.greeting.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="greeting")
public class Greeting {

    @Id
    Long counter;
    @Column(name="content")
    String content;

    public Greeting() {
    }

    public Greeting(long counter, String content) {
        this.counter=counter;
        this.content=content;
    }

    public Long getCounter() {
        return counter;
    }

    public void setCounter(Long counter) {
        this.counter = counter;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
