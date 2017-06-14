import com.binarytree.demo.BTree;
import com.binarytree.demo.LinkBTree;
import com.binarytree.demo.Visit;

/**
 * Created by hp on 2017/6/14.
 * <p>
 *    A
 * B     C
 * D    E F
 */
public class BTreeTest {

    public static void main(String[] args) {
        BTree root = new LinkBTree('A');
        BTree bt1, bt2, bt3, bt4;
        bt1 = new LinkBTree('B');
        root.addLeftTree(bt1);
        bt2 = new LinkBTree('D');
        bt1.addLeftTree(bt2);
        bt3 = new LinkBTree('C');
        root.addRightTree(bt3);
        bt4 = new LinkBTree('E');
        bt3.addLeftTree(bt4);
        bt4 = new LinkBTree('F');
        bt3.addRightTree(bt4);

        System.out.println("树的深度：" + root.dept());
        System.out.println("树的结点数：" + root.size());
        System.out.println("是否为空树：" + root.isEmpty());
        System.out.println("是否为叶子结点：" + root.isLeaf());
        System.out.println("最左下边结点是否为叶子结点：" + root.getRightChild().getRightChild().isLeaf());
        System.out.println("root结点：" + root.root());

        Visit visit = new Visit();
        System.out.println("\n先序遍历：");
        visit.preOrder(root);
        System.out.println("\n中序遍历：");
        visit.inOrder(root);
        System.out.println("\n后序遍历：");
        visit.postOrder(root);
    }
}
