package day18_1025finbonacci;

import java.util.Scanner;

/**
 * Fibonacci数列的递推公式为：Fn=Fn-1+Fn-2，其中F1=F2=1。当n比较大时，Fn也非常大，现在我们想知道，Fn除以10007的余数是多少。
 *输入包含一个整数n。
 *输出一行，包含一个整数，表示Fn除以10007的余数。
 */
public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (true){
            // 方法1：
            int index = s.nextInt();
            if(index >= 1 && index <= 1000000){
                int Fn = 0;
                int f1 = 1;
                int f2 = 1;
                Fn = f1;
                // 注意int数据类型的溢出问题
                for(int i = 3; i <= index; i++){
                    f1 = Fn;
                    // System.out.print("f1=" + f2 + " f2=" + Fn);
                    Fn += f2;
                    f2 = f1;
                    // System.out.println(" Fn=" + Fn);
                    Fn = Fn%10007;
                }
                System.out.println(Fn);
            }
            // 方法2：
            int n = index;
            if (1 <= n && n<=1000000) {
                int[] F = new int[n+1];
                F[1] = 1;
                F[2] = 1;
                if (n != 1) {
                    for (int i=3; i<=n; i++) {
                        F[i]=(F[i-1]+F[i-2])%10007;
                    }
                }
                System.out.println(F[n]);
            }
        }
    }
}
