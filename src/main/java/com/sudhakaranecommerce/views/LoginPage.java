package com.sudhakaranecommerce.views;

import com.sudhakaranecommerce.utils.StringUtil;

import static com.sudhakaranecommerce.utils.AppOutput.println;

public class LoginPage {
    public void printInvalidCredentials() {
        println(StringUtil.INVALID_CREDENTIALS);
    }

    public void loginSuccess() {
        println(StringUtil.LOGIN_SUCCESS);
    }
}
