package com.binarytree.demo;

import com.stack.demo.ArrayStack;
import com.stack.demo.Stack;

/**
 * Created by hp on 2017/6/14.
 *
 * 二叉树非递归遍历
 */
public class UnrecursionVisit {

    private Stack stack = new ArrayStack();
    private BTree bt;

    private void visit(BTree btree){
        System.out.println("\t" + btree.getRootData());
    }

    /**
     * 中序遍历
     *
     * (1).初始化栈，根结点进栈；
     * (2).若栈非空，则栈顶结点的左孩子结点相继进栈，直到null(到叶子结点时)退栈；访问栈顶结点(执行visit操作)并使栈顶结点的右孩子结点进栈成为栈顶结点。
     * (3).重复执行(2)，直至栈为空。
     * @param root
     */
    public void inOrder(BTree root){
        stack.clear();
        stack.push(root);
        while (!stack.isEmpty()){
            //左孩子结点进栈
            while ((bt = ((BTree)stack.peek()).getLeftChild())!=null){
                stack.push(bt);
            }
            //如果该结点没有右孩子，则逐级往上出栈
            while(!stack.isEmpty() &&!( (BTree)stack.peek() ).hasRightTree()) {
                bt = (BTree)stack.pop();
                visit(bt);
            }
            //如果该结点有右孩子，则右孩子进栈
            if(!stack.isEmpty() && ( (BTree)stack.peek() ).hasRightTree()){
                bt = (BTree)stack.pop();
                visit(bt);
                stack.push(bt.getRightChild());
            }
        }
    }
}
