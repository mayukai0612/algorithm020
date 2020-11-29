import java.util.HashMap;

public class PlusOne {
    public int[] plusOne(int[] digits) {

        for(int i = digits.length - 1; i >=0; i--){
            if(digits[i] < 9){
                digits[i]++;
                return digits;
            }else{
                digits[i] = 0;
            }
        }

        int[] newDigits = new int[digits.length + 1];
        newDigits[0] = 1;
        return newDigits;

    }

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int a : A) {
            for (int b : B){
                map.put( -a-b, map.getOrDefault(-a-b, 0) + 1);
            }
        }

        int result = 0;
        for (int c : C){
            for (int d : D){
                if(map.containsKey(c + d)){
                    result += map.get(c+d);
                }
            }
        }

        return result;
    }
}
