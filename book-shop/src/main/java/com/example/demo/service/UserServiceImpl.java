package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.exception.DuplicateRecordException;
import com.example.demo.exception.NotFoundException;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.mapper.UserMapper;
import com.example.demo.model.request.CreateUserReq;
import com.example.demo.model.request.UpdateUserReq;
import com.example.demo.repository.UserRepository;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<UserDto> getListUser() {
        List<UserDto> result = new ArrayList<>();
        List<User> users = userRepository.findAll();
        for (User user: users) {
            result.add(UserMapper.toUserDto(user));
        }
        return result;
    }

    @Override
    public UserDto getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        if(user.equals(null)){
            throw new NotFoundException("User Not found");
        }
        return UserMapper.toUserDto(user.get());
    }

    @Override
    public UserDto createUser(CreateUserReq req) {
        List<User> users = userRepository.findAll();
        for (User user: users) {
            if(user.getEmail().equals(req.getEmail())){
                throw  new DuplicateRecordException("Email đã tồn tại");
            }
        }
        User user = UserMapper.toUser(req);
        userRepository.save(user);
        return UserMapper.toUserDto(user);
    }

    @Override
    public UserDto updateUser(UpdateUserReq req, int id) {
        User result = userRepository.findById(id).get();
        if(result.equals(null)){
            throw new NotFoundException("User Not found");
        }
        result.setName(req.getName());
        result.setEmail(req.getEmail());
        result.setPassword(req.getPassword());
        result.setPhone(req.getPhone());
//        result.setAvatar(req.getAvatar());
        userRepository.save(result);
        return UserMapper.toUserDto(result);
    }

    @Override
    public Boolean updateUser(UserDto user) {
        User result = userRepository.findById(user.getId()).get();
        result.setName(user.getName());
        result.setAddress(user.getAddress());
        result.setPhone(user.getPhone());
        userRepository.save(result);
        return true;
    }

    @Override
    public boolean deleteUser(int id) {
        userRepository.deleteById(id);
        return true;
    }
}
