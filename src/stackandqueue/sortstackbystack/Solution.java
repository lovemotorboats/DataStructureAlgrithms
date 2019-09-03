package stackandqueue.sortstackbystack;

import java.util.Stack;

//只能申请一个额外的栈，不能再有其它的数据结构，怎样将一个栈中的元素按从栈顶
//到栈底从大到小的顺序排序
public class Solution {
    public static void sortStackByStack(Stack<Integer> stack){
        //1、申请一个辅助栈help，弹出原栈的栈顶元素cur，如果cur小于等于help的栈顶元素直接就将cur压入help中
        //否则，先将help中的元素依次弹出压入到原栈中直到cur小于等于help栈顶，再将cur压入到help中，重复以上操作
        //直到原栈为空，最后再将help中的元素依次压入到原栈中即可
        Stack<Integer> help = new Stack<Integer>();
        while (!stack.isEmpty()){
            int cur = stack.pop();
            while (!help.isEmpty() && help.peek() < cur){
                stack.push(help.pop());  //将help中小于cur的元素依次压入到原栈中
            }
            help.push(cur);
        }
        while (!help.isEmpty())
            stack.push(help.pop());
    }
}
