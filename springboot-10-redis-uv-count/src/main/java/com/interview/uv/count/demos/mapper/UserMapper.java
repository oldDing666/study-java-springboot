package com.interview.uv.count.demos.mapper;

import com.interview.uv.count.demos.request.UserDto;
import com.interview.uv.count.demos.response.UserVo;
import org.mapstruct.Mapper;

/**
 * @author: afuya
 * @program: study-java-springboot
 * @date: 2024/8/12 13:18
 */
@Mapper(componentModel = "spring")
public interface UserMapper {

    UserVo convertToUserVo(UserDto userDto);
}
