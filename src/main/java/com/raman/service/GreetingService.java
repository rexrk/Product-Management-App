package com.raman.service;

public class GreetingService {
    public static String getMessage(String name) {
        if(name == null) {
            return "oye imposter";
        }
        return "Hello " + name;
    }
}