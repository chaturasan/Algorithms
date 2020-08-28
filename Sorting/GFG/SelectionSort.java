import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class SelectionSort {

    private static final Scanner scanner = new Scanner(System.in);

    private static int getMinValueIndex(int[] arr, int startIndex) {
        int minValue = arr[startIndex];
        int minIndex = startIndex;
        for(int j = startIndex; j < arr.length; j++) {
            if(arr[j] < minValue) {
                minValue = arr[j];
                minIndex = j;
            }
        }
        return minIndex;
    }

    static void selectionSort(int[] arr) {
        for(int i = 0; i < arr.length; i++) {
            int j = getMinValueIndex(arr, i);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
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

        selectionSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        scanner.close();
    }
}
