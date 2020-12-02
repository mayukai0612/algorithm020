import java.util.ArrayList;
import java.util.HashMap;
import java.util.PriorityQueue;

public class TwoSum_01 {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }else {
                map.put(nums[i], i);
            }
        }

        return new int[]{0};
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int low = 0;
        int high = k - 1;
        ArrayList<Integer> list = new ArrayList();
        PriorityQueue<Integer> queue = new PriorityQueue();
        for (int i = 0; i <= high; i++) {
            queue.add(nums[i]);
        }

        while(high <= nums.length - 1){
            int max = queue.peek();
            list.add(max);
            queue.remove(nums[low--]);
            queue.add(nums[high++]);
        }

        int[] ints = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            ints[i] = list.get(i);
        }

        return ints;
    }
}
