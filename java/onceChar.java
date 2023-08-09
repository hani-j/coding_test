// 코딩테스트 연습 - 코딩테스트 입문
// 한 번만 등장한 문자

// 문제 설명
// 문자열 s가 매개변수로 주어집니다. s에서 한 번만 등장하는 문자를 사전 순으로 정렬한 문자열을 return 하도록 solution 함수를 완성해보세요. 한 번만 등장하는 문자가 없을 경우 빈 문자열을 return 합니다.

// 제한사항
// 0 < s의 길이 < 1,000
// s는 소문자로만 이루어져 있습니다.

import java.util.Arrays;
class Solution {
    public String solution(String s)  {
        String answer = "";
        char[] c= s.toCharArray();
        if (s.length() == 1)
            return s;
        Arrays.sort(c);
        for (int i = 0; i < c.length - 1; i++) {
            if (c[i] == c[i+1]){
                 while (i < c.length - 1 && c[i] == c[i + 1])
                    i++;
            } else
                answer += c[i]+"";
        }
        if (c[c.length- 1] != c[c.length -2])
                answer += c[c.length- 1]+"";
        return answer;
    }
}

// return Arrays.stream(s.split(""))
//                 .collect(Collectors.groupingBy(s1 -> s1))
//                 .entrySet()
//                 .stream()
//                 .filter(entry -> entry.getValue().size() <= 1)
//                 .map(Map.Entry::getKey)
//                 .sorted()
//                 .collect(Collectors.joining());