package com.greenfoxacademy.backendapi.services;

import com.greenfoxacademy.backendapi.models.entities.DoUntil;
import org.springframework.stereotype.Service;

@Service
public class DoUntilService {

    public int action(DoUntil until, String action) {
        int result = 0;
        if (action.equals("sum")) {
            result = sum(until);
        } else if (action.equals("factor")) {
            result = factor(until);
        }
        return result;
    }

    public int sum(DoUntil doUntil) {
        int counter = 0;
        for (int i = 1; i <= doUntil.getUntil() ; i++) {
            counter += i;
        }
        return counter;
    }

    public int factor(DoUntil doUntil) {
        int factorial = 1;
        for (int i = 1; i <= doUntil.getUntil(); i++) {
            factorial *= i;
        }
        return factorial;
    }
}
