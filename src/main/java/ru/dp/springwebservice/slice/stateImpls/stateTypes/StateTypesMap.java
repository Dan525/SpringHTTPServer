/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dp.springwebservice.slice.stateImpls.stateTypes;

import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author daniil_pozdeev
 */

@XmlRootElement (name = "state-types")
@XmlAccessorType(XmlAccessType.FIELD)
public class StateTypesMap {
    
    private Map<String, Integer> stateTypesMap = new HashMap<>();

    public Map<String, Integer> getStateTypesMap() {
        return stateTypesMap;
    }

    public void setStateTypesMap(Map<String, Integer> stateTypesMap) {
        this.stateTypesMap = stateTypesMap;
    }
}
