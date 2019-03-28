package com.oocl.ita.gallery.common.log.annotation;

import com.oocl.ita.gallery.common.log.config.RuntimeLoggerConfiguration;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import({ RuntimeLoggerConfiguration.class })
public @interface EnableRuntimeLogger {
}
