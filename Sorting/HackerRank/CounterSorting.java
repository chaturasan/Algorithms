import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class CounterSorting {

    // Complete the countingSort function below.
    static int[] countingSort(int[] arr) {
        
        int maxNumber = Arrays.stream(arr).max().getAsInt();
        int[] numberCounter = new int[maxNumber + 1];

        for(int ind = 0; ind < arr.length; ind++) {
            numberCounter[arr[ind]]++;
        }

        int j=0;
        for(int counter=0; counter <= maxNumber; counter++) {
            int count = numberCounter[counter];
            for(int i=0; i< count; i++) {
                arr[j+i] = counter;
            }
            j += count;
        }

        return arr;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = countingSort(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}