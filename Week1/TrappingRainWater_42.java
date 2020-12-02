import java.util.*;

public class TrappingRainWater_42 {

    //按列求，求出左边最大和右边最大
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for (int j = i - 1; j >= 0; j--) {
                maxLeft = Math.max(height[j], maxLeft);
            }

            int maxRight = 0;
            for (int j = i + 1; j < height.length; j++) {
                maxRight = Math.max(height[j], maxRight);
            }

            int min =  Math.min(maxLeft, maxRight);
            if(height[i] < min){
                res += min - height[i];
            }
        }
        return res;
    }

    //在上面方法的基础上，用动态规划
//    public int trap2(int[] height) {
//        int res = 0;
//        int[] maxLeft = new int[height.length - 2];
//        int[] maxRight = new int[height.length - 2];
//
//        for (int i = 1; i < height.length - 1; i++) {
//            maxLeft[i] = Math.max(maxLeft[i - 1], height[i-1]);
//            maxRight[i] = Math.max(maxRight[i - 1], height[i-1]);
//
//            int min =  Math.min(maxLeft, maxRight);
//            if(height[i] < min){
//                res += min - height[i];
//            }
//        }
//
//        return res;
//    }

}
