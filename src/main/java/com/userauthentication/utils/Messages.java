package com.userauthentication.utils;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Messages {

    MESSAGE_1("Error when trying to authenticate user");

    private final String message;

}
