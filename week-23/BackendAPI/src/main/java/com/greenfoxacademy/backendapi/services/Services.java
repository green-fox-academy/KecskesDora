package com.greenfoxacademy.backendapi.services;

import com.greenfoxacademy.backendapi.models.entities.ArrayHandler;
import com.greenfoxacademy.backendapi.models.entities.DoUntil;
import org.springframework.stereotype.Service;

@Service
public class Services {

    public Services() {

    }

    public int action(DoUntil until, String action) {
        int result = 0;
        if (action.equals("sum")) {
            result = until.sum();
        } else if (action.equals("factor")) {
            result = until.factor();
        }
        return result;
    }

    public int arrayHandler(ArrayHandler handler, String action) {
        int result = 0;
        if (action.equals("sum")) {
            result = handler.sumElements();
        } else if (action.equals("multiply")) {
            result = handler.multiplyElements();
        }
        return result;
    }

    public int[] doubleElements(ArrayHandler handler) {
        return handler.doubleElements();
    }
}
