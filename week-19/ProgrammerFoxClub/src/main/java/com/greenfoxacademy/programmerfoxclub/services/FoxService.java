package com.greenfoxacademy.programmerfoxclub.services;

import com.greenfoxacademy.programmerfoxclub.models.Fox;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class FoxService {
    private List<Fox> foxes;

    private FoxService() {
        foxes = new ArrayList<>();
        foxes.add(new Fox("Vuk","duck", "water"));
        foxes.add(new Fox("Csele","chicken","water"));
        foxes.add(new Fox("Karak"));
    }

    public void add(String name) {
        if (find(name) == null) {
        foxes.add(new Fox(name));
        }
    }

    public Fox find(String name) {
        for (Fox fox : foxes) {
            if (fox.getName().equalsIgnoreCase(name)) {
                return fox;
            }
        }
        return null;
    }

    public String date() {
        Date date = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("yyyy. MMMMMMMM dd. hh:mm:ss ");
        return ft.format(date).toString().toLowerCase();
        /*LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return now.format(formatter);*/
    }

    public void changeAndTrackFood(String food, String name) {
        if (!find(name).getFood().equals(food)) {
            find(name).addAction(date() + " : Food has been changed from: " + find(name).getFood() + " to: " + food);
            find(name).setFood(food);
        }
    }

    public void changeAndTrackDrink(String drink, String name) {
        if (!find(name).getDrink().equals(drink)) {
            find(name).addAction(date() + " : Drink has been changed from: " + find(name).getDrink() + " to: " + drink);
            find(name).setDrink(drink);
        }
    }

    public void addAndTrackNewTrick(String trick, String name) {
        find(name).addAction(date() + " : Learned to: " + trick);
        find(name).setTricks(trick);
    }

    /*public List<String> tricksToLearn(String name) {
        return find(name).tricksToLearn();
    }*/
}

