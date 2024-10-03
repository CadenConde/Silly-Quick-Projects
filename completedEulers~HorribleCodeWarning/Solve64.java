import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Solve64 {
    public static void main(String[] args) {
        int oddPer = 0;
        for (int i = 2; i <= 10000; i++) {
            //ignore perfect squares
            if (Math.sqrt(i) % 1 != 0) {
                if (findPeriod(i) % 2 == 1) {
                    oddPer++;
                }
            }

        }
        System.out.println(oddPer);
    }

    public static long findPeriod(int Nroot) {
        MathContext mc = new MathContext(400);

        BigDecimal init = new BigDecimal(Nroot);
        init = init.sqrt(mc);
        long per = 0;
        BigDecimal a = BigDecimal.ONE;
        a = a.divide(init.subtract(init.setScale(0, RoundingMode.FLOOR)), mc);
        per++;
        while (!a.setScale(0, RoundingMode.FLOOR)
                .equals(BigDecimal.TWO.multiply(init.setScale(0, RoundingMode.FLOOR)))) {
            a = BigDecimal.ONE.divide(a.subtract(a.setScale(0, RoundingMode.FLOOR)), mc);
            per++;

        }
        return per;
    }
}
