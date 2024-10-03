import java.util.ArrayList;

import java.lang.Math;

public class problem23 {
    public static void main(String[] args) {
        ArrayList<Integer> abundants = new ArrayList<Integer>();
        long ans = 0;
        int limit = 28123;
        for (int l = 1; l <= 28123; l++) {
            if (factorSum(l) > l) {
                abundants.add(l);
            }
        }

        boolean[] canBe = new boolean[28123 + 1];
        for (int i = 0; i < abundants.size(); i++) {
            for (int j = i; j < abundants.size(); j++) {
                if (abundants.get(i) + abundants.get(j) < 28123) {
                    canBe[abundants.get(i) + abundants.get(j)] = true;
                }
            }
        }
        boolean[] canBeWrittenasAbundent = new boolean[limit + 1];
        for (int i = 0; i < abundants.size(); i++) {
            for (int j = i; j < abundants.size(); j++) {
                if (abundants.get(i) + abundants.get(j) <= limit) {
                    canBeWrittenasAbundent[abundants.get(i) + abundants.get(j)] = true;
                } else {
                    break;
                }
            }
        }

        for (int i = 1; i <= limit; i++) {
            if (!canBeWrittenasAbundent[i]) {
                ans += i;
            }
        }
        System.out.println(ans);
    }

    static Integer factorSum(int factorMe) {
        int sum = 0;
        for (double i = 2; i <= Math.sqrt(factorMe); i++) {
            if (factorMe % i == 0) {
                sum += i;
                sum += factorMe / i;
                if (i == factorMe / i) {
                    sum -= i;
                }
            }
        }
        sum += 1;
        return sum;
    }
}
