package com.example.client1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("client1")
public class TestController {

    Environment env;
    @Autowired
    public TestController(Environment env){
        this.env = env;
    }

    @Value("${posco.name}")
    String name;

    @Value("${jwt.ret}")
    String ret;

    @Value("${posco.datasource.url}")
    String url;

    @GetMapping
    public String test(HttpServletRequest request){
        return "client 1 태헌 " + env.getProperty("local.server.port") + " " + request.getServerPort();
    }

    @GetMapping("/hello")
    public String hello(){
        return  name + "hello" + ret + " " + url;
    }

    @GetMapping("/id/{id}")
    public String hello(@PathVariable("id") String id){
        return id;
    }
}
