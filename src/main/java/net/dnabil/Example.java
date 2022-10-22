package net.dnabil;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author dnabil
 */
public class Example {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {

        HckrankCase testCase = new HckrankCase("./exampleOutput");
        int cases[] = { 1, 2, 3, 4, 5, 6, 7, 8 };

        String res = "";
        for (int i : cases) {
            res = soal1(i);
            testCase.input.addLine(String.valueOf(i));
            testCase.output.addLine(res);

            System.out.println(res);
            try {
                testCase.createFile();
            } catch (IOException e) {
                e.printStackTrace();
                System.exit(0);
            }
        }
    }

    static public String soal1(int x) {
        return String.valueOf(x + x);
    }

}
