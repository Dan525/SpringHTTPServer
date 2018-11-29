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
public class AngleState implements StateInterface {

    private StatesController sc;

    public AngleState(StatesController sc) {
        this.sc = sc;
    }

    @Override
    public double generateMinValue() {
        return 0;
    }

    @Override
    public double generateMaxValue() {
        return 180;
    }
    
}
