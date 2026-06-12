package Algorithms_Study;

import java.util.Arrays;

class Programmers_Big_numbers {
    public String solution(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        // 배열 길이 처리
        int len = numbers.length;
        // 입력받은 배열 문자열 처리를 위한 배열
        String[] strNumb = new String[len];
        
        // 입력받은 배열 문자열 처리
        for(int i = 0; i < len; i++){
            strNumb[i] = String.valueOf(numbers[i]);
        }
        
        // 문자열 처리한 배열 비교
        Arrays.sort(strNumb, (a, b) -> {
            // 비교 후 값 반환
            return (b + a).compareTo(a + b);
        });
        
        // 첫 번째 배열이 0인 경우에 0 출력
        if (strNumb[0].equals("0")) return "0";
        
        for(String str : strNumb){
            sb.append(str);
        }
        
        return sb.toString();
    }
}