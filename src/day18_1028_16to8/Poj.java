package day18_1028_16to8;

import java.util.Scanner;

public class Poj {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] result = new String[11];//保存最后输出的结果
        /*十六进制转化为二进制*/
        for (int i = 0; i < n; i++) {
            String h = in.next();
            StringBuilder tempB = new StringBuilder();
            for (int m = 0; m < h.length(); m++) {
                char numH = h.charAt(m);
                String b = Integer.toBinaryString(Integer.valueOf(String.valueOf(numH), 16));

                for (int k = b.length(); k < 4; k++) {
                    b = '0' + b;
                }

                tempB.append(b);
            }

            /*二进制转化为八进制*/
            StringBuilder tempO = new StringBuilder();//长度变为3的倍数，需要补的前导0的个数
            int addZero = 3 - tempB.length() % 3;
            for (int p = 0; p < addZero; p++) {
                tempB = new StringBuilder("0").append(tempB);
            }
            for (int m = 0; m < tempB.length(); m += 3) {
                //把字符串长度转换为三的倍数添加前导0
                String numB = tempB.substring(m, m + 3);
                String o = Integer.toOctalString(Integer.valueOf(String.valueOf(numB), 2));
                tempO.append(o);
            }
            result[i] = tempO.toString().replaceAll("^(0+)", "");//用正则表达式去掉前导零
        }
        for (int i = 0; i < n; i++) {
            System.out.println(result[i]);
        }
    }
}