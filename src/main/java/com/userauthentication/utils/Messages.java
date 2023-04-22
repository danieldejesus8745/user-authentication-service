package com.userauthentication.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Error when trying to authenticate user"),
    MESSAGE_2("User not found"),
    MESSAGE_3("Invalid credential");

    private final String message;

}
