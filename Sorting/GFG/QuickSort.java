import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;
//Time Complexity - T(n) = n + T(n-1) +1
//T(n-1) = n-1 + T(n-2) + 1
//O(n2) worst case
//Best Case theta(nlogn)
//O(1) - auxilary space complexity
public class QuickSort {

    private static final Scanner scanner = new Scanner(System.in);

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];

        int index = -1;
        for(int i = start; i<=end; i++) {
            if(arr[i] < pivot) {
                index++;
                int temp = arr[index];
                arr[index] = arr[i];
                arr[i] = temp;
            }
        }

        arr[end] = arr[index+1];
        arr[index+1] = pivot;

        return index+1;
    }

    private static void quickSort(int[] arr, int start, int end) {
       if(start < end) {
           int p = partition(arr, start, end);
           quickSort(arr, start, p-1);
           quickSort(arr, p+1, end);
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

        quickSort(arr, 0, n-1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }
}
