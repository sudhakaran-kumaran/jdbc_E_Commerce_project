package com.sudhakaranecommerce;


import com.sudhakaranecommerce.controllers.AppController;

public class Main {
    public static void main(String[] args) {

        AppController appController = new AppController();
        appController.initiate();
    }
}