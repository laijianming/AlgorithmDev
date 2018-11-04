package day18_1028_16to8;

import org.junit.Test;

import java.util.Date;
import java.util.Scanner;

/**
 * 问题描述
 * 　　给定n个十六进制正整数，输出它们对应的八进制数。
 *
 * 输入格式
 * 　　输入的第一行为一个正整数n （1<=n<=10）。
 * 　　接下来n行，每行一个由0~9、大写字母A~F组成的字符串，表示要转换的十六进制正整数，每个十六进制数长度不超过100000。
 *
 * 输出格式
 * 　　输出n行，每行为输入对应的八进制正整数。
 *
 * 　　【注意】
 * 　　输入的十六进制数不会有前导0，比如012A。
 * 　　输出的八进制数也不能有前导0。
 *
 * 样例输入
 * 　　2
 * 　　39
 * 　　123ABC
 *
 * 样例输出
 * 　　71
 * 　　4435274
 */
public class Main {

   static int c = 0;

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();
//        s.nextLine();
        if(n > 10 || n < 1){
            return;
        }
        // 输入十六进制数
        String[] hex = new String[n];
        for(int i = 0; i < n ; i++){
            hex[i] = s.next();
        }
        //计时
        Date d = new Date();
        long time1 = d.getTime();
        // 十六转八
        String[] octal = new String[n];
        for(int i = 0; i < n ; i ++){
            octal[i] = hexToOctal(hex[i]) + "";
        }
        for(String str : octal){
            System.out.println(str);
        }
        d = new Date();
        long time2 = d.getTime();
        System.out.print("总花费时间： ");
        System.out.println(time2 - time1);
    }

    /**
     * 总结：
     *      通过三个方法的对比，1、switch方法的速度比Integer.toBinaryString(Integer.valueOf(String.valueOf(s), 16));要更快；
     *                          2、快的不是运算方式，而是对数据类型的选择，而StringBuilder类型的速度比String更快
     *
     *
     * 首先说运行速度，或者说是执行速度，在这方面运行速度快慢为：StringBuilder > StringBuffer > String
     * 　　 String最慢的原因：
     * 　　 String为字符串常量，而StringBuilder和StringBuffer均为字符串变量，
     *      即String对象一旦创建之后该对象是不可更改的，但后两者的对象是变量，是可以更改的
     *
     * 　　String：适用于少量的字符串操作的情况
     *
     * 　　StringBuilder：适用于单线程下在字符缓冲区进行大量操作的情况
     *
     * 　　StringBuffer：适用多线程下在字符缓冲区进行大量操作的情况
     * @return
     */
    // 16 转 8
    public static StringBuilder hexToOctal(String str){
        String two = "";
        // 将 16 转 2 表达
        StringBuilder tempB = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){
            c++;
            // 方法一
            /*switch (s){
                case "0" : two += "0000";break;
                case "1" : two += "0001";break;
                case "2" : two += "0010";break;
                case "3" : two += "0011";break;
                case "4" : two += "0100";break;
                case "5" : two += "0101";break;
                case "6" : two += "0110";break;
                case "7" : two += "0111";break;
                case "8" : two += "1000";break;
                case "9" : two += "1001";break;
                case "A" : two += "1010";break;
                case "B" : two += "1011";break;
                case "C" : two += "1100";break;
                case "D" : two += "1101";break;
                case "E" : two += "1110";break;
                case "F" : two += "1111";break;
                default: break;
            }*/

            //方法二
            /*String b = Integer.toBinaryString(Integer.valueOf(String.valueOf(s), 16));

            for (int k = b.length(); k < 4; k++) {
                b = '0' + b;
            }
            tempB.append(b);*/

          //方法三 : 通过测试，此方法的运行速度是最快的；
              switch (str.charAt(i)+""){
                case "0" : tempB.append("0000");break;
                case "1" : tempB.append("0001");break;
                case "2" : tempB.append("0010");break;
                case "3" : tempB.append("0011");break;
                case "4" : tempB.append("0100");break;
                case "5" : tempB.append("0101");break;
                case "6" : tempB.append("0110");break;
                case "7" : tempB.append("0111");break;
                case "8" : tempB.append("1000");break;
                case "9" : tempB.append("1001");break;
                case "A" : tempB.append("1010");break;
                case "B" : tempB.append("1011");break;
                case "C" : tempB.append("1100");break;
                case "D" : tempB.append("1101");break;
                case "E" : tempB.append("1110");break;
                case "F" : tempB.append("1111");break;
                default: break;
            }
        }
        // 将 2进表达 转为8进表达
        int x;
        if((x = tempB.length() % 3) != 0){
            if(("" + tempB.charAt(0)).equals("0") && x == 1){
                tempB.deleteCharAt(0);
            }else if(("" + tempB.charAt(0) + tempB.charAt(1)).equals("00") && x == 2){
                tempB.deleteCharAt(0);tempB.deleteCharAt(0);
            }else
                // 补齐3位
            {
                for(int i = 0; i < 3-x ; i++){
                    tempB.insert(0,0);
                }
            }
        }
        two = tempB + "";
       /* // 若前3位是 000 则删除
        if(("" + two.charAt(0) + two.charAt(1) + two.charAt(2)).equals("000")){
            two = two.substring(3,two.length());
        }*/

        // 将 8 进转为 "10" 进
        //String octal = "";
        StringBuilder s = new StringBuilder();
        for(int i = 0 ; i < two.length() ; i = i + 3){
            switch ("" + two.charAt(i) + two.charAt(i + 1) + two.charAt(i + 2)){
                case "000" : s.append("0");break;
                case "001" : s.append("1");break;
                case "010" : s.append("2");break;
                case "011" : s.append("3");break;
                case "100" : s.append("4");break;
                case "101" : s.append("5");break;
                case "110" : s.append("6");break;
                case "111" : s.append("7");break;
                default: break;
            }
        }
       // octal = s + "";
        return s;
    }


    @Test
    public void test(){

        String x = "A";
        switch (x){
            case "B" :
                System.out.println("---1");break;
            case "A" :
                System.out.println("---2");break;
            default:
                System.out.println("default");break;
        }
        String string = "001";
        System.out.println(string);
    }



}
