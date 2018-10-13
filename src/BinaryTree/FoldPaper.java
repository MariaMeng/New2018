package BinaryTree;

/**
 * Created by apple on 10/7/18.
 */
public class FoldPaper {
    public static String[] foldPaper(int n) {
        // write code here
        if (n == 0) return null;
        if (n == 1) return new String[]{"down"};
        int len = (int)Math.pow(2, n) + 1;

        String[] list = new String[len];
        fill(list, 0, len - 1, 0);
        String[] res = new String[len - 2];

        for (int i = 0; i < res.length; i++) {
            res[i] = list[i + 1];
        }
        return res;
    }
    public static void fill(String[] res, int start, int end, int flag) {
        if (end - start  == 1) return ;
        int mid = start + (end - start) / 2;
        res[mid] = flag == 0 ? "down" : "up";
        fill(res, start, mid, 1);
        fill(res, mid, end, 0);
    }
    public static void main(String[] args) {
        int n = 1;
        String[] res = foldPaper(n);
        for (String r : res)
            System.out.println(r);
    }

}
