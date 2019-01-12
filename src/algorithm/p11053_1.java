package algorithm;

import java.util.Scanner;

public class p11053_1 {
    static int n, ans;
   
    static int[] d = new int[1001], a = new int[1001];
   
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i=0; i<n; i++)
            a[i] = in.nextInt();
        
        for(int i=0; i<n; i++){
            d[i] = 1;
            for(int j=0; j<i; j++)
                if(a[i]>a[j])
                    d[i] = Math.max(d[i], d[j]+1);
            ans = Math.max(ans, d[i]);
        }
        System.out.println(ans);
        in.close();
    }
}
