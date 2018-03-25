package com.gregspitz.algorithminterviewquestions;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsInAnyOrder;

public class KthClosestTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void findSingleClosestPoint() {
        Point[] points = { new Point(0, 1), new Point(3, 5), new Point(6, 7), new Point(0.001, 0.0001),
                new Point(8, 9), new Point(10, 5), new Point(18, 27), new Point(50, 55.5) };

        List<Point> closestPoints = KthClosest.find(points, 1);
        assertThat(closestPoints, containsInAnyOrder(new Point(0.001, 0.0001)));
    }

    @Test
    public void find3PointsClosestToOrigin() {
        Point[] points = { new Point(0, 1), new Point(3, 4), new Point(5, 6), new Point(1, 2),
                new Point(1, 0)};
        List<Point> closestPoints = KthClosest.find(points, 3);
        assertThat(closestPoints, containsInAnyOrder(new Point(1, 2), new Point(0, 1), new Point(1, 0)));
    }

    @Test
    public void kSameSizeAsArray_returnsAllInArray() {
        Point[] points = { new Point(0, 1), new Point(3, 4), new Point(5, 6), new Point(1, 2),
                new Point(1, 0)};
        List<Point> closestPoints = KthClosest.find(points, 5);
        assertThat(closestPoints, containsInAnyOrder(new Point(0, 1), new Point(3, 4),
                new Point(5, 6), new Point(1, 2), new Point(1, 0)));
    }

    @Test
    public void forKGreaterThanArraySize_throwsIllegalArgumentException() {
        Point[] points = { new Point(3, 4), new Point(2, 4), new Point(1, 5) };

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(KthClosest.K_TOO_LARGE_MESSAGE);

        KthClosest.find(points, 5);
    }

    @Test
    public void forNullPointsArray_throwsIllegalArgumentException() {
        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(KthClosest.NULL_ARRAY_MESSAGE);

        KthClosest.find(null, 3);
    }

    @Test
    public void forKEquals0_throwsIllegalArgumentException() {
        Point[] points = { new Point(1, 2), new Point(3, 4) };

        thrown.expect(IllegalArgumentException.class);
        thrown.expectMessage(KthClosest.K_EQUALS_0_MESSAGE);
        KthClosest.find(points, 0);
    }
}
