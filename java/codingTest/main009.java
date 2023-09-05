package codingTest;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.io.IOException;

public class main009 {
    static int[] Arr;
    static int[] checkArr;
    static int check;

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int strlen = Integer.parseInt(st.nextToken());
        int wordlen = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        String str = st.nextToken();

        st = new StringTokenizer(br.readLine());
        checkArr = new int[4];
        check = 0;
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0)
                check++;
        }
        Arr = new int[4];
        int start = 0;
        int count = 0;
        for (start = 0; start < wordlen; start++) {
            AddC(str.charAt(start));
        }
        if (check == 4)
            count++;
        for (; start < strlen; start++) {
            AddC(str.charAt(start));
            RemoveC(str.charAt(start-wordlen));
            if (check == 4)
                count++;
        }
        System.out.println(count);
        br.close();
    }

    private static void AddC(char c) {
        switch (c) {
            case 'A' :
                Arr[0]++;
                if (Arr[0] == checkArr[0])
                    check++;
                break;
            case 'C':
                Arr[1]++;
                if (Arr[1] == checkArr[1])
                    check++;
                break;
            case 'G':
                Arr[2]++;
                if (Arr[2] == checkArr[2])
                    check++;
                break;
            case 'T':
                Arr[3]++;
                if (Arr[3] == checkArr[3])
                    check++;
                break;
        }
    }

    private static void RemoveC(char c) {
        switch (c) {
            case 'A' :
                if (Arr[0] == checkArr[0])
                    check--;
                Arr[0]--;
                break;
            case 'C':
                if (Arr[1] == checkArr[1])
                    check--;
                Arr[1]--;
                break;
            case 'G':
                if (Arr[2] == checkArr[2])
                    check--;
                Arr[2]--;
                break;
            case 'T':
                if (Arr[3] == checkArr[3])
                    check--;
                Arr[3]--;
                break;
        }
    }
}
