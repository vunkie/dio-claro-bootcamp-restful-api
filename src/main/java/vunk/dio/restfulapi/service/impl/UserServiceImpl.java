package vunk.dio.restfulapi.service.impl;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;

import vunk.dio.restfulapi.model.User;
import vunk.dio.restfulapi.repository.UserRepository;
import vunk.dio.restfulapi.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("Esta conta já existe");
        }else{
            return userRepository.save(userToCreate);
        }
    }
    
}
