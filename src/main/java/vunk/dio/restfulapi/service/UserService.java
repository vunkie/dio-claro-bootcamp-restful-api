package vunk.dio.restfulapi.service;

import vunk.dio.restfulapi.model.User;

public interface UserService {
    User findById(Long id);

    User create(User userToCreate);
    

}
