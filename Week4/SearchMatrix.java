public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int left = 0, right = m * n - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            int cur = matrix[mid/n][mid % n];
            if(target == cur) return true;
            else {
                if(target < cur){
                    right = mid - 1;
                }else{
                    left = mid + 1;
                }
            }
        }
        return false;
    }
}
