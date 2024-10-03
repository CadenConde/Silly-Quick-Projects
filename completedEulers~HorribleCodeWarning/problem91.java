public class problem91 {
    public static void main(String[] args) {
        int dimen = 50 + 1;
        int ans = 0;
        for (int i = 1; i <= (dimen * dimen) - 1; i++) {
            int x1 = i / dimen;
            int y1 = i % dimen;
            for (int j = i + 1; j <= (dimen * dimen) - 1; j++) {
                int x2 = j / dimen;
                int y2 = j % dimen;
                if (isRight(x1, y1, x2, y2)) {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    }

    static boolean isRight(int x1, int y1, int x2, int y2) {
        double AB = Math.sqrt((0 - x1) * (0 - x1) + (0 - y1) * (0 - y1));
        double BC = Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1));
        double AC = Math.sqrt((0 - x2) * (0 - x2) + (0 - y2) * (0 - y2));
        double Asqu = Math.round((AB * AB) * 1000) / 1000;
        double Bsqu = Math.round((BC * BC) * 1000) / 1000;
        double Csqu = Math.round((AC * AC) * 1000) / 1000;
        if (Asqu + Bsqu == Csqu) {
            return true;
        }
        if (Asqu + Csqu == Bsqu) {
            return true;
        }
        if (Csqu + Bsqu == Asqu) {
            return true;
        }
        return false;
    }
}