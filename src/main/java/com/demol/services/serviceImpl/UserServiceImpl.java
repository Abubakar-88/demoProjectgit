package com.demol.services.serviceImpl;

import com.demol.dto.user.UserRequestDTO;
import com.demol.dto.user.UserResponseDTO;
import com.demol.entity.Users;
import com.demol.repository.UserRepository;
import com.demol.services.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;
    @Override
    public UserResponseDTO createUser(UserRequestDTO userRequestDTO) {
        Users users = modelMapper.map(userRequestDTO,Users.class);
        Users users1 = userRepository.save(users);
         UserResponseDTO userResponseDTO = modelMapper.map(users1,UserResponseDTO.class);
        return userResponseDTO;
    }

    @Override
    public UserResponseDTO getById(Long id) {
        Users users = userRepository.findById(id).orElse(null);
       UserResponseDTO userResponseDTO =  modelMapper.map(users ,UserResponseDTO.class);
        return userResponseDTO;
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        List<Users> usersList =  userRepository.findAll();
        return usersList.stream().map(users -> modelMapper.map(users,UserResponseDTO.class)).toList();
    }

    @Override
    public UserResponseDTO upDateUsers(UserRequestDTO userRequestDTO,Long id) {
        Users existtingUsers = userRepository.findById(id).orElse(null);
//        int id = 10;
//        id = 20;
        modelMapper.map(userRequestDTO,existtingUsers);
        Users updatedUsers = userRepository.save(existtingUsers);
        UserResponseDTO userResponseDTO = modelMapper.map(updatedUsers, UserResponseDTO.class);
        return userResponseDTO;
    }

    @Override
    public void userDelete(Long id) {
        Users existtingUsers = userRepository.findById(id).orElse(null);
        userRepository.delete(existtingUsers);
        //another option
       // userRepository.deleteById(id);
    }
}
