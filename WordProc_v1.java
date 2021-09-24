import java.util.*;
import java.io.*; // additional import needed for file operations

public class WordProc_v1 {

    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("Welcome to Word Processor, v1\n");
        
        Scanner keyb = new Scanner(System.in);
        System.out.print("What file name to use? ");
        String outFileName = keyb.nextLine();
        PrintWriter pw = new PrintWriter(outFileName);
        
        System.out.println("Type anything you want, press <ENTER> at the end of a line");
        System.out.println("Finish by entering STOP on a line by itself");
        
        int totalChars = 0;
        int numLines = 0;
        int numWords = 0;
        int totalWords = 0;
        String longestLine = "";
        int mostWords = 0;
        String userLineOfInput = "";
        while (!userLineOfInput.equals("STOP")) {
            System.out.print("==> ");
            userLineOfInput = keyb.nextLine();
            int numChars = userLineOfInput.length();
            totalChars = totalChars + numChars;
            
            if (!userLineOfInput.equals("STOP")) {
                pw.println(userLineOfInput);
                numLines++;
                if (!userLineOfInput.equals("")) {
                    numWords = userLineOfInput.split(" ").length;
                    totalWords = totalWords + numWords; 
                }
            }
            if (userLineOfInput.length() > longestLine.length()) {
                longestLine = userLineOfInput;
            }
            if (numWords > mostWords) {
                mostWords = numWords;
            }
        }
        System.out.printf("Wrote %d lines (%d words, %d characters) to '%s'\n",
                        numLines, totalWords, totalChars, outFileName);
        
        System.out.println("\nThe longest line has " + longestLine.length() + " characters");
        System.out.println("The longest line is:\n" + longestLine);
        System.out.println("The most words on a single line is " + mostWords);
        
        pw.close();
        System.out.println("\nThanks for using the Word Processor, v1");
    }
}