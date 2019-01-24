import org.junit.Test;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String infix = "9+(3-1)*3+10/2";
        System.out.println(infix.substring(1, 4)); // +(3
    }

    @Test
    public  void test(){
        String infix = "9+(3-1)*3+10/2";
        String[] split = infix.split("/");
        for(String s : split){
            System.out.print(s + " ");
        }
    }

}


