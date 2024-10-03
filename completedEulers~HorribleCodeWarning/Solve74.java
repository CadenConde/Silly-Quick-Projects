import java.util.HashMap;
import java.util.Map;

public class Solve74 {

    public static void main(String[] args) {
        Map<Integer, Integer> dict = new HashMap<Integer, Integer>();
        dict.put(169, 3);
        dict.put(363601, 3);
        dict.put(1454, 3);
        dict.put(871, 2);
        dict.put(45361, 2);
        dict.put(872, 2);
        dict.put(45362, 2);
        dict.put(145, 1);

        for (int i = 1; i < 1_000_000; i++) {
            if (facDigSum(i) == i) {
                dict.put(i, 0);
                continue;
            }
            int path = 0;
            long n = i;
            //System.out.println(i);

            while (!dict.containsKey((int) n)) {
                if (facDigSum(n) == n) {
                    dict.put((int) n, 1);
                } else {
                    path++;
                    n = facDigSum(n);
                    //System.out.println(n);
                }
            }
            dict.put(i, path + dict.get((int) n));
        }

        int ans = 0;

        //System.out.println(dict.size());
        //System.out.println(dict.toString());

        for (int i = 1; i < dict.size(); i++) {
            if (dict.get(i) == 60) {
                ans++;
            }
        }
        System.out.println(ans);
    }

    static long facDigSum(long n) {
        long sum = 0;
        while (n > 0) {
            sum += fac(n % 10);
            n /= 10;
        }
        return sum;
    }

    static long fac(long n) {
        if (n == 0) {
            return 1;
        }
        long fac = 1;
        for (long i = n; i > 0; i--) {
            fac *= i;
        }
        return fac;
    }
}
