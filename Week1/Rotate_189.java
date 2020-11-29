import java.util.Stack;

public class Rotate_189 {
    public void rotate(int[] nums, int k) {
        //暴力解法，每次移动一位
        for (int i = 0; i < k; i++) {
            int pre = nums[nums.length - 1];
            for (int j = 0; j < nums.length; j++) {
                //循环到的数 = 前一个数字
                int tmp = nums[j];
                nums[j] = pre;
                pre = tmp;
            }
        }
    }

    public void rotate1(int[] nums, int k){
        //用额外的数组空间
        int[] newNums = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newNums[(i + k) % nums.length] = nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            nums[i] = newNums[i];
        }
    }

    //环状替代
}
