package binarytree.travel;

import java.util.Stack;

//分别用递归和非递归的方法遍历二叉树结点
public class Solution {
    public static void preOrderRecur(Node head){
        //用递归的方法先序遍历二叉树
        if (head == null)
            return;
        System.out.print(head.value + " ");
        preOrderRecur(head.left);
        preOrderRecur(head.right);
    }

    public static void inOrderRecur(Node head){
        //递归中序遍历二叉树
        if (head == null)
            return;
        inOrderRecur(head.left);
        System.out.print(head.value + " ");
        inOrderRecur(head.right);
    }

     public static void postOrderRecur(Node head){
        //递归后序遍历二叉树
        if (head == null)
            return;
        postOrderRecur(head.left);
        postOrderRecur(head.right);
        System.out.print(head.value + " ");
     }

     public static void preOrderUnRecur(Node head){
        //非递归方式先序遍历二叉树
         if (head != null){
             Stack<Node> stack = new Stack<>();
             stack.add(head);  //先将head入栈
             while (!stack.isEmpty()){
                 head = stack.pop();
                 System.out.print(head.value + " ");
                 if (head.right != null)
                     stack.push(head.right);
                 if (head.left != null)
                     stack.push(head.left);
             }
         }
     }

     //非递归方式中序遍历二叉树
    public static void inOrderUnRecur(Node head){
        //1、申请一个栈stack，初始时变量cur=head
        //2、先把cur压入栈中，不停地把左边界压入栈中
        //3、重复步骤2直到cur为空，此时弹出一个结点记为node，打印node的值，并让cur=node.right
        //然后重复步骤2
        //4、直到stack为空并且cur为空时，结束
        if (head != null){
            Node cur = head;
            Stack<Node> stack = new Stack<>();
            Node node = null;
            while (!stack.isEmpty() || cur != null){
                if (cur != null){
                    stack.push(cur);
                    cur = cur.left;
                }else {
                    node = stack.pop();
                    System.out.print(node.value + " ");
                    cur = node.right;
                }
            }
        }
    }

    //非递归方式后序遍历二叉树
    public static void postOrderUnRecur1(Node head){
        //方法1：用两个栈s1和s2
        //1、将head放入s1中
        //2、从s1中弹出结点记为cur，依次将cur的left和right放入s1中
        //3、在整个过程中，每一个从s1中弹出的结点都放进s2中
        //4、不断重复步骤2和步骤3直到s1为空为止
        //5、从s2中依次弹出结点并打印即可
        if (head != null){
            Stack<Node> s1 = new Stack<>();
            Stack<Node> s2 = new Stack<>();
            Node cur = null;
            s1.push(head);
            while (!s1.isEmpty()){
                cur = s1.pop();
                s2.push(cur);
                if (cur.left != null)
                    s1.push(cur.left);
                if (cur.right != null)
                    s1.push(cur.right);
            }
            while (!s2.isEmpty())
                System.out.print(s2.pop().value + " ");
        }
    }

    //非递归方式后序遍历二叉树
    public static void postOrderUnRecur(Node head){
        //方法2：
    }
}
