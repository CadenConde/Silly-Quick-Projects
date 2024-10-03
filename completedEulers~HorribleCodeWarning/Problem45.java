public class Problem45 {
    public static void main(String[] args) {
        double n = 144;
        double x;
        while (true) {
            x = n * ((2 * n) - 1);
            if (((1 + Math.sqrt(1 + (24 * x))) / 6) % 1 == 0) {
                System.out.println(x);
                break;
            }
            n++;
        }
    }
}