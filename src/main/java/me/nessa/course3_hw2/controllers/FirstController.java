package me.nessa.course3_hw2.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class FirstController {

    @GetMapping
    public String helloWorld() {
        return "Приложение запущено";
    }

    @GetMapping("/info")
    public String info() {
        return "Ванесса " +
                "Проект: Книга рецептов " +
                "Дата создания: 02/01/2023 " +
                "Книга вкуснейших рецептов";
    }
}
