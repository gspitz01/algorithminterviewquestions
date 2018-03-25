package com.gregspitz.algorithminterviewquestions;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class KthClosest {

    public static List<Point> find(Point[] points, int k) {
        List<PythagPoint> pythagPoints = Arrays.stream(points)
                .map(point -> new PythagPoint(pythagorean(point.getX(), point.getY()), point))
                .collect(Collectors.toList());

        PriorityQueue<PythagPoint> maxHeap = new PriorityQueue<>(k, Collections.reverseOrder());
        for (int i = 0; i < k; i++) {
            maxHeap.add(pythagPoints.get(i));
        }
        for (int i = k; i < pythagPoints.size(); i++) {
            if (pythagPoints.get(i).compareTo(maxHeap.peek()) == -1) {
                maxHeap.poll();
                maxHeap.add(pythagPoints.get(i));
            }
        }
        return maxHeap.stream()
                .map(pythagPoint -> pythagPoint.getPoint())
                .collect(Collectors.toList());
    }

    public static double pythagorean(double a, double b) {
        return Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
    }

    private static class PythagPoint implements Comparable<PythagPoint> {
        private double absDistance;
        private Point point;

        public PythagPoint(double absDistance, Point point) {
            this.absDistance = absDistance;
            this.point = point;
        }

        public double getAbsDistance() {
            return absDistance;
        }

        public Point getPoint() {
            return point;
        }

        @Override
        public int compareTo(PythagPoint o) {
            if (this.getAbsDistance() > o.getAbsDistance()) return 1;
            if (this.getAbsDistance() < o.getAbsDistance()) return -1;
            else return 0;
        }
    }
}
