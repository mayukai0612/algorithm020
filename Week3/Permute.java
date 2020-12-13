import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permute {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        int[] used = new int[nums.length];
        Arrays.fill(used, 0);
        dfs(nums, used, res, path);
        return res;
    }

    void dfs(int[] nums, int[] used, List<List<Integer>> res, ArrayDeque<Integer> path){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if(used[i] != 1){
                path.add(nums[i]);
                used[i] = 1;
                dfs(nums, used, res, path);
                path.removeLast();
                used[i] = 0;
            }
        }
    }
}
