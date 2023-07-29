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