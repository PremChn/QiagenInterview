package com.Qiagen.interview;

import java.util.Scanner;

/*Find the smallest distance between two neighboring numbers in an array
Implement a Java function that finds two neighboring numbers in an array with the smallest distance to each other. 
The function should return the index of the first number. In the sequence 4 8 6 1 2 9 4 the minimum distance is 1
(between 1 and 2). The function should return the index 3 (of number 1). */

public class smallestDistance {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter array size:");
		int N = in.nextInt();
		System.out.println("Enter array elements");
		int array[] = new int[N];
		for (int i = 0; i < N; i++) {
			array[i] = in.nextInt();
		}
		System.out.println("The array index of smallest distance between two neighboring numbers: "
				+ findSmallestDistance(array));
		in.close();
	}

	public static int findSmallestDistance(int[] inputArray) {
		int arrayIndex = 0;
		int difference, leastDifference;
		// To get the difference between first and second numbers in the array
		// If statement is used to avoid getting a negative value during subtraction
		if (inputArray[0] > inputArray[0 + 1]) {
			leastDifference = inputArray[0] - inputArray[0 + 1];
		} else {
			leastDifference = inputArray[0 + 1] - inputArray[0];
		}
		// To find the difference between neighboring numbers
		for (int i = 1; i < inputArray.length - 1; i++) {
			if (inputArray[i] > inputArray[i + 1]) {
				difference = inputArray[i] - inputArray[i + 1];
			} else {
				difference = inputArray[i + 1] - inputArray[i];
			}
			if (difference < leastDifference) {
				leastDifference = difference;
				arrayIndex = i;
			}
		}
		return arrayIndex;
	}
}
