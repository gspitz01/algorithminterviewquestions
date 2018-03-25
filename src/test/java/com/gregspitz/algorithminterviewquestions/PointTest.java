package com.gregspitz.algorithminterviewquestions;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class PointTest {

    @Test
    public void equalPoints_areEqual() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        assertEquals(point1, point2);
    }

    @Test
    public void pointsDifferByY_areUnequal() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 3);
        assertNotEquals(point1, point2);
    }

    @Test
    public void pointsDifferByX_areUnequal() {
        Point point1 = new Point(2, 2);
        Point point2 = new Point(1, 2);
        assertNotEquals(point1, point2);
    }

    @Test
    public void equalPoints_haveSameHashcode() {
        Point point1 = new Point(1, 2);
        Point point2 = new Point(1, 2);
        assertEquals(point1.hashCode(), point2.hashCode());
    }

    @Test
    public void unequalPoints_haveDifferentHashcodes() {
        Point point1 = new Point(3, 3);
        Point point2 = new Point(1, 2);
        assertNotEquals(point1.hashCode(), point2.hashCode());
    }

    @Test
    public void nullObject_notEqual() {
        Point point1 = new Point(1, 2);
        Point point2 = null;
        assertNotEquals(point1, point2);
    }

    @Test
    public void notAPoint_notEqual() {
        Point point1 = new Point(1, 2);
        String point2 = "Not a point";
        assertNotEquals(point1, point2);
    }

    @Test
    public void sameInstance_isEqual() {
        Point point1 = new Point(1, 2);
        Point point2 = point1;
        assertEquals(point1, point2);
    }
}
