/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

public class MinJumps {
    
    private static int minNumberOfJumps(int[] numbers, int n) {
       int[] dp = new int[n];
       
       dp[0] = 0;
       for(int i=1; i < n; i++) {
           dp[i] = Integer.MAX_VALUE;
       }
       
       for(int i=0; i < n; i++) {
           
           if(dp[i] == Integer.MAX_VALUE) return-1;
           
           for(int j=i+1; j< numbers[i] + i + 1 && j < n; j++) {
               dp[j] = Math.min(dp[j], dp[i] + 1);
           }
           
       }
       
       if(dp[n-1] == Integer.MAX_VALUE) return -1;
       
       return dp[n-1];
        
        
    }
    
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine().trim());
		while(t-- > 0) {
		    int n = Integer.parseInt(scanner.nextLine().trim());
		    String[] arrString = new String[n];
		    arrString = scanner.nextLine().trim().split(" ");
		    int[] numbers = new int[n];
		    for(int i = 0; i < n; i++) {
		        numbers[i] = Integer.parseInt(arrString[i]);
		    }
		    
		    System.out.println(minNumberOfJumps(numbers, n));
		}
	}
}