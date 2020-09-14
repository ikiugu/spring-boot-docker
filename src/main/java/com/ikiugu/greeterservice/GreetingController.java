package com.ikiugu.greeterservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

/**
 * created by alfred.ikiugu on 14-Sep-20
 */
@RestController
public class GreetingController {
    private static final String template = "Nice to meet you, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "stranger") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
}
