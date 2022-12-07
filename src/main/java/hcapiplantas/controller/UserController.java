package hcapiplantas.controller;

import hcapiplantas.exception.DataNotFoundException;
import hcapiplantas.exception.DistrictNotFoundException;
import hcapiplantas.exception.UserAlreadyExistsException;
import hcapiplantas.model.dto.UserRequestDto;
import hcapiplantas.model.dto.UserResponseDto;
import hcapiplantas.model.entity.User;
import hcapiplantas.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@Valid @RequestBody UserRequestDto request) throws URISyntaxException, DistrictNotFoundException, UserAlreadyExistsException, DataNotFoundException {
        User user = userService.createUSer(request);
        UserResponseDto userResponseDto = UserResponseDto.fromEntityToResponse(user);
        userResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + user.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUserById(@PathVariable String id) throws DataNotFoundException {
        User user = userService.getUserById(Long.valueOf(id));
        return ResponseEntity.ok(UserResponseDto.fromEntityToResponse(user));
    }

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> getAllUsers() throws URISyntaxException {
        List<UserResponseDto> userResponseDtoList = new ArrayList<>();
        List<User> users = userService.getAllUsers();

        for (User user : users) {
            UserResponseDto userResponseDto = UserResponseDto.fromEntityToResponse(user);
            userResponseDto.setLink(new URI(ServletUriComponentsBuilder.fromCurrentRequestUri().build() + "/" + user.getId()));
            userResponseDtoList.add(userResponseDto);
        }

        return ResponseEntity.ok(userResponseDtoList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserResponseDto> deleteUser(@PathVariable String id) throws DataNotFoundException {
        userService.deleteUser(Long.valueOf(id));
        return ResponseEntity.noContent().build();
    }
}
