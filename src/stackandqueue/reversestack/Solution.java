package stackandqueue.reversestack;

import java.util.Stack;

//仅用递归函数来逆序一个栈，不用其它数据结构
public class Solution {
    //1、设计一个方法，可以返回栈底元素并删除栈底元素
    //2、利用递归方法先取出栈底元素，并且逆序剩下的栈，再将之前取出的
    //栈底元素压入到栈顶
    public static int getAndRemoveLastElement(Stack<Integer> stack){
        int result = stack.pop();
        if (stack.isEmpty())
            return result;
        else {
            int last = getAndRemoveLastElement(stack);
            stack.push(result);
            return last;
        }
    }

    public static void reverse(Stack<Integer> stack) {
        if (stack.isEmpty())
            return;
        int i = getAndRemoveLastElement(stack);
        reverse(stack);
        stack.push(i);
    }
}
