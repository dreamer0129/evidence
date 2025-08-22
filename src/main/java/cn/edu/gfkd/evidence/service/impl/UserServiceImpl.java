package cn.edu.gfkd.evidence.service.impl;

import cn.edu.gfkd.evidence.domain.User;
import cn.edu.gfkd.evidence.exception.DuplicateUserException;
import cn.edu.gfkd.evidence.repository.UserRepository;
import cn.edu.gfkd.evidence.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    @Override
    public User registerUser(String username, String password, String email) {
        // 验证用户名和邮箱是否已存在
        if (isUsernameExists(username)) {
            throw new DuplicateUserException("用户名 \"" + username + "\" 已被注册，请使用其他用户名");
        }
        if (isEmailExists(email)) {
            throw new DuplicateUserException("邮箱 \"" + email + "\" 已被注册，请使用其他邮箱或尝试找回密码");
        }

        // 创建新用户
        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail(email);
        user.setRole("USER"); // 默认角色为普通用户

        return userRepository.save(user);
    }

    @Override
    public Optional<User> loginUser(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return Optional.of(user);
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean validateUserCredentials(String username, String password) {
        Optional<User> userOptional = userRepository.findByUsername(username);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            return passwordEncoder.matches(password, user.getPassword());
        }
        return false;
    }

    @Override
    public boolean isUsernameExists(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean isEmailExists(String email) {
        return userRepository.existsByEmail(email);
    }
}