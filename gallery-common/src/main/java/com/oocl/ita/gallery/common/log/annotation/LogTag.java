package com.oocl.ita.gallery.common.log.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogTag {

  public static final String DEFAULT_TAG = "DEFAULT_TAG";

  String value() default DEFAULT_TAG;

}
