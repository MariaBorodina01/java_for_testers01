package ru.stqa.geometry.figures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TriangleTests {

    @Test
    void canCalculateArea() {
        var t = new Triangle(3.0, 4.0, 5.0);
        var result = t.area();
        Assertions.assertEquals(6.0, result);
    }

    @Test
    void canCalculatePerimetr() {
        var t = new Triangle(3.0, 4.0, 5.0);
        Assertions.assertEquals(12.0, t.perimeter());
    }

    @Test
    void cannotCreateTriangleWithNegativeSide() {
        try {
            new Triangle(-5.0, 3.0, 2.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
//            OK
        }
    }

    @Test
    void cannotCreateTriangleWithOneSideLongerThanSumOfTwoOtherSides() {
        try {
            new Triangle(13.0, 3.0, 4.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
            System.out.println( "not OK ");
//            OK
        }
    }

    @Test
    void cannotCreateTriangleWithNullSide() {
        try {
            new Triangle(0.0, 3.0, 2.0);
            Assertions.fail();
        } catch (IllegalArgumentException exception) {
//            OK
        }
    }

    @Test
    void testEquality(){
        var t1 = new Triangle(5.0, 4.0, 3.0);
        var t2 = new Triangle(5.0, 4.0, 3.0);
        Assertions.assertEquals(t1, t2);
    }

    @Test
    void testEquality2(){
        var a = 2;
        var b = 3;
        var c = 4;

        var triangle = new Triangle(a, b, c);
        var triangle1 = new Triangle(c, b, a);
        var triangle = new Triangle(b, c, a);
        var triangle = new Triangle(a, c, b);
        var triangle = new Triangle(b, a, c);


        Assertions.assertEquals(triangle, triangle1);

    }
}
