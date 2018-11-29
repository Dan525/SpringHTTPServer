/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dp.springwebservice.slice.stateImpls;

import ru.dp.springwebservice.slice.State;
import ru.dp.springwebservice.slice.StateInterface;
import ru.dp.springwebservice.slice.StatesController;

/**
 *
 * @author daniil_pozdeev
 */
public class VoltageState implements StateInterface {

    private StatesController sc;

    public VoltageState(StatesController sc) {
        this.sc = sc;
    }

    @Override
    public double generateMinValue() {
        return sc.getVol() / 1000 * 0.99;
    }

    @Override
    public double generateMaxValue() {
        return sc.getVol() / 1000 * 1.01;
    }
    
}
