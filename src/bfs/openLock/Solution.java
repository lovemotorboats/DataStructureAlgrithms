package bfs.openLock;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;


// 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6',
// '7', '8', '9' 。每个拨轮可以自由旋转：例如把 '9' 变为  '0'，'0' 变为 '9' 。
// 每次旋转都只能旋转一个拨轮的一位数字。锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
// 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，
// 无法再被旋转。字符串 target 代表可以解锁的数字，你需要给出最小的旋转次数，如果无论如何不能解锁，
// 返回 -1。
public class Solution {

    public int openLock(String[] deadends, String target) {
        Set<String> visited = new HashSet<>();
        Set<String> dead = new HashSet<>();
        for (String deadend : deadends) {
            dead.add(deadend);
        }
        LinkedList<String> queue = new LinkedList<>();
        queue.offer("0000");
        int step = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String poll = queue.poll();
                if (target.equals(poll)) {
                    return step;
                }
                if (dead.contains(poll)) {
                    continue;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(poll, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(poll, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
                visited.add(poll);
            }
            step++;
        }
        return -1;

    }

    //将s[i]向上拨动一位
    public String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        } else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    //将s[i]向下拨动一位
    public String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        } else {
            chars[i] -= 1;
        }
        return new String(chars);
    }
}
