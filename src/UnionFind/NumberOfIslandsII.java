package UnionFind;
import java.util.*;

/**
 * Created by apple on 10/18/18.
 */
class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}
public class NumberOfIslandsII {

    //--------------------------自己的做法--------------------------------//
    class Node {
        int[] neib = new int[4]; // store the index of point array
        int color;
        public Node(int color) {
            this.color = color;
            for (int i = 0; i < 4; i++)
                neib[i] = Integer.MAX_VALUE;
        }
    }


    /**
     * @param n: An integer
     * @param m: An integer
     * @param operators: an array of point
     * @return: an integer array
     */
    int n, m;
    int max = Integer.MAX_VALUE;
    Map<Integer, Node> map = new HashMap<>();
    public List<Integer> numIslands2_MX(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> list = new ArrayList<>();
        if (operators == null || operators.length == 0) return list;
        this.n = n;
        this.m = m;
        int N = operators.length;
        int[] dp = new int[N];
        Set<Integer> setx = new HashSet<>();
        Set<Integer> sety = new HashSet<>();

        dp[0] = 1;
        Node node = new Node(0);
        map.put(0, node);
        setx.add(operators[0].x);
        sety.add(operators[0].y);

        for (int i = 1; i < N; i++) {
            if(setx.contains(operators[i].x) && sety.contains(operators[i].y)) {
                dp[i] = dp[i- 1];
                continue;
            }

            setx.add(operators[i].x);
            sety.add(operators[i].y);

            Node nn = new Node(i);
            Set<Integer> tmp = new HashSet<>(4);
            int idx = 0;


            for (int j = 0; j < i; j++) {
                if (isNeighbor(operators[j], operators[i])) {
                    nn.neib[idx++] = j;
                    tmp.add(map.get(j).color);
                }
            }
            map.put(i, nn);

            dp[i] = dp[i - 1] - tmp.size() + 1;
            setColor(nn.neib, nn.color);
        }
        for (int d : dp) {
            list.add(d);
        }
        return list;
    }
    public void setColor(int[]neib, int color) {
        for (int idx : neib) {
            if (idx != max)
                map.get(idx).color = color;
        }
    }

    public boolean isNeighbor(Point dst, Point src) {
        if (dst.x == src.x && Math.abs(dst.y - src.y) == 1)
            return true;
        if (dst.y == src.y && Math.abs(dst.x - src.x) == 1)
            return true;
        else
            return false;
    }

    //-------------------Union Found 算法------------------------//
    public List<Integer> numIslands2(int n, int m, Point[] operators) {
        // write your code here
        List<Integer> res = new ArrayList<>();
        if (operators == null || operators.length == 0) return res;
        int[] root = new int[n * m];
        Arrays.fill(root, -1);
        int[][] neib = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        int cnt = 0;

        for (Point p : operators) {
            int id = p.x * n + p.y;
            if (root[id] == -1) {
                root[id] = id;
                cnt++;
            }

            for (int[] nb : neib) {
                int x = p.x + nb[0];
                int y = p.y + nb[1];
                int nId = x * n + y;
                if (x < 0 || x >= n || y < 0 || y >= m || root[nId] == -1) continue;
                int pn = findRoot(root, nId), pc = findRoot(root, id);

                if (pn != pc) {
                    cnt--;
                    root[pn] = pc;
                }
            }
            res.add(cnt);
        }
        return res;
    }

    public int findRoot(int[] root, int id) {
        return id == root[id] ? id : findRoot(root, root[id]);
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        Point[] operators = new Point[k];
        for (int i = 0; i < k; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            operators[i] = new Point(a, b);
        }
        NumberOfIslandsII test = new NumberOfIslandsII();
        List<Integer> res = test.numIslands2(n, m, operators);
        System.out.println(res);
    }

}
