import com.set.demo.ArraySet;
import com.set.demo.Set;

/**
 * Created by Hanson on 2017/6/7.
 */
public class ArraySetTest {
    public static void main(String[] args) {
        Set a = new ArraySet();
        Set b = new ArraySet();
        Set c = new ArraySet();
        Set d = new ArraySet();
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(8);
        b.add(3);
        b.add(4);
        b.add(5);
        c.add(3);
        c.add(4);
        System.out.println(a.size());
        System.out.println(b.size());
        System.out.println(a);
        System.out.println(a.isEmpty());
        System.out.println(a.get(1));
        System.out.println(a.unionSet(b));
        System.out.println(a.intersectionSet(b));
        System.out.println(a.differenceSet(b));
        System.out.println(a.include(b));
        System.out.println(a.include(c));
        a.remove(8);
        System.out.println(a);
    }
}
