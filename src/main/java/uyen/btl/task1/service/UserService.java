package uyen.btl.task1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uyen.btl.task1.dto.Response;
import uyen.btl.task1.entity.User;
import uyen.btl.task1.repository.UserRepository;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public Response createUser(User user) {
        Response response = new Response();
        String username = user.getUsername();
        String password = user.getPassword();
        if (username!=null &&!username.isEmpty()&& password!=null &&  !password.isEmpty() && userRepository.findByUsername(username)==null ) {
            response.setId(1);
            response.setMessage("Thanh cong");
            userRepository.save(user);
        } else {
            response.setId(0);
            response.setMessage("That bai");
        }

        return response;
    }

}
