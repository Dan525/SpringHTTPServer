/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dp.springwebservice.slice.stateImpls.stateTypes;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author daniil_pozdeev
 */
public class StateTypesConvert {
    
    public void marshal() throws JAXBException {
        StateTypesMap stm = new StateTypesMap();
        Map<String, Integer> types = new HashMap<>();
        types.put("ZF0017", 1);
        types.put("ZF0021", 2);
        stm.setStateTypesMap(types);
        
        JAXBContext jaxbContext = JAXBContext.newInstance(StateTypesMap.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        
        ClassLoader cl = getClass().getClassLoader();
        jaxbMarshaller.marshal(stm, new File("d:/employees.xml"));
    }
    
    public StateTypesMap unmarshal() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(StateTypesMap.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        
        ClassLoader cl = getClass().getClassLoader();
        return (StateTypesMap) jaxbUnmarshaller.unmarshal(new File(cl.getResource("StateTypes.xml").getFile()));
    }
    
}
