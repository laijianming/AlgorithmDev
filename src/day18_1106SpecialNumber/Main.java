package day18_1106SpecialNumber;

/**
 * 问题描述
 * 　　153是一个非常特殊的数，它等于它的每位数字的立方和，即153=1*1*1+5*5*5+3*3*3。编程求所有满足这种条件的三位十进制数。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的三位十进制数，每个数占一行。
 */
public class Main {
    public static void main(String[] args) {
        int x = 1;
        int y = 1;
        int z = 1;
        for(int i = 100 ; i <= 999 ; i++){
            for(int j = 0; j <= 2; j++){
                x *= i/100;
                y *= i/10%10;
                z *= i%10;
            }
            if((x + y + z) == i){
                System.out.println(i);
            }
            x = 1;
            y = 1;
            z = 1;
        }
    }
}
