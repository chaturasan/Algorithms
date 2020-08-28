/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class LinearSearch {

    private static int search(int[] arr, int k) {
        for(int i=0; i < arr.length; i++){
            if(arr[i] == k)
                return i+1;
        }
        return -1;
    }

    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine().trim());
        while(t-- > 0) {
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            scanner.nextLine().trim();
            String[] arrString = scanner.nextLine().trim().split(" ");
            int[] arr = new int[n];
            for(int i = 0; i< n; i++) {
                arr[i] = Integer.parseInt(arrString[i]);
            }
            System.out.println(search(arr, k));
        }
    }
}