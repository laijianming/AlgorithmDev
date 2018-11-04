package day18_1025SequenceSum;

import java.util.Scanner;

/**
 * 从时间和空间上考虑
 */
public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        while (true){
            long sum = 0;
            long n = s.nextInt();
        if(n <= 0 || n > 1_000_000_000){
            return;
        }
        //方法1： 当输入的值到达一定程度时，则运行时间会大于1s，不符合要求
//        for(int i = 1; i <= n; i++){
//            sum += i;
//        }
//        System.out.println("方法1：" + sum);
//        sum = 0;
        //方法2： 等差数列求和
        sum = n*1 + n*(n-1)/2*1; // n*a1 + n*(n-1)/2*d
        System.out.println("方法2："+sum);
        // 方法3: 求一半
            sum = 0;
            for(long i = n; i >= 0; i = i - 2){
                sum += i;
            }
            if(n%2 == 1)
                sum = sum*2 - n/2 -1;
            else
                sum = sum*2 - n/2;
            System.out.println("方法3："+sum);
    }}
}
