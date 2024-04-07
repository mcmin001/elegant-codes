package com.elegant.codes.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;

@Target({FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DDLColumn {
    /**
     * 字段名称
     * 如果不设置值，则默认会用注解的字段名称，且把驼峰转化为下划线格式
     * @return
     */
    String columnName() default "";

    /**
     * 字段数据类型
     * 如果不设置，则默认会用字段对应的java数据类型映射为对应的数据库字段类型
     * @return
     */
    String columnDataType() default "";

    /**
     * 默认为-1表示不设置精度
     * @return
     */
    String precision() default "-1";

    /**
     * 默认为-1表示不设置小数位数
     * @return
     */
    String scale() default "-1";

    /**
     * 是否可为空
     * @return
     */
    boolean defaultNull() default true;

    /**
     * 字段默认值
     * @return
     */
    String defaultValue() default "";

    /**
     * 是否是主键
     * @return
     */
    boolean primaryKey() default false;
}
