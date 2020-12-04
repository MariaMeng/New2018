package Date.Mar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author mengxiang
 * @date 20/4/1
 */
class Point{
    private double[] coords;
    public Point(double[] coords) {
        this.coords = coords;
    }
    public Point extend(double newCoord) {
        double[] newCoords = Arrays.copyOf(this.coords, coords.length + 1);
        newCoords[newCoords.length - 1] = newCoord;
        return new Point(newCoords);
    }
    @Override
    public String toString() {
        int size = coords.length;
        StringBuilder sb = new StringBuilder();
        sb.append("Point(");
        for (int i = 0; i < size; i++) {
            sb.append(coords[i] + ",");
        }
        sb.deleteCharAt(sb.length() - 1);
        sb.append(")");
        return sb.toString();
    }
}
public class MyIterator implements Iterator<Point> {

    double kernal;
    private double r;
    int n;
    MyIterator myIterator;
    MyIterator(double r, int n) {

        kernal = -Math.floor(r);
        this.r = r;
        this.n = n;
        if (n == 1) {

        } else {
            myIterator = new MyIterator(Math.sqrt(r * r - kernal * kernal), n - 1);
        }
    }


    @Override
    public boolean hasNext() {
        if (myIterator == null) {
            return kernal <= r;
        }
        if (kernal > r) {
            return false;
        }

        while (!myIterator.hasNext()) {
            kernal++;
            if (kernal > r) return false;
            myIterator = new MyIterator(Math.sqrt(r * r - kernal * kernal), n - 1);
        }
        return true;
    }


    @Override
    public Point next() {
        if (!hasNext()) {
            return null;
        }
        if (myIterator == null) {

            Point pt = new Point(new double[]{kernal++});
            return pt;
        } else {
            Point point = myIterator.next();
            return point.extend(kernal);
        }
    }


    public static void main(String[] args) {
        double d = 2.5;
        int n = 2;
        MyIterator myIterator = new MyIterator(d, n);
        while (myIterator.hasNext()) {
            System.out.println(myIterator.next().toString());
        }

        List<String> list = new ArrayList<>();
        list.remove(0);
    }
}
