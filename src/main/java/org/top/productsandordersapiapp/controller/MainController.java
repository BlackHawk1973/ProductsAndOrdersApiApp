package org.top.productsandordersapiapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//Объявление класса MainController. Тип класса  RestController
@RestController
public class MainController {

    @GetMapping("")
    public String index() {
        return "Server is running";
    } //Вывод сообщения при запуске корневой страницы веб-приложения

    @GetMapping("ping")
    public String ping() {
        return "pong";
    } ////Вывод тестового сообщения при запуске страницы "ping" веб-приложения
}
