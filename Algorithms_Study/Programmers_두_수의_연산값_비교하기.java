package Algorithms_Study;

class Solution {
    public int solution(int a, int b) {
        int answer = 0;
        String cb = Integer.toString(b);
        int k = (int) Math.pow(10, cb.length());
        
        int ab = a * k + b;
        int mul = 2 * a * b;
        if (ab >= mul){
            answer = ab;
        } else {
            answer = mul;
        }
        return answer;
    }
}