package Algorithm;

/**
 * Created by apple on 10/31/18.
 */
public class Edge {
    class Piece {
        Edge left, right, top, bottom;

    }

    enum Type{ inner, outer, flat}
    Piece parent;
    Type type;

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
    }
}
