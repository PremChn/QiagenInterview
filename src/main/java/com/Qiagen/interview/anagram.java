package com.Qiagen.interview;

import java.util.Arrays;
import java.util.Scanner;

/*Check for anagrams
An anagram is a word or a phrase that can be created by rearranging the letters of another given word or phrase. 
We ignore white spaces and letter case. The all letters of "Desperation" can be rearranged to the phrase "A Rope Ends It". 
Implement a Java program that checks the given Strings to determine whether one is an anagram of the other. */

public class anagram {
	public static void main(String args[]) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter first String:");
		String String1 = in.nextLine();
		System.out.println("Enter second string:");
		String String2 = in.nextLine();
		in.close();
		if (findAnagram(String1, String2)) {
			System.out.println("The given strings are anagrams");
		} else {
			System.out.println("The given strings are not an anagrams");
		}
	}

	public static boolean findAnagram(String S1, String S2) {
		boolean IsAnagram;
		// To remove white spaces
		S1 = S1.replaceAll(" ", "");
		S2 = S2.replaceAll(" ", "");

		// set the status to false, if the length of S1 and S2 are not equal
		if (S1.length() != S2.length()) {
			IsAnagram = false;
		} else {
			char[] S1Array = S1.toUpperCase().toCharArray();
			char[] S2Array = S2.toUpperCase().toCharArray();
			Arrays.sort(S1Array);
			Arrays.sort(S2Array);
			IsAnagram = (Arrays.equals(S1Array, S2Array));
		}
		return IsAnagram;
	}
}