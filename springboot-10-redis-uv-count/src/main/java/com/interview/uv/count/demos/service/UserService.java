package com.interview.uv.count.demos.service;

import com.interview.uv.count.demos.mapper.UserMapper;
import com.interview.uv.count.demos.request.UserDto;
import com.interview.uv.count.demos.response.UserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: afuya
 * @program: study-java-springboot
 * @date: 2024/8/12 13:20
 */
@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public UserVo maskUser(UserDto userDto) {
        return userMapper.convertToUserVo(userDto);
    }
}
