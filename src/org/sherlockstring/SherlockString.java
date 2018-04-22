package org.sherlockstring;

import java.util.ArrayList;
import java.util.Scanner;

public class SherlockString {
	public static void main(String[] args) {
		System.out.print("Please enter a string to test: ");
		Scanner in = new Scanner(System.in);
        String s = in.next();
        String result = isValid(s);
        System.out.println(result);
	}
	
	public static String isValid(String s) {
		ArrayList<Integer> match = new ArrayList<Integer>(); 
		String valid = "";
		int matched;
		int indexAt = 0;
		int count = 0;
		int subtract = 0;
		int addSub = 0;
		
		for(int i = 0; i < s.length();) {
			matched = 0;
			for(int j = 0; j < s.length(); j++) {
				if(s.charAt(i) == s.charAt(j)) {
					matched++;
					indexAt++;
				}
			}
			if(matched < 2) {
				indexAt += 1;
				i++;
			} else {
				match.add(matched);
				count += matched;
				i = indexAt;
			}
		}
		
		for(int k = 0; k < match.size()-1; k++) {
			subtract = match.get(k) - match.get(k+1);
			subtract = Math.abs(subtract);
			addSub += subtract;
		}
		
		if(s.length() < 2) {
			valid = "YES";
		}
		else if(match.size() < 2 && match.get(0) < 3) {
			valid = "YES";
		}
		else if(addSub == 1 && count == s.length()) {
			valid = "YES";
		}
		else if(addSub == 0 && s.length() - count <= 1) {
			valid = "YES";
		}
		else {
			valid = "NO";
		}
		
		return valid;
	}
}
