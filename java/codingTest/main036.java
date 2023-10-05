package codingTest;

import java.util.Scanner;

public class main036 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] array = str.split("-");

        int sum = 0;
        if (array[0].contains("+")) {
            String[] arr = array[0].split("\\+");
            for (int j = 0; j < arr.length; j++) {
            sum += Integer.parseInt(arr[j]);
            }
        } else {
           sum = Integer.parseInt(array[0]);
        }
        
        for (int i = 1; i < array.length; i++) {
            if (array[i].contains("+")) {
                String[] arr = array[i].split("\\+");
                int s = 0;
                for (int j = 0; j < arr.length; j++) {
                    s += Integer.parseInt(arr[j]);
                }
                sum -= s;
            } else {
                sum -= Integer.parseInt(array[i]);
            }
        }
        System.out.println(sum);
        sc.close();
    }
}
