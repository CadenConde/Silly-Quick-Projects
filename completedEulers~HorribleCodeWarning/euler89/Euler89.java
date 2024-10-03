import java.io.*;
import java.util.*;

public class Euler89 {

    public Scanner inputFile;

    public Euler89() throws Exception {
        try { // get input & output files
            inputFile = new Scanner(new File("roman.txt"));
        } catch (Exception e) {
            System.out.println("file not found");
        }
    }

    public static void main(String[] args) throws Exception {
        int originalChar = 0;
        int newChar = 0;
        Euler89 file = new Euler89();
        String placeholder;

        while (file.inputFile.hasNext()) {
            placeholder = file.inputFile.nextLine();
            originalChar += placeholder.length();
            newChar += toRoman(toArabic(placeholder)).length();

        }
        System.out.println("Original total: " + originalChar);
        System.out.println("New total: " + newChar);
        System.out.println("Answer: " + (originalChar - newChar));
    }

    static String toRoman(int input) {
        String output = "";
        // thousands
        for (int i = 0; i < input / 1000; i++) {
            output = output.concat("M");
        }
        // hundreds
        switch ((input / 100) % 10) {
            case 0:
                break;
            case 1:
                output = output.concat("C");
                break;
            case 2:
                output = output.concat("CC");
                break;
            case 3:
                output = output.concat("CCC");
                break;
            case 4:
                output = output.concat("CD");
                break;
            case 5:
                output = output.concat("D");
                break;
            case 6:
                output = output.concat("DC");
                break;
            case 7:
                output = output.concat("DCC");
                break;
            case 8:
                output = output.concat("DCCC");
                break;
            case 9:
                output = output.concat("CM");
                break;
        }
        // tens
        switch ((input / 10) % 10) {
            case 0:
                break;
            case 1:
                output = output.concat("X");
                break;
            case 2:
                output = output.concat("XX");
                break;
            case 3:
                output = output.concat("XXX");
                break;
            case 4:
                output = output.concat("XL");
                break;
            case 5:
                output = output.concat("L");
                break;
            case 6:
                output = output.concat("LX");
                break;
            case 7:
                output = output.concat("LXX");
                break;
            case 8:
                output = output.concat("LXXX");
                break;
            case 9:
                output = output.concat("XC");
                break;
        }
        // ones
        switch (input % 10) {
            case 0:
                break;
            case 1:
                output = output.concat("I");
                break;
            case 2:
                output = output.concat("II");
                break;
            case 3:
                output = output.concat("III");
                break;
            case 4:
                output = output.concat("IV");
                break;
            case 5:
                output = output.concat("V");
                break;
            case 6:
                output = output.concat("VI");
                break;
            case 7:
                output = output.concat("VII");
                break;
            case 8:
                output = output.concat("VIII");
                break;
            case 9:
                output = output.concat("IX");
                break;
        }
        return output;
    }

    static int toArabic(String input) {
        ArrayList<Integer> intArray = new ArrayList<Integer>();
        int output = 0;
        int currentBig = 0;
        for (int i = 0; i < input.length(); i++) {
            switch (input.charAt(i)) {
                case 'I':
                    intArray.add(1);
                    break;
                case 'V':
                    intArray.add(5);
                    break;
                case 'X':
                    intArray.add(10);
                    break;
                case 'L':
                    intArray.add(50);
                    break;
                case 'C':
                    intArray.add(100);
                    break;
                case 'D':
                    intArray.add(500);
                    break;
                case 'M':
                    intArray.add(1000);
                    break;
                default:
                    System.out.println("bad input");
                    break;
            }
        }
        currentBig = intArray.get(intArray.size() - 1);

        for (int j = intArray.size() - 1; j >= 0; j--) {
            if (intArray.get(j) < currentBig) {
                output -= intArray.get(j);
            } else {
                output += intArray.get(j);
                if (intArray.get(j) > currentBig) {
                    currentBig = intArray.get(j);
                }
            }
        }
        return output;
    }
}