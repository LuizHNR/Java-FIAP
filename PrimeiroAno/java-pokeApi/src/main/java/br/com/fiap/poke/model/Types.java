package br.com.fiap.poke.model;

import java.util.ArrayList;

public class Types {
    private int slot;
    private Type type;

    @Override
    public String toString() {
        return "" + type;
    }

    public int getSlot() {
        return slot;
    }

    public void setSlot(int slot) {
        this.slot = slot;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
