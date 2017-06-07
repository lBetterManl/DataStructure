import com.list.demo.LinkList;
import org.junit.Test;

/**
 * Created by Hanson on 2017/6/6.
 */
public class LinkListTest {

    String[] datas = new String[]{"男神", "二狗", "女神"};
    private LinkList link = new LinkList(datas);

    @Test
    public void testAdd() {
        System.out.println(link.get(0));
        link.remove(0);
        System.out.println(link.get(0));
    }
}
