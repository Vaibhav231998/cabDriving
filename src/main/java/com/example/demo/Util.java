package com.example.demo;

public class Util {

    // Utility method to check if a point is within a certain range of another point
    public static boolean isWithinRange(int[] point1, int[] point2, int range) {
        int distance = (int) Math.sqrt(Math.pow(point1[0] - point2[0], 2) + Math.pow(point1[1] - point2[1], 2));
        return distance <= range;
    }

}
