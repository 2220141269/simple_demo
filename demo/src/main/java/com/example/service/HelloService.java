package com.example.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {


    public String helloService(){
        return "say helloService";
    }


    public int getage(String name){
        return 18;
    }
}
