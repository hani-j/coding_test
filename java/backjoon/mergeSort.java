package backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 21-6 2447 **시간초과
public class mergeSort {
	static int[] tmp;
	static int count = 0;
    static int K = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());        
		K = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        String[] data = br.readLine().split(" ");

        for(int i=0;i<N;i++){
            arr[i] = Integer.parseInt(data[i]);
        }
        merge_sort(arr, 0, N - 1);
        System.out.println(-1);
   
        br.close();
    }

    public static void merge_sort(int[] arr, int p, int r){
        if(p < r){
            int q = (p+r)/2;
            merge_sort(arr, p, q);
            merge_sort(arr, q+1, r);
            Merge(arr, p, q, r);
        }
    }
    
    public static void Merge(int[] arr, int p, int q, int r){
        int i = p;
        int j = q + 1;
        int t = p;
        tmp = new int[r+1];
        while(i <= q && j <= r){
            if(arr[i] < arr[j]){
                tmp[t++] = arr[i++]; 
            }else{
                tmp[t++] = arr[j++];
            } 
        }
        while(i <= q){
            tmp[t++] = arr[i++];
        }
        while(j <= r){
            tmp[t++] = arr[j++];
        }
        i = p;
        while(i<=r){
            arr[i] = tmp[i++];
            if(++count == K){
                System.out.println(arr[i-1]);
                System.exit(0);
            }
        }
    }
}
