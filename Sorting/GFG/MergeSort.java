import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//Time Complexity T(n) = 2T(n/2)+n
// T(n) = 4T(n/4) + 2n
// T(n) = 2^k T(n/2^k) + kn
//2^k = n
// T(n) = log2nT(1) + nlog2n
// Time Complexity - O(nlogn)
//O(n) - auxilary space complexity
public class MergeSort {

    private static final Scanner scanner = new Scanner(System.in);

    private static void merge(int[] arr, int start, int mid, int end) {
        int leftRange = mid - start +1;
        int rightRange = end - mid;

        int[] left = new int[leftRange];
        int[] right = new int[rightRange];

        for(int i=0; i< leftRange; i++) {
            left[i] = arr[start + i];
        }

        for(int i=0; i< rightRange; i++) {
            right[i] = arr[mid + 1 + i];
        }

        int k = l;
        int i=0, j=0;

        while(i < leftRange && j < rightRange) {
            if(left[i] < right[j]) {
                arr[k] = left[i];
                i++;
            } else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while(i< leftRange) {
            arr[k++] = left[i];
            i++;
        }

        while(j< rightRange) {
            arr[k++] = right[j];
            j++;
        }
    }

    private static void mergeSort(int[] arr, int start, int end) {
        while(start < end) {
            int mid = start + (end-start)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            merge(arr, start, mid, end);
        }
    }

    public static void main(String[] args) throws IOException {
        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        mergeSort(arr, 0, arr.length-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }
}
