/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dp.springwebservice.slice.stateImpls;

import ru.dp.springwebservice.slice.StateInterface;
import ru.dp.springwebservice.slice.StatesController;

/**
 *
 * @author daniil_pozdeev
 */
public class WorkingCurrentState implements StateInterface {

    private StatesController sc;
    private static final int COEFF = 1;

    public WorkingCurrentState(StatesController sc) {
        this.sc = sc;
    }

    @Override
    public double generateMinValue() {
        return sc.getCur() * COEFF * (1 - sc.getTolerance());
    }

    @Override
    public double generateMaxValue() {
        return sc.getCur() * COEFF * (1 + sc.getTolerance());
    }
    
}
