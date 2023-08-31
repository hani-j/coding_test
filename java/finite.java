// 코딩테스트 연습 - 코딩테스트 입문
// 유한소수 판별하기

// 문제 설명
// 소수점 아래 숫자가 계속되지 않고 유한개인 소수를 유한소수라고 합니다. 분수를 소수로 고칠 때 유한소수로 나타낼 수 있는 분수인지 판별하려고 합니다. 유한소수가 되기 위한 분수의 조건은 다음과 같습니다.

// 기약분수로 나타내었을 때, 분모의 소인수가 2와 5만 존재해야 합니다.
// 두 정수 a와 b가 매개변수로 주어질 때, a/b가 유한소수이면 1을, 무한소수라면 2를 return하도록 solution 함수를 완성해주세요.

// 제한사항
// a, b는 정수
// 0 < a ≤ 1,000
// 0 < b ≤ 1,000

// import java.util.List;
// import java.util.ArrayList;
// class Solution {
//     public List<Integer> reduction(int n) {
//         List<Integer> arr = new ArrayList<>();
//         int num = n;
//         int i = 2;
//         while (i < 1000 && num != 1) {
//             if (num % i == 0){
//                 while (num % i == 0)
//                     num /= i;
//                 arr.add(i);
//             }
//             i++;
//         }
//         return arr;
//     }
//     public int solution(int a, int b) {
//         if (a != 1 && a >= b && a % b == 0)
//             return 1;
//         List<Integer> aArr = reduction(a);
//         List<Integer> bArr = reduction(b);
    
//         int max = 0;
//         for (Integer i : aArr) {
//             for (Integer j : bArr) {
//                 if (i == j)
//                     max = i;
//             }
//         }
//         if (max > 0) {
//             a /= max;
//             b /= max;
//         }
//         List<Integer> cArr = reduction(b);
//         for (Integer i : cArr) {
//             if (i != 2 && i != 5)
//                 return 2;
//         }
//         return 1;
//     }
// }

// 25번 테스트케이스가 계속 틀림
// 수정

class Solution {
    public int solution(int a, int b) {
        int tmpA = a;
        int tmpB = b;

        for(int i = 2; i <= a; i++){
            if(tmpA % i == 0 && tmpB % i == 0){
                tmpA /= i;
                tmpB /= i;
                i--;
            }
        }

        int bunmo = tmpB;

        while(bunmo % 2 == 0){
            bunmo /= 2;
        }
        while(bunmo % 5 == 0){
            bunmo /= 5;
        }

        return bunmo == 1 ? 1 : 2;
        }
}