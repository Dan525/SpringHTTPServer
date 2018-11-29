package ru.dp.springwebservice.slice;

import java.util.ArrayList;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniil_pozdeev
 */
@RestController
public class StatesController {
    
    private final ArrayList<String> subscribers;

    private static final double DEFAULT_STATES[] = new double[]{
        150, 1.5,
        145, 1.4,
        140, 1.3,
        130, 1.2,
        120, 1.1,
        100, 1,
        80, 0.9,
        70, 0.8,
        65, 0.75,
        60, 0.7,
        55, 0.65,
        50, 0.6,
        45, 0.55,
        40, 0.5,
        30, 0.45,
        20, 0.4,
        15, 0.3,
        10, 0.2,
        5, 0.1,
        1, 0.01
    };
    
    int measureCounter;
    int repeatsCount = 1;
    
    double vol;
    double cur;
    
    public StatesController() {
        this.subscribers = new ArrayList<String>();
    }
    
    @RequestMapping("/subscribe")
    public String subscribe(@RequestParam(value = "id", required = true) String id) {
        subscribers.add(id);
        return "Added new subscriber: " + id;
    }
    
    @RequestMapping("/states")
    public State[] states() {
        
        State[] states = new State[subscribers.size()];
        
        int indexDefStates = measureCounter / repeatsCount;
        vol = DEFAULT_STATES[indexDefStates * 2];
        cur = DEFAULT_STATES[(indexDefStates * 2) + 1];
        for (int i = 0; i < subscribers.size(); i++) {
            double minValue = StateFactory.createState(i, this).generateMinValue();
            double maxValue = StateFactory.createState(i, this).generateMaxValue();
            
            states[i] = new State(subscribers.get(i), minValue, maxValue);
        }
        subscribers.clear();
        if (measureCounter < ((DEFAULT_STATES.length / 2) - 1) * repeatsCount) {
            measureCounter++;
        } else {
            measureCounter = 0;
        }
        
        return states;
    }

    public double getVol() {
        return vol;
    }

    public double getCur() {
        return cur;
    }
}
