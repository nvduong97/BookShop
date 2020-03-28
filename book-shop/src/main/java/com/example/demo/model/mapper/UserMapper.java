package com.example.demo.model.mapper;

import com.example.demo.entity.Book;
import com.example.demo.entity.User;
import com.example.demo.model.dto.BookDto;
import com.example.demo.model.dto.UserDto;
import com.example.demo.model.request.CreateUserReq;
import org.mindrot.jbcrypt.BCrypt;

public class UserMapper {
    public static UserDto toUserDto(User user) {
        UserDto tmp = new UserDto();
        tmp.setId(user.getId());
        tmp.setName(user.getName());
        tmp.setPhone(user.getPhone());
        tmp.setAddress(user.getAddress());
        tmp.setEmail(user.getEmail());
        tmp.setRole(user.getRole());
//        tmp.setBirthday(user.getBirthday());

        return tmp;
    }

    public static User toUser(CreateUserReq req) {
        User user = new User();
        user.setName(req.getName());
        user.setEmail(req.getEmail());
        // Hash password using BCrypt
        String hash = BCrypt.hashpw(req.getPassword(), BCrypt.gensalt(12));
        user.setPassword(hash);
        user.setRole("USER");
        return user;
    }
}
