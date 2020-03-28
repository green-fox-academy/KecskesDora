package com.greenfoxacademy.backendapi;

import com.greenfoxacademy.backendapi.models.entities.DoUntil;
import com.greenfoxacademy.backendapi.models.entities.Until;
import org.springframework.stereotype.Service;

@Service
public class Services {

    public Services() {

    }

    public int action(Until until, String action) {
        int result = 0;
        if (action.equals("sum")) {
            result = until.sum();
        } else if (action.equals("factor")) {
            result = until.factor();
        }
        return result;
    }
}
