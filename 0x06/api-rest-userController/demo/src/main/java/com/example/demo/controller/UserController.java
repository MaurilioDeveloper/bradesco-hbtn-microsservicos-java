package com.example.demo.controller;

import com.example.demo.exception.CPFException;
import com.example.demo.exception.UserIdException;
import com.example.demo.exception.UserNameException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    @GetMapping("/user-id/{id}")
    public String findUserById(@PathVariable int id) {

        String msg;

        if (id > 0 && id < 100) {
            msg = "You have entered valid ID";
        } else {
            // lança exceção customizada
            throw new UserIdException(String.valueOf(id));
        }

        return msg;
    }

    @GetMapping("/user-name/{userName}")
    public String findUserByName(@PathVariable String userName) {

        String msg;
        int length = userName != null ? userName.length() : 0;

        if (length > 3 && length < 15) {
            msg = "You have entered valid USERNAME";
        } else {
            throw new UserNameException(userName);
        }

        return msg;
    }

    @GetMapping("/user-cpf/{cpf}")
    public String findUserByCPF(@PathVariable String cpf) {

        String msg;
        boolean isCPFValid = isCPF(cpf);

        if (isCPFValid) {
            msg = "You have entered valid CPF";
        } else {
            throw new CPFException(cpf);
        }

        return msg;
    }

    public boolean isCPF(String CPF) {
        if (CPF == null) {
            return false;
        }
        int length = CPF.length();
        // Regra pedida: maior que 3 e menor que 15 caracteres
        return length > 3 && length < 15;
    }

}
