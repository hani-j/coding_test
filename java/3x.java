// 코딩테스트 연습 - 코딩테스트 입문
// 저주의 숫자 3

// 문제 설명
// 3x 마을 사람들은 3을 저주의 숫자라고 생각하기 때문에 3의 배수와 숫자 3을 사용하지 않습니다. 3x 마을 사람들의 숫자는 다음과 같습니다.
// 정수 n이 매개변수로 주어질 때, n을 3x 마을에서 사용하는 숫자로 바꿔 return하도록 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ n ≤ 100

class Solution {
    public int solution(int n) {
        int num = 0;
        for (int i = 1; i <= n; i++) {
            num++;
            while (num == 3 || num % 3 == 0 || Integer.toString(num).contains("3"))
                num++;
        }
        return num;
    }
}