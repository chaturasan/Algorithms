/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class KnapSackDP {
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine().trim());
		while(t-- > 0) {
		    int n = Integer.parseInt(scanner.nextLine().trim());
			int W = Integer.parseInt(scanner.nextLine().trim());
			String[] valueValues = new String[n];
		    String[] weightValues = new String[n];
			valueValues = scanner.nextLine().trim().split(" ");
			weightValues = scanner.nextLine().trim().split(" ");
		    int[] values = new int[n];
			int[] weights = new int[n];
		    for(int i=0; i< n; i++) {
				values[i] = Integer.parseInt(valueValues[i]);
		        weights[i] = Integer.parseInt(weightValues[i]);
		    }
		    
		    
		    int[][] knapsack = new int[n+1][W+1];
		    
		    for(int i=0; i<= n; i++) {
		        for(int j = 0; j<= W; j++) {
		            if(i==0 || j==0) {
		                knapsack[i][j] = 0;
		            } else if(weights[i-1] <= j) {
		                knapsack[i][j] = Math.max(knapsack[i-1][j-weights[i-1]] + values[i-1], knapsack[i-1][j]);   
		            } else {
		                knapsack[i][j] = knapsack[i-1][j];
		            }
		        }
		    }
		    
		    System.out.println(knapsack[n][W]);
		    
	    }
	}
}