package day18_1025circularArea;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

/**
 * 给定圆的半径r，求圆的面积。
 * 输入包含一个整数r，表示圆的半径。
 * 输出一行，包含一个实数，四舍五入保留小数点后7位，表示圆的面积。
 */
public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        double S = 0;
        int r = s.nextInt();
        if (r >= 1 && r <= 10000) {
            S = r * r * Math.PI;
            //直接通过String类的format函数实现
            System.out.println(String.format("%.7f", S));
            // saveF(S);
        }
    }

    /**
     * 保留xxx位小数方法
     */
    public static void saveF(double S) {

        //方法一：最简便的方法，调用DecimalFormat类
        DecimalFormat df = new DecimalFormat(".0000000");
        System.out.println(df.format(S));
        //方法二：直接通过String类的format函数实现
        System.out.println(String.format("%.7f", S));
        //方法三：通过BigDecimal类实现,若最后一位小数是0的话，则会省略
        BigDecimal bd = new BigDecimal(S);
        double newS1 = bd.setScale(7, BigDecimal.ROUND_HALF_UP).doubleValue();
        System.out.println(newS1);
        //方法四：通过NumberFormat类实现,但结果会以3位用 ， 分隔  3,294,198.6583306
        NumberFormat nf = NumberFormat.getNumberInstance();
        nf.setMaximumFractionDigits(7);
        System.out.println(nf.format(S));

    }


}
