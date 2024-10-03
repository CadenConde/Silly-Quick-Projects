import java.math.BigInteger;

public class Problem48 {
    public static void main(String[] args) {
        BigInteger ans, temp;
        ans = BigInteger.ZERO;
        int n = 1;
        while (n <= 1000) {
            temp = BigInteger.valueOf(n);
            temp = temp.pow(n);
            ans = ans.add(temp);
            // System.out.println(ans);
            n++;
        }
        System.out.println(ans.mod(BigInteger.valueOf(10000000000L)));
    }

}