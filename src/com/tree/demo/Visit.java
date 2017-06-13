package com.tree.demo;

/**
 * Created by Hanson on 2017/6/13.
 * <p>
 * 树的遍历
 */
public class Visit {

    private void visit(Tree tree) {
        System.out.println("\t" + tree.getRootData());
    }

    /**
     * 先根遍历
     *
     * @param root 要的根结点
     */
    public void preOrder(Tree root) {
        if (!root.isEmpty()) {
            visit(root);
            for (Tree child : root.getChilds()) {
                if (child != null) {
                    preOrder(child);
                }
            }
        }
    }

    /**
     * 后根遍历
     *
     * @param root
     */
    public void postOrder(Tree root) {
        if (!root.isEmpty()) {
            for (Tree child : root.getChilds()) {
                if (child != null) {
                    preOrder(child);
                }
            }
            visit(root);
        }
    }
}
