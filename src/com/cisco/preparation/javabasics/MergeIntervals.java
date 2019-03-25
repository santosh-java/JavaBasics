package com.cisco.preparation.javabasics;

import java.util.ArrayList;

/**
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Given intervals [1,3],[6,9] insert and merge [2,5] would result in
 * [1,5],[6,9].
 * 
 * Example 2:
 * 
 * Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] would result
 * in [1,2],[3,10],[12,16].
 * 
 * This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].
 * 
 * Make sure the returned intervals are also sorted.
 * 
 * @author MSantoshGiriGovind
 *
 */
public class MergeIntervals {
	public static void main(String[] args) {
		// int[] starts = { 1, 3, 6, 8, 12 };
		// int[] ends = { 2, 5, 7, 10, 16 };
		// int[] starts = { 3, 6, 8, 12 };
		// int[] ends = { 5, 7, 10, 16 };
		int[] starts = { 3, 6, 8, 12 };
		int[] ends = { 5, 7, 10, 16 };

		ArrayList<Interval> input = getIntervalList(starts, ends);
		MergeIntervals mi = new MergeIntervals();
		printList(mi.insert(input, new Interval(17, 18)));
		System.out.println("2nd");
		printList(mi.insert(input, new Interval(13, 18)));

	}

	private static void printList(ArrayList<Interval> intervals) {
		for (Interval i : intervals) {
			System.out.print(i + ", ");
		}
	}

	private static ArrayList<Interval> getIntervalList(int[] starts, int[] ends) {
		ArrayList<Interval> result = new ArrayList<>();
		for (int i = 0; i < starts.length; i++) {
			result.add(new Interval(starts[i], ends[i]));
		}
		return result;
	}

	public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
		ArrayList<Interval> result = new ArrayList<Interval>();
		if (intervals.size() == 0) {
			result.add(newInterval);
			return result;
		}

		if (intervals.size() == 1) {
			result.add(new Interval(Math.max(intervals.get(0).start, newInterval.start),
					Math.max(intervals.get(0).end, newInterval.end)));
			return result;
		}

		int startIndex = 0;
		for (Interval i : intervals) {
			if (newInterval.start > i.start) {
				startIndex++;
			} else {
				break;
			}
		}

		int endIndex = startIndex-1;
		
		for (int i = startIndex-1; i < intervals.size(); i++) {
			if (newInterval.end >= intervals.get(i).end) {
				endIndex++;
			} else {
				break;
			}
		}

		if (endIndex == -1) {
			endIndex = 0;
		}

		if (startIndex == 0 && endIndex == 0) {
			result.add(newInterval);
		}

		for (int i = 0; i < intervals.size(); i++) {
			if (i < startIndex)
				result.add(intervals.get(i));
			else {
				if (i <= endIndex) {
					if (endIndex < intervals.size()) {
						result.add(new Interval(intervals.get(i).start, intervals.get(endIndex).end));
						i += (endIndex - startIndex);
					} else {
						result.add(new Interval(intervals.get(i).start, newInterval.end));
					}
				} else {
					result.add(intervals.get(i));
				}
			}
		}

		if (startIndex == intervals.size() && endIndex == intervals.size()) {
			result.add(newInterval);
		}

		return result;
	}
}

class Interval {
	int start;
	int end;

	Interval() {
		start = 0;
		end = 0;
	}

	Interval(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return "[" + start + "," + end + "]";
	}
}
