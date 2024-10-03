import java.math.*;

public class algs {

    // to use these methods, just include algs.method in .java file in the same folder

    public static boolean isPrime(long primeCand) { //optimized prime detecting algorithm
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

    //two different permutations return the same output
    //(e.g. 123325 and 135223 both equal 102210)
    public long fingerprint(long input) { 
        long out = 0;
        while (input > 0) {
            switch ((int) input % 10) {
                case 0:
                    out += 1;
                    break;
                case 1:
                    out += 10;
                    break;
                case 2:
                    out += 100;
                    break;
                case 3:
                    out += 1000;
                    break;
                case 4:
                    out += 10000;
                    break;
                case 5:
                    out += 100000;
                    break;
                case 6:
                    out += 1000000;
                    break;
                case 7:
                    out += 10000000;
                    break;
                case 8:
                    out += 100000000;
                    break;
                case 9:
                    out += 1000000000;
                    break;

            }
            input /= 10;
        }
        return out;
    }

    //digit sum of BigInteger datatype
    public static BigInteger sumOfDigits(BigInteger bint) {
        BigInteger sum = BigInteger.ZERO;

        BigInteger currDigit = null;
        do {
            BigInteger divisor = numDigs(bint);

            currDigit = bint.divide(divisor);
            sum = sum.add(currDigit);
            bint = bint.mod(divisor);
        } while (currDigit.compareTo(BigInteger.ZERO) > 0);

        return sum;
    }

    //sum the digits of a number
    public static int sumDigs(long sumMe) {
        int sum = 0;

        do {
            sum += sumMe % 10;
            sumMe /= 10;
        } while (sumMe > 0);

        return sum;
    }

    //number of digits in a BigInteger
    public static BigInteger numDigs(BigInteger bint) {
        BigInteger divisor = BigInteger.ONE;

        int length = bint.toString().length();
        for (int i = 0; i < length - 1; i++) {
            divisor = divisor.multiply(BigInteger.TEN);
        }

        return divisor;
    }

    //number of digits in a long
    public static long numDigs(long bint) {
        long divisor = (long) Math.floor(Math.log10(bint) + 1);
        return divisor;
    }

    //hyperoptimized GCD function
    public static int gcd(int a, int b) {
        if (b == 0)
            return a;
        else
            return
            gcd(b, a % b);
    }

    //test for palindrome
    public static boolean isPalindrome(long num){
        long flipped = 0;
        long flipMe = num;
        while(flipMe>0){
            flipped *= 10;
            flipped += flipMe%10;
            flipMe /= 10;
        }
        if(flipped == num){
            return true;
        }
        else{
            return false;
        }
    }

    public static int rad(int n){
        if(algs.isPrime(n)){
            return n;
        }
        
        int prod = 1;
        if(n % 2 == 0){
            prod*=2;
            while(n%2==0){
                n /= 2;
            }
        }
        for(int i = 3; i<=n; i+=2){
            if(algs.isPrime(i)){
                if(n % i == 0){
                    prod *= i;
                    while(n%i==0){
                        n /= i;
                    }
                }
            }
        }
        return prod;
    }
}
