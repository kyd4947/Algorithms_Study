package Algorithms_Study;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BOJ_2839 {
	
	/*
	// greedy algorithms 풀이
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int count = 0;
		
		while(n >= 0) {
			if (n % 5 == 0) {
				count += n / 5;
				System.out.println(count);
				break;
			}
			n -= 3;
			count++;
		}
		
		System.out.println(-1);
	}
	*/
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int INF = 100000000;
		
		int[] dp = new int[n + 1];
		
		for(int i = 1; i <= n; i++) {
			dp[i] = INF;
		}
		dp[0] = 0;
		
		for(int i = 1; i <= n; i++) {
			if(i >= 3) {
				dp[i] = Math.min(dp[i], dp[i - 3] + 1);
			}
			if(i >= 5) {
				dp[i] = Math.min(dp[i],  dp[i - 5] + 1);
			}
		}
		
		if (dp[n] == INF) {
			System.out.println(-1);
		}else {
			System.out.println(dp[n]);
		}
	}
}
