package ru.stqa.geometry.figures;

//import static com.sun.org.apache.xalan.internal.lib.ExsltMath.sqrt


public class Triangle {
    private double sideA;
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC){
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;

        if (this.sideA < 0 || this.sideB < 0 || this.sideC < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }

        if (this.sideA == 0 || this.sideB == 0 || this.sideC == 0) {
            throw new IllegalArgumentException("Triangle side should be zero");
        }

        if (this.sideA > this.sideB + this.sideC || this.sideB > this.sideA + this.sideC || this.sideC > this.sideA + this.sideB ) {
            throw new IllegalArgumentException("The sum of two sides of triangle should not be less than the third side");
        }
    }

    public double area() {
        double p = perimeter()/2;
        return Math.sqrt((p * (p - sideA) * (p - sideB) * (p - sideC)));
    }

    public double perimeter() {
        return this.sideA + this.sideB + this.sideC;
    }
}
