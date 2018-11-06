package day18_1106LetterGraph;

import java.util.Scanner;

/**
 * 问题描述
 * 利用字母可以组成一些美丽的图形，下面给出了一个例子：
 * ABCDEFG
 * BABCDEF
 * CBABCDE
 * DCBABCD
 * EDCBABC
 * 这是一个5行7列的图形，请找出这个图形的规律，并输出一个n行m列的图形。
 *
 * 输入格式
 * 输入一行，包含两个整数n和m，分别表示你要输出的图形的行数的列数。
 * 输出格式
 * 输出n行，每个m个字符，为你的图形。
 * 样例输入
 * 5 7
 * 样例输出
 * ABCDEFG
 * BABCDEF
 * CBABCDE
 * DCBABCD
 * EDCBABC
 * 数据规模与约定
 * 1 <= n, m <= 26。
 */
public class Main {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // n 行数 m 字母数
        int n = s.nextInt();
        int m = s.nextInt();
        if(n < 1 || m > 26){
            return;
        }
        StringBuilder letterGraph = new StringBuilder();
        // 给 letterGraph 赋值第一行
        char letter = 'A';
        for(int i = 0; i < 26; i++){
            letterGraph.append(letter);
            letter = (char) (letter + 1);
        }
        // 保留原生值
        String orgin = String.valueOf(letterGraph);
        StringBuilder result = new StringBuilder();
        // 生成并输出当前行
        for(int i = 0; i < n; i++){
            // 注意，当 行数比字母数大的时候，再进行这样交换则会越界
            if(i != 0) {
                if(i == orgin.length() -1){
                    orgin = orgin + letterGraph;
                }
                letterGraph.deleteCharAt(letterGraph.length() - 1);  // 删下标所在位置的值，从0开始
                // 往前面添加对应的值
                letterGraph.insert(0,orgin.charAt(i));
            }
            for(int k = 0; k < m; k++ ){
                result.append(letterGraph.charAt(k));
            }
            System.out.println(result);
            result.delete(0,result.length());
        }
    }
}
