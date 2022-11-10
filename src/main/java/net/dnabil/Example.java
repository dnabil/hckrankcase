package net.dnabil;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author dnabil
 */
public class Example {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        // HckrankCase obj to for writing test cases into files
        HckrankCase isOddChallange = new HckrankCase("./exampleOutput/isOdd");

        // 10 cases
        String inputExamples = "1\n2\n3\n4\n5\n6\n7\n8\n9\n10";
        Scanner scan = new Scanner(inputExamples);

        String outputExample;
        int userInput;
        while (scan.hasNext()) {
            userInput = scan.nextInt();
            outputExample = String.format("%d is %s", userInput, isOdd(userInput) ? "odd" : "even");

            // using HckrankCase obj to write input & output into a file (println/printf)
            isOddChallange.input.println(userInput);
            isOddChallange.output.println(outputExample);

            System.out.println(outputExample);
            // creating the files needed to upload to hackerrank
            try {
                isOddChallange.createFile();
            } catch (Exception e) {
                System.err.println("err: HckrankCase failed to create files");
                e.printStackTrace();
                System.exit(0);
            }
        }
        scan.close();
    }

    // (challenge) algorithm to check wether a number is odd or not
    static public boolean isOdd(int x) {
        return x % 2 == 1;
    }

}
