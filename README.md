# 数据结构(Java)笔记 
 
> 参考资料[CSDN](http://blog.csdn.net/luoweifu/article/details/8502753)  

学习环境：  
* Jdk1.7
* Intellij IDEA 2017.1.4  

## 线性表(`com.list.demo`)

[线性表](http://blog.csdn.net/luoweifu/article/details/8505178)

> 1.有序表(静态)  
2.单向链表(动态)  
3.双向链表(动态)  

`List`链表的接口定义  
`ArrayList`有序表  
`LinkList`单向链表  
`DoubleLinkList`双向循环链表  

## 队列-特殊的线性表(`com.queue.demo`)  

[队列](http://blog.csdn.net/luoweifu/article/details/8507835)

 > 先进先出(队尾插入，队头删除)  
 1.顺序循环队列  
 2.链式队列  

`Queue`队列的接口定义  
`ArrayQueue`顺序循环队列  
`LinkQueue`链式队列  

## (堆)栈(`com.stack.demo`)  

[堆栈](http://blog.csdn.net/luoweifu/article/details/8507836)

> 栈是一种特殊的线性表，是操作受限的线性表  
1.顺序(堆)栈  
2.链式栈  

* 定义：限定仅在表尾进行插入或删除操作的线性表，表尾—栈顶，表头—栈底，不含元素的空表称空栈  
* 特点：先进后出（FILO）或后进先出（LIFO）  

`Stack` 栈的接口定义  
 `ArrayStack`顺序(堆)栈  
 `LinkStack`链式栈  
 
 ## 递归(`com.recursion.demo`)  
 
 [递归](http://blog.csdn.net/luoweifu/article/details/8509688)
 
 1.`HanioDemo`汉诺塔问题  
 2.`FibonacciDemo`斐波纳契数列  
 3.`MaxDemo`求数组中的最大值  
 
 ## 串操作(`com.string.demo`)  
  
  [串](http://blog.csdn.net/luoweifu/article/details/8644362)
  
 > 字符串的应用已经非常广泛，如信息检索、文字编辑、自然语言的翻译等都离不开字符串。  
 从逻辑关系上来看，串是一各特殊的线性表。它与一般线性表的区别是：一般线性表的操作通常以表内的数据元素为操作对象，而串的操作则主要将串作为一个整体加以操作。  
 
 * 对于串操作而言有两种方式：一种是操作后当前串的值不变，操作的结果是产生一个新的串对象；另一种操作结果体现在当前串上，同时也返加该当前串本身。  
 * 串值不变的顺序串主要是连接、插入、删除、替换操作有所不同，其它操作与串值可变的顺序串类一样。  
 
 `Str`串的接口定义  
 `ArrayEnStr`串值可变的顺序串(本身改变)  
 `ArrayDisStr`串值不可变的顺序串(本身不变)
 
 ## 集合(`com.set.demo`)  
 
 [集合](http://blog.csdn.net/luoweifu/article/details/8655874)
 
 > 集合是具有某种相同数据类型的数据元素，或是一些确认对象的汇集。
 
 `Set`集合接口的定义  
 `ArraySet`顺序集合  
 `LinkSet`链式集合  
 
 ## 树(`com.tree.demo`)  
 
 [树](http://blog.csdn.net/luoweifu/article/details/9071849)
 
 > 树(Tree)是n(n≥0)个结点的有限集T，并且当n＞0时满足下列条件：  
     （1）有且仅有一个特定的称为根(Root)的结点；  
     （2）当n＞1时，其余结点可以划分为m(m＞0)个互不相交的有限集T1、T2 、…、Tm，每个集Ti(1≤i≤m)均为树，且称为树T的子树(SubTree)。
   特别地，不含任何结点(即n＝0)的树，称为空树。  
   
**基本术语：**  
1.结点  
存储数据元素和指向子树的链接，由数据元素和构造数据元素之间关系的引用组成。  
2.孩子结点  
树中一个结点的子树的根结点称为这个结点的孩子结点，如图1中的A的孩子结点有B、C、D  
3.双亲结点  
树中某个结点有孩子结点(即该结点的度不为0)，该结点称为它孩子结点的双亲结点，也叫前驱结点。双亲结点和孩子结点是相互的，如图1中，A的孩子结点是B、C、D，B、C、D的双亲结点是A。  
4.兄弟结点  
具有相同双亲结点(即同一个前驱)的结点称为兄弟结点，如图1中B、B、D为兄弟结点。  
5.结点的度  
结点所有子树的个数称为该结点的度，如图1，A的度为3，B的度为2.  
6.树的度  
树中所有结点的度的最大值称为树的度，如图1的度为3.  
7.叶子结点  
度为0的结点称为叶子结点，也叫终端结点。如图1的K、L、F、G、M、I、J  
8.分支结点  
度不为0的结点称为分支结点，也叫非终端结点。如图1的A、B、C、D、E、H  
9.结点的层次  
从根结点到树中某结点所经路径的分支数称为该结点的层次。根结点的层次一般为1(也可以自己定义为0)，这样，其它结点的层次是其双亲结点的层次加1.  
10.树的深度  
树中所有结点的层次的最大值称为该树的深度(也就是最下面那个结点的层次)。  
11.有序树和无序树  
树中任意一个结点的各子树按从左到右是有序的，称为有序树，否则称为无序树。  

`Tree`树的定义和实现  
`Visit`树的遍历  
1)先根遍历：①访问根结点；②按照从左到右的次序行根遍历根结点的第一棵子树；  
2)后根遍历：①按照从左到右的次序行根遍历根结点的第一棵子树；②访问根结点；  

## 二叉树(`com.binarytree.demo`)

[1.二叉树的定义和递归实现](http://blog.csdn.net/luoweifu/article/details/9077521)  
[2.二叉树遍历的非递归实现](http://blog.csdn.net/luoweifu/article/details/9079799)  
[3.三叉链表示的二叉树](http://blog.csdn.net/luoweifu/article/details/9089551)

### 基本性质
这里规定二叉树的根结点的层次为1。  
* 性质1：则二叉树的第i 层最多有2i-1个结点（在此二叉树的层次从1开始，i≥1）  
* 性质2：深度为k的二叉树最多有2k-1个结点。(k≥1)  
* 性质3：对任何一棵二叉树T, 如果其叶结点个数为n0, 度为2的非叶结点个数为n2, 则有  
> n0 = n2 + 1  
  
* 性质4：具有 n(n>0)个结点的完全二叉树的深度为⎣log2n⎦+1；⎦x⎦表示不超过x的最大整数。  
* 性质5：如果对一棵有n个结点的完全二叉树的结点按层序编号（从第1层到第⎣l og2n⎦ +1层，每层从左到右）,则对任一结点i（1≤i≤n),有：  
> (1)如果i=1，则结点i无双亲，是二叉树的根；如果i>1，则其双亲是结点⎣i/2⎦。  
(2) 如果2i<=n, 则结点i的左孩子结点是2i；否则，结点i为叶子结点，无左孩子结点。  
(3)如果2i＋1<=n，则结点i的右孩子是结点2i＋1; 否则，结点i为叶子结点，无右孩子结点。  
  
`BTree`二叉树接口定义