/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dp.springwebservice.slice;

import javax.xml.bind.JAXBException;
import ru.dp.springwebservice.slice.stateImpls.AngleState;
import ru.dp.springwebservice.slice.stateImpls.MeasureCurrentState;
import ru.dp.springwebservice.slice.stateImpls.VoltageState;
import ru.dp.springwebservice.slice.stateImpls.WorkingCurrentState;
import ru.dp.springwebservice.slice.stateImpls.stateTypes.StateTypesConvert;
import ru.dp.springwebservice.slice.stateImpls.stateTypes.StateTypesMap;

/**
 *
 * @author daniil_pozdeev
 */
public class StateFactory {

    private StateTypesMap stm;

    public StateFactory() throws JAXBException {
        StateTypesConvert stc = new StateTypesConvert();
        stm = stc.unmarshal();
    }

    public StateInterface createState(String id, StatesController sc) {
        switch (stm.getStateTypesMap().get(id)) {
            case 1:
                return new VoltageState(sc);
            case 2:
                return new WorkingCurrentState(sc);
            case 3:
                return new MeasureCurrentState(sc);
            default:
                return new AngleState(sc);
        }
    }
}
