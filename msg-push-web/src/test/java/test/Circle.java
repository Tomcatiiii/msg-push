package test;

import lombok.Getter;

public final class Circle {
    private double radius;

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
