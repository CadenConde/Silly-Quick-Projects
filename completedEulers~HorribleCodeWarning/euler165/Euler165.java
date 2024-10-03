import java.math.*;
import java.util.*;

//2872894
//2872867
//2872865

//accepted: *works for these*
//For temp = 500 --> 29496
//For temp = 700 --> 57909

//2868958
//2868959
//2868960

//2868848 530
//**2868868** (I think....)

public class Euler165 {

    public static ArrayList<Double> multipoints = new ArrayList<Double>();
    public static int[] points = new int[20000];
    public static double currentX = 0;
    public static double currentY = 0;
    public static int precision = 602;

    public static void main(String[] args) {
        Random(290797);

        /*
         * points[0] = 413;
         * points[1] = 140;
         * points[2] = 306;
         * points[3] = 28;
         * 
         * points[4] = 448;
         * points[5] = 121;
         * points[6] = 78;
         * points[7] = 121;
         * 
         * points[8] = 0;
         * points[9] = 1;
         * points[10] = 2;
         * points[11] = 0;
         * 
         * points[12] = 0;
         * points[13] = 2;
         * points[14] = 2;
         * points[15] = 0;
         * 
         * points[16] = 0;
         * points[17] = 2;
         * points[18] = 4;
         * points[19] = 0;
         */

        // System.out.println(doesInter(0 * 4, 1 * 4));

        int ans = 0;
        int temp = 5000; // 5000

        boolean multipoint;
        for (int index1 = 0; index1 < temp; index1++) {
            for (int index2 = index1 + 1; index2 < temp; index2++) {
                if (doesInter(index1 * 4, index2 * 4)) {
                    multipoint = false;
                    for (int index3 = 0; (index3 < temp) && (!multipoint); index3++) {
                        if (index3 == index2 || index3 == index1) {
                            continue;
                        }
                        if (isSolution(index3 * 4)) {
                            multipoint = true;
                        }
                    }
                    if (multipoint) {
                        // System.out.println("here");
                        addMulti();
                    } else {
                        ans++;
                    }

                }
            }
            System.out.println(index1 + " " + multipoints.size() / 2);
        }
        System.out.println(ans + (multipoints.size() / 2));

    }

    static void addMulti() {
        boolean found = false;
        for (int i = 0; (i < multipoints.size() - 1) && (!found); i += 2) {
            if (multipoints.get(i) == currentX) {
                if (multipoints.get(i + 1) == currentY) {
                    found = true;
                }
            }
        }
        if (!found) {
            multipoints.add(currentX);
            multipoints.add(currentY);
        }
    }

    static boolean isSolution(int index) {
        double x1 = points[index]; // points for 1st seg
        double y1 = points[index + 1];
        double x2 = points[index + 2];
        double y2 = points[index + 3];

        if (x1 == x2) {
            if (currentX == x1) {
                if (((y1 < currentY) && (currentY < y2)) || ((y1 > currentY) && (currentY > y2))) {
                    return true;
                } else {
                    return false;
                }
            }
        }

        double m = (y1 - y2) / (x1 - x2);

        if ((currentX == x1 || currentX == x2) && (currentY == y1 || currentY == y2)) {
            return false;
        }
        if (currentY == m * (currentX - x1) + y1) {
            if (((x1 < currentX) && (currentX < x2)) || ((x1 > currentX) && (currentX > x2))) {
                if (((y1 < currentY) && (currentY < y2)) || ((y1 > currentY) && (currentY > y2))) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean doesInter(int index1, int index2) {
        double x1 = points[index1]; // points for 1st seg
        double y1 = points[index1 + 1];
        double x2 = points[index1 + 2];
        double y2 = points[index1 + 3];

        double x3 = points[index2]; // points for 2nd seg
        double y3 = points[index2 + 1];
        double x4 = points[index2 + 2];
        double y4 = points[index2 + 3];

        double y = 0;

        if ((x3 == x4) && (x1 == x2)) { // both vertical lines
            return false;
        }

        if (x3 == x4) { // vertical line case 1
            double m1 = (y1 - y2) / (x1 - x2);
            y = m1 * (x3 - x1) + y1;
            y = Math.round(y * precision);
            y = y / precision;
            if (((y3 < y && y < y4) || (y3 > y && y > y4)) && ((y1 < y && y < y2) || (y1 > y && y > y2))) {
                // System.out.println(y + " " + y3 + " " + y4);
                currentX = x3;
                currentY = y;
                return true;
            } else {
                return false;
            }
        }

        if (x1 == x2) { // vertical line case 2
            double m2 = (y3 - y4) / (x3 - x4);
            y = m2 * (x1 - x3) + y3;
            y = Math.round(y * precision);
            y = y / precision;
            if (((y3 < y && y < y4) || (y3 > y && y > y4)) && ((y1 < y && y < y2) || (y1 > y && y > y2))) {
                currentX = x1;
                currentY = y;
                return true;
            } else {
                return false;
            }
        }

        double m1 = (y1 - y2) / (x1 - x2); // slopes
        double m2 = (y3 - y4) / (x3 - x4);

        if (m1 == m2) { // no infinite/zero points
            // System.out.println(index1 + " " + index2);
            return false;
        }

        // overlap x?
        if (((x1 < x3 && x2 < x3) && (x1 < x4 && x2 < x4)) || ((x1 > x3 && x2 > x3) && (x1 > x4 && x2 > x4))) {
            return false;
        }

        double x = (((m1 * x1) - (m2 * x3) + y3 - y1) / (m1 - m2)); // intersection point
        y = m2 * (x - x3) + y3;

        x = Math.round(x * precision);
        x = x / precision;

        y = Math.round(y * precision);
        y = y / precision;

        // System.out.println(x + " " + y);

        if (((x1 < x) && (x < x2)) || ((x1 > x) && (x > x2))) {
            if (((x3 < x) && (x < x4)) || ((x3 > x) && (x > x4))) {

                if ((y1 == y2) || (y3 == y4)) {
                    currentX = x;
                    currentY = y;
                    return true;
                } else if (((y3 < y && y < y4) || (y3 > y && y > y4)) && ((y1 < y && y < y2) || (y1 > y && y > y2))) {

                    currentX = x;
                    currentY = y;

                    return true;

                } else {
                    // System.out.println(x + " " + y);
                    // System.out.println(x1 + " " + y1 + " " + x2 + " " + y2);
                    // System.out.println(x3 + " " + y3 + " " + x4 + " " + y4 + "\n");

                }

            }
        }

        return false;
    }

    static void Random(int seed) {
        BigInteger S, S2, T;
        S = BigInteger.valueOf(seed);
        for (int i = 0; i < points.length; i++) {

            S2 = S.multiply(S).mod(BigInteger.valueOf(50515093));
            S = S2;
            T = S.mod(BigInteger.valueOf(500));
            points[i] = T.intValue();
        }
    }
}