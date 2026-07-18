/*
Motivation for this file



Begin by thinking about what HTTP request(s) the application needs to be able to process.

The service will handle `GET` requests for `/greeting`,
optionally with a `name` parameter in the query string.

The `GET` request should return a `200 OK` response with JSON in the body that represents a greeting.
It should resemble the following output:
```json
{
    "id": 1,
    "content": "Hello, World!"
}
```
The `id` field is a unique identifier for the greeting,
and `content` is the textual representation of the greeting.



To model the greeting representation, create a resource representation class
[in the form of a Java `record`.]
*/

package com.github.tutorial_about_java_30;

public record Greeting(long id, String content) { }
