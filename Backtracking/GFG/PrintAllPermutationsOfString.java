import java.util.*;
import java.lang.*;
import java.io.*;

//Time complexity: O(n*n!) for n! permutations it takes n time to print string
public class PrintAllPermutationsOfString {
	private PrintAllPermutationsOfString() {
	}

	public static void permutate(char[] str, int left, int right) {
		if(left == right) {
			System.out.println(new String(str));
		} else {
			for(int i=left; i<=right; i++) {
				swap(str, i, left);
				permutate(str, left+1, right);
				swap(str, i, left);
			}
		}
	}

	private static void swap(char[] str, int i, int j) {
		char temp = str[i];
		str[i] = str[j];
		str[j] = temp;
	}
}