import com.binarytree.demo.BTree;
import com.binarytree.demo.LinkBTree;
import com.binarytree.demo.UnrecursionVisit;

/**
 * Created by hp on 2017/6/14.
 *
 *    A
 * B     C
 * D    E F
 */
public class UnrecursionVisitTest {
    public static void main(String[] args) {
        BTree btree = new LinkBTree('A');
        BTree bt1, bt2, bt3, bt4;
        bt1 = new LinkBTree('B');
        btree.addLeftTree(bt1);
        bt2 = new LinkBTree('D');
        bt1.addLeftTree(bt2);

        bt3 =  new LinkBTree('C');
        btree.addRightTree(bt3);
        bt4 =  new LinkBTree('E');
        bt3.addLeftTree(bt4);
        bt4 =  new LinkBTree('F');
        bt3.addRightTree(bt4);

        UnrecursionVisit order = new UnrecursionVisit();
        System.out.println("\n中序遍历：");
        order.inOrder(btree);
    }
}
