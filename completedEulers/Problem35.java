import java.lang.Math;

public class Problem35 {

    public static void main(String[] args) {
        int ans = 0;
        boolean isCircle;
        for (int i = 2; i < 1000000; i++) {
            if (isPrime(i)) {
                isCircle = true;
                char[] circleI = String.valueOf(i).toCharArray();
                for (int j = 1; j < circleI.length; j++) {
                    rotate(circleI);
                    if (!isPrime(Integer.parseInt(String.valueOf(circleI)))) {
                        isCircle = false;
                    }
                }
                if (isCircle) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static void rotate(char[] input) {
        char temp = input[0];
        for (int i = 0; i <= input.length - 2; i++) {
            input[i] = input[i + 1];
        }
        input[input.length - 1] = temp;
    }

    static boolean isPrime(long primeCand) {
        if (primeCand == 2 || primeCand == 3) {
            return true;
        } else if (primeCand % 2 == 0 || primeCand % 3 == 0) {
            return false;
        } else {
            for (long i = 1; (i * 6) - 1 <= Math.ceil(Math.sqrt(primeCand)); i++) {
                if (primeCand % ((i * 6) - 1) == 0 || primeCand % ((i * 6) + 1) == 0) {
                    return false;
                }
            }
            return true;
        }
    }
}