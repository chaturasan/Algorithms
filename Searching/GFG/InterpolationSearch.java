/*package whatever //do not write package name here */

//Note: This code is for sorted array inputs
import java.util.*;
import java.lang.*;
import java.io.*;
//Time complexity - O(log logn)
class InterpolationSearch {

    private static int search(int[] arr,  int left, int right,  int k) {
        while(left <= right) {

            if(left == right) {
                if(arr[left] == k) return left;
                return -1;
            }
            int pos = left + ((k - arr[left]) * ((right - left)/(arr[right] - arr[left])));

            if(arr[pos] == k)
                return pos;

            if(arr[pos] < k)
                left = pos + 1;

            if(arr[pos] > k)
                right = pos -1;
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