
import java.util.*;
import java.lang.*;
import java.io.*;

public class LongestSequence {
    
    
    private static int longestSequence(int[] sequence, int n, int maxValue) {
        if(n==1)
            return n;
        int val = 1;
        for(int i = 1; i < n; i++) {
            int result = longestSequence(sequence, i, maxValue);
            
            if(sequence[i-1] < sequence[n-1] && result + 1 > val) {
                val = val + 1;
            }
                
        }
        
        if(maxValue < val)
            maxValue = val;
        
        return val;
    }
    
	public static void main (String[] args) {
		Scanner scanner = new Scanner(System.in);
		int t = Integer.parseInt(scanner.nextLine().trim());
		while(t-- > 0) {
		    int n = Integer.parseInt(scanner.nextLine().trim());
		    String[] stringValues = new String[n];
		    stringValues = scanner.nextLine().trim().split(" ");
		    int[] sequence = new int[n];
		    for(int i=0; i< n; i++) {
		        sequence[i] = Integer.parseInt(stringValues[i]);
		    }
		    int maxValue = 1;
		    System.out.println(longestSequence(sequence, n, maxValue));
		}
	}
}