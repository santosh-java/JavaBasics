package com.oracle.practice.programming;

public class Point {
	private int x;
	private int y;

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double getDistanceFrom(Point p) {
		if (p == null) {
			throw new IllegalArgumentException("Passed in point cannot be null!!!");
		}
 
		return Math.sqrt(Math.pow(p.getX() - x, 2) + Math.pow(p.getY() - y, 2));
	}

	public boolean isWithinDistance(Point p, double distance) {
 		return getDistanceFrom(p) <= distance;
	}

	public String toString() {
		return "[" + x + "," + y + "]";
	}
}
