package com.greenfoxacademy.backendapi.services;

import com.greenfoxacademy.backendapi.models.entities.ArrayHandler;
import org.springframework.stereotype.Service;

@Service
public class ArrayHandlerService {

    public int arrayHandler(ArrayHandler handler, String action) {
        int result = 0;
        if (action.equals("sum")) {
            result = sumElements(handler);
        } else if (action.equals("multiply")) {
            result = multiplyElements(handler);
        }
        return result;
    }

    public int[] doubleArrayElements(ArrayHandler handler) {
        int[] doubled = new int[handler.getNumbers().length];
        for (int i = 0; i < handler.getNumbers().length; i++) {
            doubled[i] = handler.getNumbers()[i] * 2;
        }
        return doubled;
    }

    public int sumElements(ArrayHandler handler) {
        int sum = 0;
        for (int element : handler.getNumbers()) {
            sum += element;
        }
        return sum;
    }

    public int multiplyElements(ArrayHandler handler) {
        int multiplication = 1;
        for (int element : handler.getNumbers()) {
            multiplication *= element;
        }
        return multiplication;
    }


}
