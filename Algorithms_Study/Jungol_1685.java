package Algorithms_Study;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Jungol_1685{
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] dp = new int [n][n];
        int[][] triangle = new int [n][n];
        int answer = 0;     // 최종 출력값

        // 삼각형 배열 입력
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j <= i; j++){
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 초기값 설정
        dp[0][0] = triangle[0][0];

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= i; j++){
                if (j == 0){
                    dp[i][j] = dp[i - 1][j] + triangle[i][j];
                } else if (i == j){
                    dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
                }
            }
        }
        for (int i = 0; i < n; i++){
            answer = Math.max(answer, dp[n - 1][i]);
        }

        System.out.println(answer);
    }
}