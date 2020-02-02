package uyen.btl.task1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import uyen.btl.task1.dto.Response;
import uyen.btl.task1.entity.User;
import uyen.btl.task1.service.UserService;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("/api/users")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @PostMapping("/api/users")
    public Response createUser(@RequestBody User user){
        return userService.createUser(user);
    }
}
