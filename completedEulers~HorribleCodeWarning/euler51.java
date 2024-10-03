//121313
public class euler51 {
    public static void main(String[] args) {
        algs algs = new algs();
        int[] current;
        int small = 0;
        int count;
        int ansSmall = 1000000;

        for (int i = 100000; i <= 160627; i++) {
            for (int loopNum = 1; loopNum < 64; loopNum++) {
                count = 0;
                small = 0;
                current = toArr(i);
                for (int j = 0; j < 10; j++) {
                    if (loopNum % 2 >= 1) {
                        current[current.length - 1] = j;
                    }
                    if (loopNum % 4 >= 2) {
                        current[current.length - 2] = j;
                    }
                    if (loopNum % 8 >= 4) {
                        current[current.length - 3] = j;
                    }
                    if (loopNum % 16 >= 8) {
                        current[current.length - 4] = j;
                    }
                    if (loopNum % 32 >= 16) {
                        current[current.length - 5] = j;
                    }
                    if (loopNum % 64 >= 32) {
                        current[current.length - 6] = j;
                    }
                    if (toInt(current) < 100000) {

                    } else if (algs.isPrime(toInt(current))) {
                        count++;
                        if (small == 0) {
                            small = toInt(current);

                        }
                        if (count >= 8 && small < ansSmall) {
                            ansSmall = small;
                            System.out.println(small);
                            //System.out.println(toInt(current));
                        }
                    }
                }
            }
        }
    }

    static int toInt(int[] input) {
        int output = 0;
        for (int i = 0; i < input.length; i++) {
            output *= 10;
            output += input[i];
        }
        return output;
    }

    static int[] toArr(int input) {
        int size = 1;
        for (int i = 1; (Math.pow(10, i)) <= input; i++) {
            size = i + 1;
        }
        int[] output = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            output[i] = input % 10;
            input /= 10;
        }
        return output;
    }
}
