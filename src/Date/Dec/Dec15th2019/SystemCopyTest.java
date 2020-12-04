package Date.Dec.Dec15th2019;

/**
 * Created by apple on 12/15/19.
 */
class Color {
    String s;

    Color(String s) {
        this. s = s;
    }

}
public class SystemCopyTest {




    public static void main(String[] args) {
        Color[] colors = new Color[5];
        for (int i = 0; i < 5; i++) {
            colors[i] = new Color("Red");
            System.out.println(colors[i].hashCode());
        }

        System.out.println("-------------------------------");

        Color[] copy = new Color[5];
        System.arraycopy(colors, 0, copy, 0, 5);

        for (Color color: copy) {
            System.out.println(color.hashCode());
        }

        System.out.println("----------------modify copy[0] = yellow");

//        copy[0] = new Color("yellow");
        copy[0].s = "pink";
        System.out.println("----------print out first array s ");
        for (Color c: colors) {
            System.out.println(c.s);
        }

        System.out.println("----------print out second array s ");
        for (Color c: copy) {
            System.out.println(c.s);
        }


        System.out.println("-------print hashcode --------");

        for (Color c: colors) {
            System.out.println(c.hashCode());
        }

        System.out.println("-------------------");
        for (Color c: copy) {
            System.out.println(c.hashCode());
        }
    }
}
