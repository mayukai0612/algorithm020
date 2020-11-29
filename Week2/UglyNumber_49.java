import java.util.ArrayList;

public class UglyNumber_49 {

    //DP
    public int nthUglyNumber(int n) {
        int a = 0, b = 0 ,c = 0;
        ArrayList<Integer> dp = new ArrayList<>();
        dp.add(1);
        for (int i = 1; i < n; i++) {
            int n2 = dp.get(a) * 2;
            int n3 = dp.get(b) * 3;
            int n5 = dp.get(c) * 5;
            dp.add(Math.min(Math.min(n2, n3), n5));
            if(dp.get(i) == n2) a++;
            if(dp.get(i) == n3) b++;
            if(dp.get(i) == n5) c++;
        }

        return dp.get(n - 1);
    }
}
