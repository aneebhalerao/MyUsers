package com.user.user.e2e;

import com.user.user.Entity.UsersDetailEntity;
import com.user.user.Repository.UsersDetailRepository;
import com.user.user.services.UserService;
import jakarta.inject.Inject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest(classes = UserServiceTest.class)
@ExtendWith(MockitoExtension.class)
public class UserServiceTest {

    @Mock
    private UsersDetailRepository repository;

    @InjectMocks
    private UserService userService;

    UsersDetailEntity userDetailEntity;

    @BeforeEach
    public void setUp() {
        userDetailEntity = new UsersDetailEntity();
        userDetailEntity.setId(1L);
        userDetailEntity.setName("test");
        userDetailEntity.setAddress("Hannover");
        userDetailEntity.setAge(20);
    }

    @Test
    void getUserById() {
        when(repository.findAll()).thenReturn(List.of(userDetailEntity));
        List<UsersDetailEntity> userDetailEntityresult = userService.getUsers();
        assertEquals("test", userDetailEntityresult.get(0).getName());
        assertEquals("Hannover", userDetailEntityresult.get(0).getAddress());
    }

    @Test
    void saveUserTest() {
        userDetailEntity.setId(null);
        when(repository.save(any(UsersDetailEntity.class))).thenReturn(userDetailEntity);
        assertEquals(userDetailEntity, userService.saveUser(userDetailEntity));
    }

    @Test
    void updateUserTest() {
        when(repository.save(any(UsersDetailEntity.class))).thenReturn(userDetailEntity);
        assertEquals(userDetailEntity, userService.updateUser(userDetailEntity));
    }


    @Test
    void deleteUserById() {
        userService.deleteUser(1L);
        verify(repository, times(1)).deleteById(1L);
    }
}
