// 코딩테스트 연습 - 코딩테스트 입문
// 모음 제거

// 문제 설명
// 영어에선 a, e, i, o, u 다섯 가지 알파벳을 모음으로 분류합니다. 문자열 my_string이 매개변수로 주어질 때 모음을 제거한 문자열을 return하도록 solution 함수를 완성해주세요.

// 제한사항
// my_string은 소문자와 공백으로 이루어져 있습니다.
// 1 ≤ my_string의 길이 ≤ 1,000

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public String solution(String my_string) {
        String answer = "";
        String[] vowel = {"a", "e", "i", "o", "u"};
        List<String> vowelList = new ArrayList<>(Arrays.asList(vowel));
        for (int i = 0; i < my_string.length(); i++) {
            if (!vowelList.contains(Character.toString(my_string.charAt(i))))
                answer += my_string.charAt(i);
        }
        return answer;
    }
}

// return my_string.replaceAll("[aeiou]", "");