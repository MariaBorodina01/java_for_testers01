package ru.stqa.geometry.figures;

//import static com.sun.org.apache.xalan.internal.lib.ExsltMath.sqrt


public class Triangle {
    private double a;
    private double b;
    private double c;

    public Triangle(double sideA, double sideB, double sideC){
        this.a = sideA;
        this.b = sideB;
        this.c = sideC;

        if (this.a < 0 || this.b < 0 || this.c < 0) {
            throw new IllegalArgumentException("Triangle side should be non-negative");
        }

        if (this.a == 0 || this.b == 0 || this.c == 0) {
            throw new IllegalArgumentException("Triangle side should be zero");
        }

        if (this.a > this.b + this.c || this.b > this.a + this.c || this.c > this.a + this.b) {
            throw new IllegalArgumentException("The sum of two sides of triangle should not be less than the third side");
        }
    }

    public double area() {
        double p = perimeter()/2;
        return Math.sqrt((p * (p - a) * (p - b) * (p - c)));
    }

    public double perimeter() {
        return this.a + this.b + this.c;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Triangle triangle = (Triangle) o;
        return ((Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.c) == 0)
                || (Double.compare(this.a, triangle.b) == 0 && Double.compare(this.b, triangle.c) == 0 && Double.compare(this.c, triangle.a) == 0 )
                || (Double.compare(this.a, triangle.c) == 0 && Double.compare(this.b, triangle.a) == 0 && Double.compare(this.c, triangle.b) == 0 )
                || (Double.compare(this.a, triangle.a) == 0 && Double.compare(this.b, triangle.c) == 0 && Double.compare(this.c, triangle.b) ==0)
                || (Double.compare(this.a, triangle.c) == 0 && Double.compare(this.b, triangle.b) == 0 && Double.compare(this.c, triangle.a) == 0)
        );
    }

    @Override
    public int hashCode() {
        return 1;
    }
}
