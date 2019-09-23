package linklist.removenodewithunknowhead;

import linklist.printcommonpart.Node;

//在不知道头节点的情况下删除一个结点(结点只有整数属性)
public class Solution {
    public static void removeNode(Node node){
        if (node == null)
            return;
        Node next = node.next;
        if (next == null)
            throw new RuntimeException("cannot remove the last node.");
        node.value = next.value;
        node.next = next.next;
    }
}
