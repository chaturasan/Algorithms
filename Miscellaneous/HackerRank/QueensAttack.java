import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class QueenAttack {

    // Complete the queensAttack function below.
    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
        int obstacleRL = -1;
        int obstacleRR = -1;
        int obstacleRTL = -1;
        int obstacleRTR = -1;
        int obstacleRBL = -1;
        int obstacleRBR = -1;
        int obstacleRT = -1;
        int obstacleRB = -1;

        int obstacleCL = -1;
        int obstacleCR = -1;
        int obstacleCTL = -1;
        int obstacleCTR = -1;
        int obstacleCBL = -1;
        int obstacleCBR = -1;
        int obstacleCT = -1;
        int obstacleCB = -1;

        int numberOfSquares = 0;
        for(int obstacleCounter = 0; obstacleCounter < k; obstacleCounter++) {
            int obstacleRow = obstacles[obstacleCounter][0];
            int obstacleCol = obstacles[obstacleCounter][1];

            if((obstacleRow == r_q && obstacleCol > c_q) && (obstacleRR == -1 || obstacleCol < obstacleCR)) {
                obstacleRR = obstacleRow;
                obstacleCR = obstacleCol;
            }

            
            if((obstacleRow == r_q && obstacleCol < c_q) && (obstacleRL == -1 || obstacleCol > obstacleCL)) {
                obstacleRL = obstacleRow;
                obstacleCL = obstacleCol;
            }

            
            if((obstacleRow < r_q && obstacleCol == c_q) && (obstacleCT == -1 || obstacleRow > obstacleRT)) {
                obstacleRT = obstacleRow;
                obstacleCT = obstacleCol;
            }

             if((obstacleRow > r_q && obstacleCol == c_q) && (obstacleCB == -1 || obstacleRow < obstacleRB)) {
                obstacleRB = obstacleRow;
                obstacleCB = obstacleCol;
            }

            if((obstacleRow < r_q && obstacleCol < c_q && r_q-obstacleRow==c_q-obstacleCol) && (obstacleCTL == -1 || obstacleRow > obstacleRTL)) {
                obstacleRTL = obstacleRow;
                obstacleCTL = obstacleCol;
            }

              if((obstacleRow < r_q && obstacleCol > c_q && r_q-obstacleRow==obstacleCol-c_q) && (obstacleCTR == -1 || obstacleRow > obstacleRTR)) {
                   System.out.println("in here 3");
                obstacleRTR = obstacleRow;
                obstacleCTR = obstacleCol;
            }

              if((obstacleRow > r_q && obstacleCol < c_q && obstacleRow-r_q==c_q-obstacleCol) && (obstacleCBL == -1 || obstacleRow < obstacleRBL)) {
                obstacleRBL = obstacleRow;
                obstacleCBL = obstacleCol;
            }

              if((obstacleRow > r_q && obstacleCol > c_q && obstacleRow-r_q==obstacleCol-c_q) && (obstacleCBR == -1 || obstacleRow < obstacleRBR)) {
                obstacleRBR = obstacleRow;
                obstacleCBR = obstacleCol;
            }

           
        }

        numberOfSquares += obstacleRR != -1 ? (obstacleCR-c_q-1):n-c_q;
        numberOfSquares += obstacleRL != -1 ? (c_q-obstacleCL-1):c_q-1;
        numberOfSquares += obstacleRT != -1 ? (r_q-obstacleRT-1):r_q-1;
        numberOfSquares += obstacleRB != -1 ? (obstacleRB-r_q-1):n-r_q;

        numberOfSquares += obstacleRTL != -1 ? r_q-obstacleRTL-1:Math.min(r_q-1, c_q-1);
        numberOfSquares += obstacleRTR != -1 ? r_q-obstacleRTR-1:Math.min(r_q -1 ,n-c_q);
        numberOfSquares += obstacleRBL != -1 ? obstacleRBL-r_q-1:Math.min(n-r_q, c_q-1);
        numberOfSquares += obstacleRBR != -1 ?obstacleRBR-r_q-1:Math.min(n-r_q, n-c_q);
        
        return numberOfSquares;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String[] nk = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nk[0]);

        int k = Integer.parseInt(nk[1]);

        String[] r_qC_q = scanner.nextLine().split(" ");

        int r_q = Integer.parseInt(r_qC_q[0]);

        int c_q = Integer.parseInt(r_qC_q[1]);

        int[][] obstacles = new int[k][2];

        for (int i = 0; i < k; i++) {
            String[] obstaclesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 2; j++) {
                int obstaclesItem = Integer.parseInt(obstaclesRowItems[j]);
                obstacles[i][j] = obstaclesItem;
            }
        }

        int result = queensAttack(n, k, r_q, c_q, obstacles);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
