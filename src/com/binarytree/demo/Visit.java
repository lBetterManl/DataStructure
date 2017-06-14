package com.binarytree.demo;

/**
 * Created by hp on 2017/6/14.
 * <p>
 * 遍历二叉树
 */
public class Visit {

    private void visit(BTree btree) {
        System.out.println(btree.getRootData() + "\t");
    }

    /**
     * 先序遍历
     *
     * @param root 根结点
     */
    public void preOrder(BTree root) {
        visit(root);
        if (root.getLeftChild() != null) {
            preOrder(root.getLeftChild());
        }
        if (root.getRightChild() != null) {
            preOrder(root.getRightChild());
        }
    }

    /**
     * 中序遍历
     *
     * @param root 根结点
     */
    public void inOrder(BTree root) {
        if (root.getLeftChild() != null)
            inOrder(root.getLeftChild());
        visit(root);
        if (root.getRightChild() != null)
            inOrder(root.getRightChild());
    }

    /**
     * 后序遍历
     *
     * @param root 根结点
     */
    public void postOrder(BTree root) {
        if (root.getLeftChild() != null)
            postOrder(root.getLeftChild());
        if (root.getRightChild() != null)
            postOrder(root.getRightChild());
        visit(root);
    }
}
