package Algorithms_Study;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jungol_2101{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double [] arr = new double [n];
        double [] dp = new double[n];

        for(int i = 0; i < n; i++){
            arr[i] = Double.parseDouble(br.readLine());
        }

        dp[0] = arr[0];
        double answer = dp[0];

        for(int i = 1; i < n; i++){
            dp[i] = Math.max(arr[i], dp[i - 1] * arr[i]);
            answer = Math.max(answer, dp[i]);
        }

        System.out.printf("%.3f", answer);
    }
}