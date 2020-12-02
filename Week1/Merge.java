public class Merge {

    //复制一个新的数组，从前往后比较
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1Copy = new int[m];
        System.arraycopy(nums1, 0, nums1Copy, 0, m);

        int p1 = 0; int p2 = 0;
        int p = 0;

        while (p1 < m && p2 < n){
            nums1[p++] = nums1Copy[p1] <= nums2[p2] ? nums1Copy[p1++] : nums2[p2++];
        }

        while(p1 < m){
            nums1[p++] = nums1Copy[p1++];
        }

        while (p2 < n){
            nums1[p++] = nums2[p2++];
        }
    }

    //不用复制新数组，从后往前比较
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1, p = nums1.length - 1;
        while(p1 >=0 && p2 >= 0)
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];

        System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
    }

}
