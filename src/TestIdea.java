import java.util.Scanner;

public class TestIdea {

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt(), m = cin.nextInt();
        char c[] = new char[51];
        for (int i = 0; i < 26; i++) {
            c[i] = (char) (i + 65);
            c[50 - i] = (char) (65 + i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++)
                System.out.print(c[j]);
            System.out.println();
            for (int j = 49; j >= 0; j--)
                c[j + 1] = c[j];
            c[0] = c[50];
        }
    }

}