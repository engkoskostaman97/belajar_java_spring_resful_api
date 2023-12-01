package engkoskostaman.belajarspringrestfullapi.service;

import engkoskostaman.belajarspringrestfullapi.entity.User;
import engkoskostaman.belajarspringrestfullapi.model.RegisterUserRequest;
import engkoskostaman.belajarspringrestfullapi.model.UserResponse;
import engkoskostaman.belajarspringrestfullapi.repository.UserRepository;
import engkoskostaman.belajarspringrestfullapi.security.BCrypt;
import jakarta.transaction.Transactional;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Set;
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private  ValidationService validationService;


    @Transactional
    public void register(RegisterUserRequest request) {
        validationService.validate(request);

        if (userRepository.existsById(request.getUsername())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Username already registered");
        }

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(BCrypt.hashpw(request.getPassword(),BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }


    public  UserResponse get(User user){
        return UserResponse.builder()
                .username(user.getUsername())
                .name(user.getName())
                .build();
    }



}
