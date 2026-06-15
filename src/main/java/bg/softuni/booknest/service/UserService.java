package bg.softuni.booknest.service;

import bg.softuni.booknest.mapper.UserMapper;
import bg.softuni.booknest.model.dto.UserDto;
import bg.softuni.booknest.model.dto.UserLoginRequest;
import bg.softuni.booknest.model.dto.UserRegisterRequest;
import bg.softuni.booknest.model.entity.User;
import bg.softuni.booknest.model.enums.UserRole;
import bg.softuni.booknest.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder,
                       UserMapper userMapper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
    }

    public boolean register(UserRegisterRequest request) {
        if (!request.getPassword().equals(request.getConfirmPassword())) {
            return false;
        }

        if (userRepository.findByUsername(request.getUsername()).isPresent()) {
            return false;
        }

        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            return false;
        }

        User user = new User()
                .setUsername(request.getUsername())
                .setEmail(request.getEmail())
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setRole(UserRole.USER);

        userRepository.save(user);

        return true;
    }

    public Optional<UserDto> login(UserLoginRequest request) {
        return userRepository.findByUsername(request.getUsername())
                .filter(user -> passwordEncoder.matches(
                        request.getPassword(),
                        user.getPassword()))
                .map(userMapper::toDto);
    }

}