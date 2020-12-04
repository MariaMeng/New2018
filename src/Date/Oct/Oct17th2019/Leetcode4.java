package Date.Oct.Oct17th2019;

/**
 * Created by apple on 10/18/19.
 */
public class Leetcode4 {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int k1 = (m + n + 1) / 2;
        int k2 = (m + n + 2) / 2;

        return (find(nums1, 0, nums2, 0, k1) + find(nums1, 0, nums2, 0, k2)) / 2.0;
    }

    public int find(int[] nums1, int start1, int[] nums2, int start2, int k) {
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        if (start2 >= nums2.length) return nums1[start1 + k - 1];

        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = start1 + k / 2 - 1;
        int mid2 = start2 + k / 2 - 1;

        int m1 = mid1 < nums1.length ? nums1[mid1]: Integer.MAX_VALUE;
        int m2 = mid2 < nums2.length ? nums2[mid2]: Integer.MAX_VALUE;

        if (m1 < m2) {
            return find(nums1, start1 + k / 2, nums2, start2, k - k / 2);
        } else {
            return find(nums1, start1, nums2, start2 + k / 2, k - k / 2);
        }
    }

    public static void main(String[] args) {
        Leetcode4 leetcode4 = new Leetcode4();
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        double res = leetcode4.findMedianSortedArrays(nums1, nums2);
        System.out.println(res);
    }
}
