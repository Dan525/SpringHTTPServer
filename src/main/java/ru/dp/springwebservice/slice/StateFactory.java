/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dp.springwebservice.slice;

import ru.dp.springwebservice.slice.stateImpls.AngleState;
import ru.dp.springwebservice.slice.stateImpls.MeasureCurrentState;
import ru.dp.springwebservice.slice.stateImpls.VoltageState;
import ru.dp.springwebservice.slice.stateImpls.WorkingCurrentState;

/**
 *
 * @author daniil_pozdeev
 */
public class StateFactory {
    
    
    public static StateInterface createState(int i, StatesController sc) {
        if (i < 4) {
            return new VoltageState(sc);
        } else if (i > 7 && i < 12) {
            return new WorkingCurrentState(sc);
        } else if (i > 11 && i < 16) {
            return new MeasureCurrentState(sc);
        } else {
            return new AngleState(sc);
        }
    }
}
