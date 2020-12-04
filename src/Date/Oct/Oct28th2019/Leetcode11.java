package Date.Oct.Oct28th2019;

/**
 * Created by apple on 10/29/19.
 */
public class Leetcode11 {
    public static int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int n = height.length;
        int left = 0, right = n - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(area, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right]) left++;
            else right--;
        }
        return area;
    }
    public static void main(String[] args) {
        int[] data = new int[] {1,8,6,2,5,4,8,3,7};
        int res = maxArea(data);
        System.out.println(res);
        System.out.println("Integer.MAX_VALUE: "+ Integer.MAX_VALUE);
        System.out.println("Integer.MIN_VALUE: "+ Integer.MIN_VALUE);

    }

}
