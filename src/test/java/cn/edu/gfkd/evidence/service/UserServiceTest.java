package cn.edu.gfkd.evidence.service;

import cn.edu.gfkd.evidence.domain.User;
import cn.edu.gfkd.evidence.exception.DuplicateUserException;
import cn.edu.gfkd.evidence.repository.UserRepository;
import cn.edu.gfkd.evidence.service.impl.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import java.util.Optional;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private BCryptPasswordEncoder passwordEncoder;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        passwordEncoder = new BCryptPasswordEncoder();
    }

    @Test
    void testRegisterUser_Success() {
        // 准备测试数据
        String username = "testuser";
        String password = "password123";
        String email = "test@example.com";

        // 模拟Repository行为
        when(userRepository.existsByUsername(username)).thenReturn(false);
        when(userRepository.existsByEmail(email)).thenReturn(false);

        User savedUser = new User();
        savedUser.setId(1L);
        savedUser.setUsername(username);
        savedUser.setPassword(passwordEncoder.encode(password));
        savedUser.setEmail(email);
        savedUser.setRole("USER");

        when(userRepository.save(any(User.class))).thenReturn(savedUser);

        // 调用服务方法
        User result = userService.registerUser(username, password, email);

        // 验证结果
        assertNotNull(result);
        assertEquals(username, result.getUsername());
        assertEquals(email, result.getEmail());
        assertEquals("USER", result.getRole());
        assertTrue(passwordEncoder.matches(password, result.getPassword()));

        // 验证Repository方法是否被调用
        verify(userRepository, times(1)).existsByUsername(username);
        verify(userRepository, times(1)).existsByEmail(email);
        verify(userRepository, times(1)).save(any(User.class));
    }

    @Test
    void testRegisterUser_UsernameExists() {
        // 准备测试数据
        String username = "existinguser";
        String password = "password123";
        String email = "test@example.com";

        // 模拟Repository行为
        when(userRepository.existsByUsername(username)).thenReturn(true);

        // 调用服务方法并验证异常
        DuplicateUserException exception = assertThrows(DuplicateUserException.class, () -> {
            userService.registerUser(username, password, email);
        });

        assertEquals("用户名 \"existinguser\" 已被注册，请使用其他用户名", exception.getMessage());

        // 验证Repository方法是否被调用
        verify(userRepository, times(1)).existsByUsername(username);
        verify(userRepository, never()).existsByEmail(email);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testLoginUser_Success() {
        // 准备测试数据
        String username = "testuser";
        String password = "password123";

        // 模拟Repository行为
        User user = new User();
        user.setId(1L);
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));
        user.setEmail("test@example.com");
        user.setRole("USER");

        when(userRepository.findByUsername(username)).thenReturn(Optional.of(user));

        // 调用服务方法
        Optional<User> result = userService.loginUser(username, password);

        // 验证结果
        assertTrue(result.isPresent());
        assertEquals(username, result.get().getUsername());

        // 验证Repository方法是否被调用
        verify(userRepository, times(1)).findByUsername(username);
    }

    @Test
    void testRegisterUser_EmailExists() {
        // 准备测试数据
        String username = "newuser";
        String password = "password123";
        String email = "existing@example.com";

        // 模拟Repository行为
        when(userRepository.existsByUsername(username)).thenReturn(false);
        when(userRepository.existsByEmail(email)).thenReturn(true);

        // 调用服务方法并验证异常
        DuplicateUserException exception = assertThrows(DuplicateUserException.class, () -> {
            userService.registerUser(username, password, email);
        });

        assertEquals("邮箱 \"existing@example.com\" 已被注册，请使用其他邮箱或尝试找回密码", exception.getMessage());

        // 验证Repository方法是否被调用
        verify(userRepository, times(1)).existsByUsername(username);
        verify(userRepository, times(1)).existsByEmail(email);
        verify(userRepository, never()).save(any(User.class));
    }

    @Test
    void testLoginUser_Failure() {
        // 准备测试数据
        String username = "nonexistentuser";
        String password = "password123";

        // 模拟Repository行为
        when(userRepository.findByUsername(username)).thenReturn(Optional.empty());

        // 调用服务方法
        Optional<User> result = userService.loginUser(username, password);

        // 验证结果
        assertFalse(result.isPresent());

        // 验证Repository方法是否被调用
        verify(userRepository, times(1)).findByUsername(username);
    }
}