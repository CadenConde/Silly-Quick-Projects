public class problem60 {
    public static void main(String[] args) {

        algs algs = new algs();
        for (int a = 3; a + a + a + a + a < 30000; a += 2) {
            String aStr = String.valueOf(a);
            if (algs.isPrime(a)) {
                for (int b = a; a + b + b + b + b < 30000; b += 2) {
                    String bStr = String.valueOf(b);
                    if (algs.isPrime(b)) {
                        if (algs.isPrime(Integer.parseInt(bStr + aStr))
                                && algs.isPrime(Integer.parseInt(aStr + bStr))) {
                            for (int c = b; a + b + c + c + c < 30000; c += 2) {
                                String cStr = String.valueOf(c);
                                if (algs.isPrime(c)) {
                                    if (algs.isPrime(Integer.parseInt(cStr + aStr))
                                            && algs.isPrime(Integer.parseInt(aStr + cStr))) {
                                        if (algs.isPrime(Integer.parseInt(cStr + bStr))
                                                && algs.isPrime(Integer.parseInt(bStr + cStr))) {
                                            for (int d = c; a + b + c + d + d < 30000; d += 2) {
                                                String dStr = String.valueOf(d);
                                                if (algs.isPrime(d)) {
                                                    if (algs.isPrime(Integer.parseInt(dStr + aStr))
                                                            && algs.isPrime(Integer.parseInt(aStr + dStr))) {
                                                        if (algs.isPrime(Integer.parseInt(dStr + bStr))
                                                                && algs.isPrime(Integer.parseInt(bStr + dStr))) {
                                                            if (algs.isPrime(Integer.parseInt(dStr + cStr))
                                                                    && algs.isPrime(Integer.parseInt(cStr + dStr))) {
                                                                for (int e = d; a + b + c + d + e < 30000; e += 2) {
                                                                    String eStr = String.valueOf(e);
                                                                    if (algs.isPrime(e)) {
                                                                        if (algs.isPrime(Integer.parseInt(eStr + aStr))
                                                                                && algs.isPrime(Integer
                                                                                        .parseInt(aStr + eStr))) {
                                                                            if (algs.isPrime(
                                                                                    Integer.parseInt(eStr + bStr))
                                                                                    && algs.isPrime(Integer
                                                                                            .parseInt(bStr + eStr))) {
                                                                                if (algs.isPrime(
                                                                                        Integer.parseInt(eStr + cStr))
                                                                                        && algs.isPrime(
                                                                                                Integer.parseInt(
                                                                                                        cStr + eStr))) {
                                                                                    if (algs.isPrime(Integer
                                                                                            .parseInt(eStr + dStr))
                                                                                            && algs.isPrime(Integer
                                                                                                    .parseInt(dStr
                                                                                                            + eStr))) {
                                                                                        System.out.println(
                                                                                                a + b + c + d + e);
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
