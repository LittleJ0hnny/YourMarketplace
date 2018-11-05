package resourceserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestOperations;

import java.security.Principal;

@RestController
public class TestController {

    @Autowired
    private RestOperations restOperations;

    @RequestMapping("/user")
    public Principal user(Principal user) {
        return user;
    }

    @GetMapping("/message")
    @PreAuthorize("hasRole('ADMIN')")
    public String getMessage() {
        return restOperations.getForObject("http://localhost:8084/message", String.class);
    }
}
