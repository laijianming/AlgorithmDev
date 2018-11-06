package day18_1106palindromes;


/**
 * 问题描述
 * 　　1221是一个非常特殊的数，它从左边读和从右边读是一样的，编程求所有这样的四位十进制数。
 * 输出格式
 * 　　按从小到大的顺序输出满足条件的四位十进制数。
 */
public class Main {

    public static void main(String[] args) {
        for(int i = 1000 ; i <= 9999 ; i++){
            if((i/1000 == i%10) && ((i/100%10) == (i/10%10))){
                System.out.println(i);
            }
        }
    }
}
