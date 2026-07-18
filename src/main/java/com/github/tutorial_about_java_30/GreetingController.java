package com.github.tutorial_about_java_30;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
A key difference between
a traditional MVC controller [which is annotated with `@Controller`, as on https://spring.io/guides/gs/serving-web-content ]
and
the RESTful web service controller [implemented in this file]
is
the way that the HTTP response body is created.

    Rather than relying on a view technology [such Thymeleaf] to perform server-side rendering of the greeting data to HTML,
    
    this RESTful web service controller populates and returns a `Greeting` object.
    The object data will be written directly to the HTTP response as JSON.

This code uses Spring `@RestController` annotation, which marks the class as a [RESTful web service] controller
[meaning that] every method returns a domain object instead of a view.
It is shorthand for including both `@Controller` and `@ResponseBody`.

The `Greeting` object must be converted to JSON.

    Thanks to Spring’s HTTP message converter support, you need not do this conversion manually.

    Because Jackson is on the classpath,
    Spring’s `JacksonJsonHttpMessageConverter` is automatically chosen to convert the `Greeting` instance to JSON.
*/
@RestController
public class GreetingController {
    
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    /*
    [This] annotation ensures that
    HTTP GET requests to `/greeting` are mapped to the `greeting()` method.

    (
    There are companion annotations for other HTTP verbs (e.g. `@PostMapping` for POST).
    There is also a `@RequestMapping` annotation that
    they all derive from,
    and can serve as a synonym (e.g. `@RequestMapping(method=GET)`).
    )
    */
    @GetMapping("/greeting")
    public Greeting greeting(
        /*
        [This annotation] binds the value of the query string parameter `name`
        into the `name` parameter of the ... method.
        */

        @RequestParam(defaultValue = "World")
        String name
    ) {
        Greeting grtng = new Greeting(
            counter.incrementAndGet(),
            template.formatted(name)
        );
        return grtng;
    }
}
