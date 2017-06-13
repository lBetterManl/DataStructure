
import com.list.demo.ArrayList;
import com.list.demo.List;

/**
 * Created by Hanson on 2017/6/6.
 */
public class ArrayListTest {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Integer(0));
        list.add(new Integer(1));
        list.add(new Integer(2));
        list.add(new Integer(3));
        list.add(new Integer(4));
        list.add(new Integer(5));
        list.add(new Integer(6));
        list.add(new Integer(6));

        list.clear();
        list.add(88);
        System.out.println(list.get(0));

    }
}
