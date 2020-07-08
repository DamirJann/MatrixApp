package model.services;

import model.Rational.Rational;

public class RationalVar {
    public String name;
    public Rational value;

    public RationalVar(String name, Rational value) {
        this.name = name;
        this.value = value;
    }
}
