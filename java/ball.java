// 코딩테스트 연습 - 코딩테스트 입문
// 구슬을 나누는 경우의 수

// 문제 설명
// 머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 구슬은 모두 다르게 생겼습니다. 머쓱이가 갖고 있는 구슬의 개수 balls와 친구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, balls개의 구슬 중 share개의 구슬을 고르는 가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

// 제한사항
// 1 ≤ balls ≤ 30
// 1 ≤ share ≤ 30
// 구슬을 고르는 순서는 고려하지 않습니다.
// share ≤ balls

import java.lang.Math;
class Solution {
    public int factorial(int balls, int share) {
        long fact = 1;
        for (long i = balls, j = 1; j <= share; i--, j++){
            fact *= i;
            fact /= j;
        }
        return (int)fact;
    }
    public int solution(int balls, int share) {
        if (balls - share == 0)
            return 1;
        return factorial(balls, share);
    }
}

// 김상길님 문제해결

// 1. 해결 방법
// 물론 다들 아시겠지만, 해당 문제는 간단한 공식으로 푸는 문제입니다.
// 예를 들어 30개의 공에서 5개를 꺼내는 경우 아래와 같은 수식으로 풀 수 있습니다.

// 30 * 29 * 28 * 27 * 26 / 1 * 2 * 3 * 4 * 5

// 2. 문제1_오버플로우
// 물론 위와 같이 방식으로 해결을 하려고 하면 오버플로우가 발생하게 됩니다. 파이썬으로 검산해 본 결과
// 30! 의 경우 값이 265,252,859,812,191,058,636,308,480,000,000 이 나오기 때문에,
// 다른 언어들의 경우 단순히 Long 타입으로 사용한다고 해도 해결이 안됩니다.

// 따라서 한번에 곱한 후 나누는 것이 아니라 아래와 같이 단계별로 계산하는 방법을 사용해야 합니다.

// (30 / 1) * (29 / 2) * (28 / 3) * (27 / 4) * (26 / 5)

// 3. 문제2_부동소수점
// 다만 위와 같은 방식으로 해결하려고 하면 이번에는 28/3 의 경우 무한 소수이기 때문에 부동소수점 문제가 발생합니다.
// 수식도 정확하고 오버플로우도 발생하지 않지만, 결국 최종 정답을 구했을 때 부동소수점 오차로 인해 정답이 틀리는 케이스가 발생하게 됩니다.

// 그래서 먼저 나눈 값을 기존 값에 곱하는 것이 아니라, 아래와 같이 기존 계산된 값에 분자를 먼저 곱한 후 분모를 나눠주는 방법으로 접근해야 합니다.
// n개의 연속된 정수에는 항상 n의 배수가 포함되기 때문에 항상 정수 값이 나와서 부동소수점 문제를 피할 수 있습니다.

// (((((30 / 1) * 29 / 2) * 28 / 3) * 27 / 4) * 26 / 5)

// 4. Long Type 사용
// 파이썬으로 모든 케이스에 대한 정답을 구해 본 결과 최대 값은 (30, 15)인 경우 155,117,520 으로 Int 범위 안에 있지만 위와 같은 방법으로 계산을 했을 때 30C14에서 15를 곱하는 순간 Int 형은 오버플로우가 발생합니다.

// 따라서 코틀린 같은 경우 람다식으로 간단히 계산 가능하지만, 이 경우 계산 후 Long을 씌우는 것이 아니라 수식안의 모든 변수들에 .toLong() 을 붙여서 Long Type으로 계산을 해야만 오버플로우를 피할 수 있습니다.