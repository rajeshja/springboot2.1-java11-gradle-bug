I'm using Gradle 5.2, with a very simple project that adds a controller and an entity package to the base starter created with Spring 2.1.2. The code in `src/main/java` is setup as a Java module. He is my module definition (I only have one at this time)

```
module rja.price.main {
    requires java.sql;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.web;
    requires spring.webflux;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires reactor.core;
    opens rja.price to spring.core, spring.beans, spring.context;
    exports rja.price.application.controller;
    exports rja.price.domain.entity to com.fasterxml.jackson.databind;
}
```

Running `gradlew build` breaks at `compileTestJava` with 100 errors of the form:

```
error: the unnamed module reads package org.json from both jsonassert and android.json
error: the unnamed module reads package org.hamcrest from both hamcrest.core and hamcrest.library
error: module spring.boot reads package org.json from both jsonassert and android.json
error: module spring.boot reads package org.hamcrest from both hamcrest.core and hamcrest.library
```

The code seems to run fine from IDEA though.