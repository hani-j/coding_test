// 코딩테스트 연습 - 코딩테스트 입문
// 최빈값 구하기

// 문제 설명
// 최빈값은 주어진 값 중에서 가장 자주 나오는 값을 의미합니다. 정수 배열 array가 매개변수로 주어질 때, 최빈값을 return 하도록 solution 함수를 완성해보세요. 최빈값이 여러 개면 -1을 return 합니다.

// 제한사항
// 0 < array의 길이 < 100
// 0 ≤ array의 원소 < 1000

// 12, 14 번 통과 못함

import java.util.Arrays;
class Solution {
    public int solution(int[] array) {
        Arrays.sort(array);
        int count = 0;
        int max = 0;
        int maxArray = 0;
        for (int  i = 0; i < array.length - 1; i++) {
            if (array[i] == array[i + 1]) {
                count++;
            } else {
                if (count != 0 && max == count)
                    return -1;
                if (max < count) {
                    max = count;
                    maxArray = i;
                }
                count = 0;
            }
        }
        if (count != 0 && max == count)
                    return -1;
        if (max < count) {
            return array[array.length - 1];
        }
        if (max == 0 && array.length > 1)
            return -1;
        return array[maxArray];
    }
}