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
    }

    public double area() {
        double p = perimeter()/2;
        return Math.sqrt((p * poluperimetrMinusSide(p,sideA) * poluperimetrMinusSide(p,sideB) * poluperimetrMinusSide(p,sideC)));

    }

    private double poluperimetrMinusSide(double p, double side) {
        return p - side;
    }

    public double perimeter() {
        return this.sideA + this.sideB + this.sideC;
    }
}
