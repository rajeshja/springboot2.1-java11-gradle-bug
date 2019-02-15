module rja.price.main {
    requires java.sql;
    requires spring.beans;
    requires spring.core;
    requires spring.context;
    requires spring.web;
    requires spring.webflux;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    //requires lombok;
    requires reactor.core;
    opens rja.price to spring.core, spring.beans, spring.context;
    exports rja.price.application.controller;
    exports rja.price.domain.entity to com.fasterxml.jackson.databind;
}