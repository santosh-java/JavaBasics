package com.oracle.practice.programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FindPointsWithinDistance {

	public static void main(String[] args) {
		FindPointsWithinDistance fpwd = new FindPointsWithinDistance();
		List<Point> pointsList = Arrays.asList(new Point(1, 1), new Point(2, 2), new Point(3, 3), new Point(4, 4));
		Point fromPoint = new Point(5, 5);
		List<Point> pointsWithinDisance = fpwd.getPointsWithinDisance(pointsList, fromPoint, 3);

		pointsWithinDisance.stream().forEach(System.out::println);
	}

	public List<Point> getPointsWithinDisance(List<Point> pointsList, Point fromPoint, double distance) {
		List<Point> pointsWithinDistance = new ArrayList<Point>();

		pointsWithinDistance = pointsList.stream().filter(point -> fromPoint.isWithinDistance(point, distance))
				.collect(Collectors.toList());

		return pointsWithinDistance;
	}

}
