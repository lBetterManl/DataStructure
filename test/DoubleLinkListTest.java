import com.list.demo.DoubleLinkList;

/**
 * Created by Hanson on 2017/6/6.
 */
public class DoubleLinkListTest {
    public static void main(String[] args) {
        Integer[] datas = new Integer[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        DoubleLinkList dbList = new DoubleLinkList(datas);

        System.out.println(dbList.get(0));
        dbList.remove(0);
        System.out.println(dbList.get(0));
    }
}
