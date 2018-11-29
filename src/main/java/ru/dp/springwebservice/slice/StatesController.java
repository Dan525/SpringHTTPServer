package ru.dp.springwebservice.slice;

import java.util.ArrayList;
import javax.xml.bind.JAXBException;
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
    
    private static final double TOLERANCE_1 = 0.03;
    private static final double TOLERANCE_2 = 0.1;

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

    private int measureCounter;
    private int repeatsCount = 1;

    private double vol;
    private double cur;
    private double tolerance;

    public StatesController() {
        this.subscribers = new ArrayList<String>();
    }

    @RequestMapping("/subscribe")
    public String subscribe(@RequestParam(value = "id", required = true) String id) {
        subscribers.add(id);
        return "Added new subscriber: " + id;
    }

    @RequestMapping("/states")
    public State[] states() throws JAXBException {

        State[] states = new State[subscribers.size()];
        StateFactory factory = new StateFactory();
        int indexDefStates = measureCounter / repeatsCount;
        
        vol = DEFAULT_STATES[indexDefStates * 2];
        cur = DEFAULT_STATES[(indexDefStates * 2) + 1];
        
        double a = ((double)indexDefStates)/((double)(DEFAULT_STATES.length / 2));
        tolerance = (TOLERANCE_2 - TOLERANCE_1)*a + TOLERANCE_1;
        
        for (int i = 0; i < subscribers.size(); i++) {
            StateInterface si = factory.createState(subscribers.get(i).split("_")[3], this);
            double minValue = si.generateMinValue();
            double maxValue = si.generateMaxValue();
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

    public double getTolerance() {
        return tolerance;
    }
}
