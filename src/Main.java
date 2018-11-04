import org.junit.Test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n;
        n = s.nextInt();
        if(n > 10 || n < 1){
            return;
        }
        // 输入十六进制数
        String[] hex = new String[n];
        for(int i = 0; i < n ; i++){
            hex[i] = s.next();
        }
        // 十六转八
        String[] octal = new String[n];
        for(int i = 0; i < n ; i ++){
            octal[i] = hexToOctal(hex[i]);
        }
        for(String str : octal){
            System.out.println(str);
        }
    }

    // 16 转 8
    public static String hexToOctal(String str){
        String two = "";
        // 将 16 转 2 表达
        StringBuilder tempB = new StringBuilder();
        for(int i = 0 ; i < str.length() ; i++){
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
        two = tempB + "";
        // 将 2进表达 转为8进表达
        int x;
        if((x = two.length() % 3) != 0){
            // 补齐3位
            for(int i = 0; i < 3-x ; i++){
                two = "0" + two;
            }
        }
        if(("" + two.charAt(0) + two.charAt(1) + two.charAt(2)).equals("000")){
            two = two.substring(3,two.length());
        }

        // 将 8 进转为 "10" 进
        String octal = "";
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
        octal = s + "";
        return octal;
    }

    @Test
    public  void test(){
        StringBuilder s = new StringBuilder("abcd");
        System.out.println(s);
        s.deleteCharAt(0);
        System.out.println(s);
        s.deleteCharAt(0);
        System.out.println(s);
        s.insert(0,0);
        s.insert(0,1);
        System.out.println(s);
    }

}


