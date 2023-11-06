package com.sudhakaranecommerce.views;

import com.sudhakaranecommerce.utils.StringUtil;

import static com.sudhakaranecommerce.utils.AppOutput.println;

public class AdminPage {
    public void welcomeMsg() {
        println(StringUtil.ADMIN_WELCOME);
    }

    public void adminMenu() {
        println(StringUtil.ADMIN_CHOICE);
    }
}
