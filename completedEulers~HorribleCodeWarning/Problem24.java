
import java.util.*;

public class Problem24 {

    public static void main(String[] args) {
        ArrayList<String> values = new ArrayList<String>();
        char[] currentPerm = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

        values.add(String.valueOf(currentPerm));

        while (values.size() < 1000000) {

            if (values.size() % 2 == 1) {
                flipNums(currentPerm, 8, 9);
            } else {
                for (int i = 7; i >= 0; i--) {
                    if (findCeiler(currentPerm, i) >= 0) {
                        flipNums(currentPerm, i, findCeiler(currentPerm, i));
                        Arrays.sort(currentPerm, i + 1, currentPerm.length);
                        i = -1;
                    }
                }
            }

            values.add(String.valueOf(currentPerm));
        }
        System.out.println(values.get(999999));
    }

    static void flipNums(char[] input, int flip1, int flip2) {
        char tempStorage = input[flip1];
        input[flip1] = input[flip2];
        input[flip2] = tempStorage;
    }

    static int findCeiler(char[] input, int startingPt) {
        boolean firstAttempt = true;
        int ceilOut = 0;
        int findCeilOut = 0;
        for (int i = startingPt; i < input.length; i++) {

            if (input[startingPt] < input[i]) {

                findCeilOut = i;

                if (firstAttempt) {
                    ceilOut = i;
                    firstAttempt = false;
                } else if (input[findCeilOut] < input[ceilOut]) {
                    ceilOut = i;
                }
            }
        }
        if (ceilOut == 0) {
            return -1;
        } else {
            return ceilOut;
        }

    }
}