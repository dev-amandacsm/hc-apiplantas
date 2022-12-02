package hcapiplantas.service;

import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.exception.DistrictNotFoundException;
import hcapiplantas.exception.UserAlreadyExistsException;
import hcapiplantas.model.dto.UserRequestDto;
import hcapiplantas.model.entity.User;

import java.util.List;

public interface UserService {
    User createUSer(UserRequestDto request) throws UserAlreadyExistsException, DataNotFoundException, DistrictNotFoundException;

    User getUserById(Long id) throws DataNotFoundException;

    List<User> getAllUsers();

    void deleteUser(Long id) throws DataNotFoundException;
}
