package BitOp;

/**
 * Created by apple on 10/8/18.
 */
public class OddsApperance {
    public static int[] findOdds(int[] arr, int n) {
        // write code here
        if (arr == null || n == 0) return null;
        int exo = 0, min = 0, max = 0;
        for (int a : arr)
            exo ^= a;
        int rot = find(exo);
        for (int a : arr)
            if ((a >> rot & 1) == 0)
                min ^= a;
            else
                max ^= a;

        int[] res = new int[2];
        res[0] = Math.min(min, max);
        res[1] = Math.max(max, min);
        return res;
    }
    public static int find(int v) {
        int res = 0;
        while ((v & 1) == 0) {
            res++;
            v >>= 1;
        }
        return res;
    }
    public static void main(String[] args) {
        int[] arr = {3,5,4,3,4,8};
        int n = 6;
        int[] res = findOdds(arr, n);
        for (int r : res)
            System.out.println(r);
        System.out.println(Math.round(Math.random() * 10));
    }
}
