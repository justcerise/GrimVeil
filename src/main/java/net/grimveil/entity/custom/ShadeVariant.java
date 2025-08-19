package net.grimveil.entity.custom;

import java.util.Arrays;
import java.util.Comparator;

public enum ShadeVariant {
    DEFAULT(0),
    CAVE(1);

    private static final ShadeVariant[] BY_ID = Arrays.stream(values()).sorted(Comparator.
            comparingInt(ShadeVariant::getId)).toArray(ShadeVariant[]::new);
    private final int id;

    ShadeVariant(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }

    public static ShadeVariant byId(int id){
        return BY_ID[id % BY_ID.length];
    }
}
