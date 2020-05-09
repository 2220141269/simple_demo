package com.example.demo;

import com.example.controller.HelloController;
import com.example.service.HelloService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

	@Autowired
	HelloService helloService;

	@Autowired
	HelloController controller;


	@Test
	public void contextLoads() {
		controller.hello();
		//System.out.println(helloService.helloService());
	}

}
