package controller;

import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dto.Greeting;

@CrossOrigin
@RestController
@RequestMapping(value = "/greet/")
public class GreetingController {

    final static Logger log = Logger.getLogger("GreetingController");
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/greeting")
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }

    @GetMapping("/userName")
    public String name(@RequestParam(value = "userName", defaultValue = "World") String name) {
        log.info("It's GreetingController name function");
        String quote = restTemplate.getForObject(
                "https://quoters.apps.pcfone.io/api/random", String.class);
        return name + " AND " + quote;
    }
}