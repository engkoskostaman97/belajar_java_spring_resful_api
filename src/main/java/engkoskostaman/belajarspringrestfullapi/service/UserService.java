package engkoskostaman.belajarspringrestfullapi.service;

import engkoskostaman.belajarspringrestfullapi.model.RegisterUserRequest;
import engkoskostaman.belajarspringrestfullapi.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.xml.validation.Validator;

public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    public void register(RegisterUserRequest request) {

    }
}
