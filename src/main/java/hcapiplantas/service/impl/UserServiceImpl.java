package hcapiplantas.service.impl;

import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.exception.DistrictNotFoundException;
import hcapiplantas.exception.UserAlreadyExistsException;
import hcapiplantas.model.dto.UserRequestDto;
import hcapiplantas.model.entity.User;
import hcapiplantas.repository.DistrictRepository;
import hcapiplantas.repository.UserRepository;
import hcapiplantas.service.UserService;
import hcapiplantas.util.EncondingUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository repository;

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public User createUSer(UserRequestDto request) throws UserAlreadyExistsException, DistrictNotFoundException {
        if(repository.findByName(request.getName()).isPresent() || repository.findByLogin(request.getLogin()).isPresent())
            throw new UserAlreadyExistsException();

        User user = new User();
        user.setName(request.getName());
        user.setLogin(EncondingUtils.encode(request.getLogin()));
        user.setPassword(EncondingUtils.encode(request.getPassword()));
        user.setStreet(request.getStreet());
        user.setAddressComplement(request.getAddressComplement());
        user.setDistrict(districtRepository.findByName(request.getDistrictName()).orElseThrow(DistrictNotFoundException::new));

        return repository.save(user);
    }

    @Override
    public User getUserById(Long id) throws DataNotFoundException {
        return repository.findById(id).orElseThrow(() -> new DataNotFoundException(id.toString()));
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        repository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public void deleteUser(Long id) throws DataNotFoundException {
        repository.delete(this.getUserById(id));
    }


}
