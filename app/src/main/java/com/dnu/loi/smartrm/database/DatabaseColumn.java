package com.dnu.loi.smartrm.database;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DatabaseColumn
{
    Class classCustom() default Object.class;

    String columnName();

    boolean hasAutoIncrement() default false;

    boolean isEnableCustom() default false;

    boolean isPrimaryKey() default false;
}
