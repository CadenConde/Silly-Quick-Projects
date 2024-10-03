import java.lang.Math;


public class Problem21 {
    public static void main(String[] args) {
        int ans = 0;
        int x = 0;
        for (int i = 1; i < 10000; i++) {
            x = factorsSum(i);
            if (factorsSum(x) == i) {
                ans = ans + x + i;
                System.out.println("pair found!" + i + " " + x);
            }
        }
        System.out.println((ans / 2));
    }

    static int factorsSum(int candidate) {
        int responce = 0;
        for (int n = 1; n <= (int) (Math.ceil(Math.sqrt(candidate))); n++) {
            if (candidate % n == 0) {
                responce = responce + n;
                if (n != 1) {
                    responce = responce + (candidate / n);
                }
            }
        }
        return responce;
    }
}
