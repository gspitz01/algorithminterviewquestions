package com.gregspitz.algorithminterviewquestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthClosest {

    public static final String K_TOO_LARGE_MESSAGE = "K must be less than array size.";
    public static final String NULL_ARRAY_MESSAGE = "Null points array.";
    public static final String K_EQUALS_0_MESSAGE = "K must be greater than 0";

    public static List<Point> find(Point[] points, int k) {
        if (points == null) {
            throw new IllegalArgumentException(NULL_ARRAY_MESSAGE);
        }
        if (k == 0) {
            throw new IllegalArgumentException(K_EQUALS_0_MESSAGE);
        }
        if (k > points.length) {
            throw new IllegalArgumentException(K_TOO_LARGE_MESSAGE);
        }
        // Don't need to do this but may as well, to avoid computation
        if (k == points.length) {
            return Arrays.asList(points);
        }

        List<PythagPoint> pythagPoints = Arrays.stream(points)
                .map(PythagPoint::new)
                .collect(Collectors.toList());

        PriorityQueue<PythagPoint> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.add(pythagPoints.get(i));
        }
        for (int i = k; i < pythagPoints.size(); i++) {
            if (pythagPoints.get(i).compareTo(maxHeap.peek()) < 0) {
                maxHeap.poll();
                maxHeap.add(pythagPoints.get(i));
            }
        }
        return maxHeap.stream()
                .map(PythagPoint::getPoint)
                .collect(Collectors.toList());
    }

    static double pythagorean(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    private static class PythagPoint implements Comparable<PythagPoint> {
        private double absDistance;
        private Point point;

        PythagPoint(Point point) {
            this.absDistance = pythagorean(point.getX(), point.getY());
            this.point = point;
        }

        double getAbsDistance() {
            return absDistance;
        }

        Point getPoint() {
            return point;
        }

        @Override
        public int compareTo(PythagPoint o) {
            return Double.compare(this.getAbsDistance(), o.getAbsDistance());
        }
    }
}
