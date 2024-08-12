package com.interview.uv.count.demos.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.interview.uv.count.demos.enums.DesensitizationTypeEnum;
import com.interview.uv.count.demos.utils.DesensitizationSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author: afuya
 * @program: study-java-springboot
 * @date: 2024/8/12 11:19
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizationSerialize.class)
public @interface Desensitization {
    DesensitizationTypeEnum type() default DesensitizationTypeEnum.MY_RULE;

    int startInclude() default 0;

    int endExclude() default 0;
}
