import java.util.*;

public class Problem43 {
    static long total = 0;

    public static void main(String[] args) {

        Problem43.permute(java.util.Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9), 0);
        System.out.println(total);
    }

    static void permute(java.util.List<Integer> arr, int k) {
        for (int i = k; i < arr.size(); i++) {
            java.util.Collections.swap(arr, i, k);
            permute(arr, k + 1);
            java.util.Collections.swap(arr, k, i);
        }
        if (k == arr.size() - 1) {
            int[] intArr = arr.stream().mapToInt(Integer::intValue).toArray();
            if (isSubDiv(intArr)) {
                System.out.println(Arrays.toString(intArr));
                total += toLong(intArr);
            }
        }
    }

    static long toLong(int[] input) {
        long output = input[0];
        for (int i = 1; i < input.length; i++) {
            output *= 10;
            output += input[i];
        }
        return output;
    }

    static boolean isSubDiv(int[] input) {
        if (((input[1] * 100) + (input[2] * 10) + input[3]) % 2 == 0) {
            if (((input[2] * 100) + (input[3] * 10) + input[4]) % 3 == 0) {
                if (((input[3] * 100) + (input[4] * 10) + input[5]) % 5 == 0) {
                    if (((input[4] * 100) + (input[5] * 10) + input[6]) % 7 == 0) {
                        if (((input[5] * 100) + (input[6] * 10) + input[7]) % 11 == 0) {
                            if (((input[6] * 100) + (input[7] * 10) + input[8]) % 13 == 0) {
                                if (((input[7] * 100) + (input[8] * 10) + input[9]) % 17 == 0) {
                                    return true;
                                }
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
