package binarytree.travelbymorris;

import binarytree.travel.Node;

//这是遍历二叉树的一个神仙级别的方法，根据morris序分别改造出二叉树的先中后序遍历
//其时间复杂度可以打到线性，空间复杂度为O(1)
public class Solution {
    //先介绍morris序生成规则
    //1、初始化cur=head
    //2、如果cur==null，则过程停止；否则进入步骤3
    //3、如果cur没有左子树，令cur=cur.right，进入步骤2；否则进入步骤4
    //4、如果cur有左子树，则找到cur左子树上右边界结点，记为mostRight，如果
    //mostRight.right==null，令mostRight.right=cur，然后令cur=cur.left，转到
    //步骤2；如果mostRight.right==cur，令mostRight.right=null，然后令cur=cur.right，
    //转到步骤2。

    //morris序具体实现如下
    public void morris(Node head){
        if (head == null)
            return;
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            System.out.print(cur.value + " ");
            mostRight = cur.left;
            if (mostRight != null){
                //cur有左子树
                while (mostRight.right != null && mostRight.right != cur){
                    //找到cur左子树的右边界结点
                    mostRight = mostRight.right;
                }
                if (mostRight.right == null){
                    mostRight.right = cur;  //让其指向cur
                    cur = cur.left;  //向左移动
                }else {
                    mostRight.right = null;
                    cur = cur.right;
                }
            }else cur = cur.right;
        }
    }

    //根据morris序进行更改，变成先序遍历
    //1、对于cur只到达依次的结点直接打印
    //2、对于cur可以到达两次的结点，在cur第一次到达时打印，第二次不打印
    public static void morrisPre(Node head){
        if (head == null)
            return;
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == null){
                    mostRight.right = cur;
                    System.out.print(cur.value + " ");
                    cur = cur.left;
                    continue;
                }else mostRight.right = null;
            }else System.out.print(cur.value + " ");
            cur = cur.right;
        }
    }

    //根据morris序进行更改，变成中序遍历
    //1、对于cur只到达依次的结点直接打印
    //2、对于cur可以到达两次的结点，在cur第一次到达时不打印，第二次打印
    public static void morrisIn(Node head){
        if (head == null)
            return;
        Node cur = head;
        Node mostRight = null;
        while (cur != null){
            mostRight = cur.left;
            if (mostRight != null){
                while (mostRight.right != null && mostRight.right != cur)
                    mostRight = mostRight.right;
                if (mostRight.right == null){
                    mostRight.right = cur;
                    cur = cur.left;
                    continue;
                }else {
                    mostRight.right = null;
                    System.out.print(cur.value + " ");
                }
            }else cur = cur.right;
        }
    }
}
