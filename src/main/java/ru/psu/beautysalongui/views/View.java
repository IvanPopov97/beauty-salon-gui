package ru.psu.beautysalongui.views;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import static org.springframework.beans.factory.config.BeanDefinition.SCOPE_PROTOTYPE;

@Target(TYPE)
@Retention(RUNTIME)
@Component
@Scope(SCOPE_PROTOTYPE)
public @interface View {}
