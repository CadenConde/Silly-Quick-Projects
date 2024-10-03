package pokerHands;

import java.io.*;
import java.util.*;

//35?
public class pokerHands {
    public static void main(String[] args) throws Exception {
        Scanner poker = new Scanner(new File("pokerHands\\poker.txt"));
        int wins = 0;
        int row = 0;
        String hand = new String();

        // hand = poker.nextLine();
        // System.out.println(p1Wins(hand));
        while (poker.hasNext()) {
            row++;
            hand = poker.nextLine();
            if (p1Wins(hand)) {
                System.out.println(row);
                wins++;
            }
        }
        System.out.println(wins);
    }

    static boolean p1Wins(String hand) {

        String[] rawArr = new String[10];
        int[][] numArr = new int[10][2];
        for (int i = 0; i < 10; i++) {
            rawArr[i] = hand.substring(i * 3, (i + 1) * 3 - 1);
            switch (rawArr[i].substring(0, 1)) {
                case "T":
                    numArr[i][0] = 10;
                    break;
                case "J":
                    numArr[i][0] = 11;
                    break;
                case "Q":
                    numArr[i][0] = 12;
                    break;
                case "K":
                    numArr[i][0] = 13;
                    break;
                case "A":
                    numArr[i][0] = 14;
                    break;
                default:
                    numArr[i][0] = Integer.parseInt(rawArr[i].substring(0, 1));
                    break;
            }
            switch (rawArr[i].substring(1, 2)) {
                case "H":
                    numArr[i][1] = 1;
                    break;
                case "D":
                    numArr[i][1] = 2;
                    break;
                case "C":
                    numArr[i][1] = 3;
                    break;
                case "S":
                    numArr[i][1] = 4;
                    break;
                default:
                    break;
            }
        }
        // System.out.println(Arrays.deepToString(numArr));
        int[] p1Strength = getStrength(numArr, true);
        int[] p2Strength = getStrength(numArr, false);
        // System.out.println(Arrays.toString(p1Strength));
        // System.out.println(Arrays.toString(p2Strength));

        if (p1Strength[0] > p2Strength[0]) {
            return true;
        } else if (p1Strength[0] == p2Strength[0]) { // equal hand
            if (p1Strength[1] > p2Strength[1]) { // hand card strength
                return true;
            } else if (p1Strength[1] == p2Strength[1]) {
                if (p1Strength[0] == 6 || p1Strength[0] == 2) { // full house / 2 pair case
                    // System.out.println("here");
                    // System.out.println(p1Strength[0]);
                    if (p1Strength[2] > p2Strength[2]) {
                        return true;
                    }
                    if (p1Strength[2] < p2Strength[2]) {
                        return false;
                    }
                }

                if (p1Strength[3] > p2Strength[3]) { // next high cards
                    return true;
                }

                else if (p1Strength[3] == p2Strength[3]) {
                    if (p1Strength[4] > p2Strength[4]) {
                        return true;
                    } else if (p1Strength[4] == p2Strength[4]) {
                        if (p1Strength[5] > p2Strength[5]) {
                            return true;
                        } else if (p1Strength[5] == p2Strength[5]) {
                            if (p1Strength[6] > p2Strength[6]) {
                                return true;
                            }
                        }
                    }
                }
            }

        }
        return false;
    }

    static int[] getStrength(int[][] input, boolean player1) {
        // H = 1, D = 2, C = 3, S = 4
        int[] out = new int[7]; // hand, cards in hand, 2nd cards in full, high, 2nd high, 3rd high;
        int i = 0;
        if (!player1) {
            i = 5;
        }
        // System.out.println(i);

        int[] cardsFound = new int[15];
        boolean flush = false;
        boolean straight = false;
        boolean hasFour = false;
        boolean hasThree = false;
        int pairs = 0;
        int findStraight = 0;
        int H = 0;
        int D = 0;
        int C = 0;
        int S = 0;
        int low = 15;
        int high = 0;

        for (int j = i; j < i + 5; j++) { // flush checker & low
            if (input[j][1] == 1) {
                H++;
            } else if (input[j][1] == 2) {
                D++;
            } else if (input[j][1] == 3) {
                C++;
            } else if (input[j][1] == 4) {
                S++;
            }
            if (input[j][0] < low) {
                low = input[j][0];
            }
            if (input[j][0] == 14) {
                low = 1;
            }
        }

        if (H == 5 || D == 5 || C == 5 || S == 5) {
            flush = true;
        }
        contpt: for (int k = low; k < low + 5; k++) { // find straight
            for (int j = i; j < i + 5; j++) {
                if (input[j][0] == k || input[j][0] - 13 == k) {
                    findStraight++;
                    // System.out.println(k);
                    continue contpt;
                }
                if (findStraight < (k - low)) {
                    break contpt;
                }
            }
        }

        for (int j = i; j < i + 5; j++) {
            // System.out.println(j);
            cardsFound[input[j][0]]++;
        }

        for (int n = 0; n < cardsFound.length; n++) { // find 4, 3 and num of pairs
            if (cardsFound[n] == 4) {
                hasFour = true;
                out[1] = n + 1;
                if (n == 0) {
                    out[1] = 14;
                }
            }
            if (cardsFound[n] == 3) {
                hasThree = true;
                out[1] = n + 1;
                if (n == 0) {
                    out[1] = 14;
                }
            }
            if (cardsFound[n] == 2) {
                pairs++;
            }
        }

        if (findStraight == 5) { // staight

            high = low + 4;
            straight = true;
            if (low == 1) { // royal flush check
                high = 14;
            }
        }

        else if (hasThree && pairs == 1) { // full
            for (int n = 0; n < cardsFound.length; n++) {
                if (cardsFound[n] == 2) {
                    out[2] = n;
                }
            }
        }

        else if (hasThree) { // three
            for (int n = 0; n < cardsFound.length; n++) {
                if (cardsFound[n] == 1) {
                    if (n > out[3]) {
                        out[4] = out[3];
                        out[3] = n;
                    } else {
                        out[4] = n;
                    }
                }
            }
        }

        else if (hasFour) { // four

            for (int n = 0; n < cardsFound.length; n++) {
                if (cardsFound[n] == 1) {
                    out[3] = n;
                }
            }
        }

        else if (pairs == 2) { // 2 pair
            for (int n = 0; n < cardsFound.length; n++) {
                if (cardsFound[n] == 2) {
                    if (n > out[1]) {
                        out[2] = out[1];
                        out[1] = n;
                    } else {
                        out[2] = n;
                    }
                }
                if (cardsFound[n] == 1) {
                    out[3] = n;
                }
            }
        }

        else if (pairs == 1) { // 1 pair
            // System.out.println("i ran2");
            for (int n = 0; n < cardsFound.length; n++) {
                if (cardsFound[n] == 2) {
                    out[1] = n;
                }
                if (cardsFound[n] == 1) {
                    if (n > out[3]) {
                        out[5] = out[4];
                        out[4] = out[3];
                        out[3] = n;
                    } else {
                        if (n > out[4]) {
                            out[5] = out[4];
                            out[4] = n;
                        } else {
                            out[5] = n;
                        }
                    }
                }
            }
        }

        else { // flush / nothing
            for (int n = 0; n < cardsFound.length; n++) {
                if (cardsFound[n] > 0) {
                    if (n > out[1]) {
                        out[6] = out[5];
                        out[5] = out[4];
                        out[4] = out[3];
                        out[3] = out[1];
                        out[1] = n;
                    } else {
                        if (n > out[3]) {
                            out[6] = out[5];
                            out[5] = out[4];
                            out[4] = out[3];
                            out[3] = n;
                        } else {
                            if (n > out[4]) {
                                out[6] = out[5];
                                out[5] = out[4];
                                out[4] = n;
                            } else {
                                if (n > out[5]) {
                                    out[6] = out[5];
                                    out[5] = n;
                                } else {
                                    out[6] = n;
                                }
                                out[5] = n;
                            }
                        }
                    }
                }

            }
        }

        if (straight && flush) { // done
            out[0] = 8;
            out[1] = high;
        } else if (hasFour) { // done
            out[0] = 7;
        } else if (hasThree && pairs == 1) { // full done
            out[0] = 6;
        } else if (flush) { // done
            out[0] = 5;
        } else if (straight) { // done
            out[0] = 4;
            out[1] = high;
        } else if (hasThree) { // done
            out[0] = 3;
        } else if (pairs == 2) { // done

            out[0] = 2;
        } else if (pairs == 1) { // done
            out[0] = 1;
        } else { // done
            out[0] = 0;
        }

        return out;
    }
}
