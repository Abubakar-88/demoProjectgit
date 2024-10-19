package com.demol.services.service;

import com.demol.dto.user.UserRequestDTO;
import com.demol.dto.user.UserResponseDTO;
import com.demol.entity.Users;
import com.demol.repository.UserRepository;


import java.util.List;



public interface UserService {
    //All method define in service package

    public UserResponseDTO createUser(UserRequestDTO userRequestDTO);
    public UserResponseDTO getById(Long id);
    public List<UserResponseDTO> getAllUsers();
    public UserResponseDTO upDateUsers(UserRequestDTO userRequestDTO, Long id);
    public void userDelete(Long id);


}
