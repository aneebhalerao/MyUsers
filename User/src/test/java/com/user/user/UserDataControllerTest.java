package com.user.user;

import com.user.user.Entity.UsersDetailEntity;
import com.user.user.controllers.UserDataController;
import com.user.user.services.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.test.autoconfigure.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest(controllers = UserDataController.class)
class UserDataControllerTest {
    @Autowired
    MockMvc mockMvc;

    @MockitoBean
    UserService userService;
    UsersDetailEntity userDetailEntity;
    @BeforeEach
    void setUp() {
        userDetailEntity = new UsersDetailEntity();
        userDetailEntity.setId(1L);
        userDetailEntity.setName("test");
        userDetailEntity.setAddress("Hannover");
        userDetailEntity.setAge(20);
    }

    @Test
    void getUserData() throws Exception {
        when(userService.getUsers()).thenReturn(Arrays.asList(userDetailEntity));

        mockMvc.perform(get("/get"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("test"));

    }

    @Test
    void upsertUserTest() throws Exception {
        when(userService.saveUser(any(UsersDetailEntity.class))).thenReturn(userDetailEntity);

        mockMvc.perform(post("/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{ \"name\":\"test\", \"age\":20, \"address\":\"Hannover\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"));
    }

    @Test
    void updateUserTest() throws Exception {

        when(userService.updateUser(any(UsersDetailEntity.class))).thenReturn(userDetailEntity);
        mockMvc.perform(put("/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{ \"name\":\"Ankita\", \"age\":20, \"address\":\"Hannover\"}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("test"));
    }

    @Test
    void deleteUserTest() throws Exception {
        mockMvc.perform(delete("/delete/{id}",1L))
                .andExpect(status().isOk());
        verify(userService, times(1)).deleteUser(1L);
    }

}
