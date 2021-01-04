package com.alikn.demo.exception;

import com.alikn.demo.EmailValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ApiExceptionHandlerTest {

    private final EmailValidator underTest = new EmailValidator();

    @Test
    public void itShouldValidateCorrectEmail() {
        assertThat(underTest.test("hello@gmail.com")).isTrue();
    }

    @Test
    public void itShouldValidateAnIncorrectEmail() {
        assertThat(underTest.test("hello.com")).isFalse();
    }

    @Test
    public void itShouldValidateWithoutDotEmail() {
        assertThat(underTest.test("hello@com")).isFalse();
    }

}