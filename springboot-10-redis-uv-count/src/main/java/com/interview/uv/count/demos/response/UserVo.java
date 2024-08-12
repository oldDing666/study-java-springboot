package com.interview.uv.count.demos.response;

import com.interview.uv.count.demos.annotation.Desensitization;
import com.interview.uv.count.demos.enums.DesensitizationTypeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: afuya
 * @program: study-java-springboot
 * @date: 2024/8/12 13:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVo {
    @Desensitization(type = DesensitizationTypeEnum.USER_ID)
    private String userId;

    @Desensitization(type = DesensitizationTypeEnum.MY_RULE, startInclude = 3, endExclude = 6)
    private String serialNumber;

    @Desensitization(type = DesensitizationTypeEnum.MOBILE_PHONE)
    private String phone;

    @Desensitization(type = DesensitizationTypeEnum.CHINESE_NAME)
    private String name;

    @Desensitization(type = DesensitizationTypeEnum.EMAIL)
    private String email;
}
