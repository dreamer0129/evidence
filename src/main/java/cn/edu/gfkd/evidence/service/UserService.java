package cn.edu.gfkd.evidence.service;

import cn.edu.gfkd.evidence.domain.User;
import java.util.Optional;

public interface UserService {
    User registerUser(String username, String password, String email);
    Optional<User> loginUser(String username, String password);
    boolean validateUserCredentials(String username, String password);
    boolean isUsernameExists(String username);
    boolean isEmailExists(String email);
}