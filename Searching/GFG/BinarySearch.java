/*package whatever //do not write package name here */

//Note: This code is for sorted array inputs
import java.util.*;
import java.lang.*;
import java.io.*;

class BinarySearch {

    private static int search(int[] arr,  int left, int right,  int k) {
        while(left <= right) {
            int mid = left + (right-left)/2;

            if(arr[mid] == k)
                return mid;

            if(arr[mid] < k)
                left = mid + 1;

            if(arr[mid] > k)
                right = mid -1;
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
            System.out.println(search(arr, 0, n-1, k));
        }
    }
}