package com.demol.controller;

import com.demol.dto.user.UserRequestDTO;
import com.demol.dto.user.UserResponseDTO;
import com.demol.services.serviceImpl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api1/users")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserRequestDTO userRequestDTO){
       UserResponseDTO userResponseDTO = userService.createUser(userRequestDTO);
       return ResponseEntity.status(HttpStatus.CREATED).body(userResponseDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDTO> getUserById(@PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.getById(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
    }
    @GetMapping("/allusers")
    public ResponseEntity<List<UserResponseDTO>> getAllUsers(){
        List<UserResponseDTO> listuserResponseDTO = userService.getAllUsers();
        return ResponseEntity.status(HttpStatus.OK).body(listuserResponseDTO);
    }
    @PutMapping("/updateusers")
    public ResponseEntity<UserResponseDTO> updateUser(
            @RequestBody UserRequestDTO userRequestDTO, @PathVariable Long id){
        UserResponseDTO userResponseDTO = userService.upDateUsers(userRequestDTO, id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
         userService.userDelete(id);
        return ResponseEntity.noContent().build();
    }


}
