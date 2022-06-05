package com.encrypt.starter;

import com.encrypt.starter.annotation.Decrypt;
import com.encrypt.starter.annotation.Encrypt;
import com.encrypt.starter.body.RespBean;
import com.encrypt.starter.body.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class EncryptApplication {
    @GetMapping("/user")
    @Encrypt
    public RespBean getUser(String username) {
        return RespBean.ok("ok", new User((long)100, username));
    }

    @PostMapping("/user")
    public RespBean addUser(@RequestBody @Decrypt User user) {
        System.out.println("user= " + user);
        return RespBean.ok("ok", user);
    }

    public static void main(String[] args) {
        SpringApplication.run(EncryptApplication.class, args);
    }
}
