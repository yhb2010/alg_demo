package com.demo.alg.chapter16.activitySelection;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		int s[] = { -1, 2, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int f[] = { -1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

		List<Integer> ret = new ArrayList<Integer>();
		ActivitySelection.recursive_activity_selector(s, f, 0, 11, ret);
		for (Integer i : ret) {
			System.out.print("a" + i + " ");
		}

		System.out.println();
		
		int s2[] = { -1, 2, 3, 0, 5, 3, 5, 6, 8, 8, 2, 12 };
		int f2[] = { -1, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14 };

		List<Integer> ret2 = ActivitySelection2.recursive_activity_selector(s2,
				f2);
		for (Integer i : ret2) {
			System.out.print("a" + i + " ");
		}
	}

}
