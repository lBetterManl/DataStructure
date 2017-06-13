import com.tree.demo.Tree;
import com.tree.demo.Visit;

/**
 * Created by Hanson on 2017/6/13.
 */
public class TreeTest {

    /**
     *            A
     *     B      C      D
     *   L  E    F     I  H
     *                L
     * @param args
     */

    public static void main(String[] args) {
        Tree root = new Tree("A");
        root.addNode(new Tree("B"));
        root.addNode(new Tree("C"));
        root.addNode(new Tree("D"));
        Tree t = null;
        t = root.getChild(0);
        t.addNode(new Tree("L"));
        t.addNode(new Tree("E"));
        t = root.getChild(1);
        t.addNode(new Tree("F"));
        t = root.getChild(2);
        t.addNode(new Tree("I"));
        t.addNode(new Tree("H"));
        t = t.getFirstChild();
        t.addNode(new Tree("L"));

        System.out.println("first node:" + root.getRootData());
        //System.out.println("size:" + root.size());
        //System.out.println("dept:" + root.dept());
        System.out.println("is left:" + root.isLeaf());
        System.out.println("data:" + root.getRootData());

        Visit visit = new Visit();
        System.out.println("前根遍历：");
        visit.preOrder(root);
        System.out.println("\n后根遍历：");
        visit.postOrder(root);

        System.out.println("树的结点个数：" + root.size());
        System.out.println("树的深度：" + root.dept());
    }
}
