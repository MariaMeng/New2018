package Date.Mar;

/**
 * @author mengxiang
 * @date 20/3/21
 */
public class Leetcode365 {
    public boolean canMeasureWater(int x, int y, int z) {
        if (x + y < z) return false;
        if (x == 0 || y == 0) return z == 0 || x + y == z;
        return z % gcd(x, y) == 0;
    }

    public int gcd(int x, int y) {
        int min = x >= y? y: x;
        int gcd = 1;
        for (int i = 2; i <= min; i++) {
            if (x % i == 0 && y % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }
}
