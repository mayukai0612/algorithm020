import java.util.HashMap;

public class LemonadeChange_860 {
    public boolean lemonadeChange(int[] bills) {
        HashMap<Integer, Integer> cashMap = new HashMap<>();

        for (int i = 0; i < bills.length; i++) {
            if(bills[i] == 5){
                cashMap.put(5, cashMap.getOrDefault(5, 0) + 1);
            }

            if(bills[i] == 10){
                int fiveCnt = cashMap.getOrDefault(5, 0);
                if(fiveCnt > 0){
                    cashMap.put(5,fiveCnt - 1);
                    cashMap.put(10, cashMap.getOrDefault(10, 0) + 1);
                    continue;
                }else {
                    return false;
                }
            }

            if(bills[i] == 20){
                int fiveCnt = cashMap.getOrDefault(5, 0);
                int tenCnt = cashMap.getOrDefault(10, 0);
                if(fiveCnt == 0) {
                    return false;
                }

                if(tenCnt == 0 && fiveCnt < 3) {
                    return false;
                }

                if(tenCnt == 0){
                    cashMap.put(5, fiveCnt - 3);
                }else {
                    cashMap.put(5, fiveCnt - 1);
                    cashMap.put(10, tenCnt - 1);
                }
            }

        }

        return true;
    }
}
