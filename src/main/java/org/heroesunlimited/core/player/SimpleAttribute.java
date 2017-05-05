package org.heroesunlimited.core.player;

public class SimpleAttribute {
    public SimpleAttribute() {
    }

    public SimpleAttribute(int initial) {
        this.initial = initial;
        this.current = initial;
    }

    public int getInitial() {
        return initial;
    }

    public void setInitial(int initial) {
        this.initial = initial;
    }

    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public void damage(Integer amount) {
        current -= amount;
        if(current < 0) current = 0;
    }

    public void heal(Integer amount) {
        current += amount;
        if(current > initial) current = initial;
    }

    private int initial;
    private int current;
}
