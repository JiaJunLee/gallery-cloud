package com.oocl.ita.gallery.common.log.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface LogRuntimeLogger {

  String topic() default "";

}
