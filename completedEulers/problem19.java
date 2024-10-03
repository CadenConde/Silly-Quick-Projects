import java.util.ArrayList;

public class problem19 {
    public static void main(String[] args) {
        ArrayList<Integer> dayCounts = new ArrayList<Integer>();
        dayCounts.add(31);
        dayCounts.add(28);
        dayCounts.add(31);
        dayCounts.add(30);
        dayCounts.add(31);
        dayCounts.add(30);
        dayCounts.add(31);
        dayCounts.add(31);
        dayCounts.add(30);
        dayCounts.add(31);
        dayCounts.add(30);
        dayCounts.add(31);
        int year = 1901;
        int ans = 0;
        int i = 1;
        String[] day = { "mon", "tues", "wed", "thurs", "fri", "sat", "sun" };
        while (year <= 2000) {
            if (year % 4 == 0 && year % 400 != 0) {
                dayCounts.set(1, 29);
            }
            for (int months = 0; months <= 11; months++) {
                for (int days = 1; days <= dayCounts.get(months); days++) {
                    if (days == 1 && day[i] == "sun") {
                        ans++;
                    }
                    i++;
                    if (i > 6) {
                        i = 0;
                    }
                }
            }

            year++;
            dayCounts.set(1, 28);
        }
        System.out.println(ans);
    }
}
