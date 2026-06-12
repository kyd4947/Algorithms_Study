package Algorithms_Study;

import java.util.Arrays;

class Programmers_K_numbers {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        // commands 배열 한 개씩 확인
        for(int t = 0; t < commands.length; t++){
            // i, j, k 값 선언
            int i = commands[t][0] - 1;
            int j = commands[t][1] - 1;
            int k = commands[t][2];
            
            // array의 i ~ j 구간 입력될 임시 배열 선언
            int[] temp = new int [j - i + 1];
            
            int idx = 0;
            
            // 구간 복사
            for(int c = i; c <= j; c++){
                temp[idx] = array[c];
                idx++;
            }
            
            // 정렬
            Arrays.sort(temp);
            
            // 출력할 값 입력
            answer[t] = temp[k - 1];
        }
                
        return answer;
    }
}