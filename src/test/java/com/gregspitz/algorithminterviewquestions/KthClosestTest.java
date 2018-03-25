package com.gregspitz.algorithminterviewquestions;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class KthClosestTest {

    @Test
    public void find3PointsClosestToOrigin() {
        Point[] points = { new Point(0, 1), new Point(3, 4), new Point(5, 6), new Point(1, 2),
                new Point(1, 0)};
        List<Point> closestPoints = KthClosest.find(points, 3);
        assertThat(closestPoints, containsInAnyOrder(new Point(1, 2), new Point(0, 1), new Point(1, 0)));
    }
}
