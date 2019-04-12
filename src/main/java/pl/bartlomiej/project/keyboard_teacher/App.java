package pl.bartlomiej.project.keyboard_teacher;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;


public class App {
    public static void main(String[] args) {

        try {

            String filePathWithExampleText;

            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter file path to start learning :)");

            System.out.println("example path: resource/example_text.txt");

            filePathWithExampleText = scanner.next();

            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePathWithExampleText));

            String row;

            String rowFromUser;

            int count = 1;

            long time = System.nanoTime();

            while ((row = bufferedReader.readLine()) != null) {

                System.out.println("Line number " + count + ": " + row);

                while (true) {
                    rowFromUser = scanner.next();

                    if (row.length() > rowFromUser.length()) {

                        System.out.println("Not enough characters entered");
                    } else if (row.length() < rowFromUser.length()) {
                        System.out.println("Too many characters entered");
                    } else {

                        for (int i = 0; i < rowFromUser.length(); i++) {

                            if ((rowFromUser.charAt(i) == row.charAt(i)) == false) {

                                System.out.println("Number of first non-valid character is " + (i + 1));
                                System.out.println("Try to rewrite the word again");
                                break;
                            }

                        }

                        if (row.compareTo(rowFromUser) == 0) {
                            System.out.println("Congratulations, you've entered text line correctly");
                            System.out.println();
                            break;
                        }
                    }

                }

                count++;
            }

            long durationOfTheProgram = TimeUnit.SECONDS.convert(((System.nanoTime() - time)), TimeUnit.NANOSECONDS);

            System.out.println("Congratulations");
            System.out.println("You have successfully completed the task in " + durationOfTheProgram + " sec");
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }


    }
}
