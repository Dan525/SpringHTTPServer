/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.dp.springwebservice.slice;

import javax.xml.bind.JAXBException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

/**
 *
 * @author daniil_pozdeev
 */
@ComponentScan
@EnableAutoConfiguration
public class App {
    public static void main(String[] args) throws JAXBException {
        SpringApplication.run(App.class, args);
    }
}
