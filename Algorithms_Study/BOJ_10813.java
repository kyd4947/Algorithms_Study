package Algorithms_Study;

import java.util.*;
import java.io.*;

public class BOJ_10813{
  public static void swap(int[] arr, int i, int j){
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }
  
  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    int m = Integer.parseInt(st.nextToken());


    int [] arr = new int[n + 1];
    for (int i = 1; i <= n; i++){
      arr[i] = i;
    }

    for (int k = 0; k < m; k++){
      st = new StringTokenizer(br.readLine());

      int i = Integer.parseInt(st.nextToken());
      int j = Integer.parseInt(st.nextToken());

      swap(arr, i, j);
    }
    for (int j = 1; j <= n; j++){
      System.out.print(arr[j] + " ");
    }
  }
}