package ru.dp.springwebservice.slice;

import java.util.concurrent.ThreadLocalRandom;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author daniil_pozdeev
 */
public class State {
    private String id;
    private String type;
    private Object data;
    private boolean good;
    private boolean invalid;
    private boolean quest;
    
    State(String id, double minData, double maxData) {
        this.id = id;
        this.type = "Float";
        this.data = createData(minData, maxData);
        this.good = true;
        this.invalid = false;
        this.quest = false;
    }
    
    private double createData(double min, double max) {
        return ThreadLocalRandom.current().nextDouble(min, max);
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the data
     */
    public Object getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * @return the good
     */
    public boolean isGood() {
        return good;
    }

    /**
     * @param good the good to set
     */
    public void setGood(boolean good) {
        this.good = good;
    }

    /**
     * @return the invalid
     */
    public boolean isInvalid() {
        return invalid;
    }

    /**
     * @param invalid the invalid to set
     */
    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    /**
     * @return the quest
     */
    public boolean isQuest() {
        return quest;
    }

    /**
     * @param quest the quest to set
     */
    public void setQuest(boolean quest) {
        this.quest = quest;
    }
}
