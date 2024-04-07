package com.elegant.codes.common.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;

@Target({TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DDLTableName {

    /**
     * java实体对应的数据库表名
     * @return
     */
    String tableName();
}
