package bfs.findLadders;

//给定两个单词（beginWord 和 endWord）和一个字典 wordList，返回从beginWord到endWord的最少操作次数。
//转换需遵循如下规则：
//      每次转换只能改变一个字母。
//      转换后得到的单词必须是字典中的单词。

import java.util.*;

//说明:
//      如果不存在这样的转换序列，返回一个空列表。
//      所有单词具有相同的长度。
//      所有单词只由小写字母组成。
//      字典中不存在重复的单词。
//      你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
public class Solution {
    public static int findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(beginWord);
        int step = 0;
        while (!queue.isEmpty()) {
            int qSize = queue.size();
            for (int i = 0; i < qSize; i++) {
                String poll = queue.poll();
                if (endWord.equals(poll)) {
                    return step;
                }

                List<String> list = canTransSet(poll, wordList);
                for (String str : list) {
                    if (!visited.contains(str)) {
                        queue.offer(str);
                        visited.add(str);
                    }
                }
                visited.add(poll);
            }
            step++;
        }

        return -1;
    }

    public static List<String> canTransSet(String s, List<String> wordList) {
        //s通过一步可以转换成字典wordList中的结果
        //s和wordList的当前字符有且仅有一个字符不同就将wordList的该字符串放到结果集
        List<String> res = new ArrayList<>();
        for (String str : wordList) {
            int notEqual = 0, len = str.length();
            for (int i = 0; i < len; i++) {
                if (str.charAt(i) != s.charAt(i)) {
                    notEqual++;
                }
            }
            if (notEqual == 1) {
                res.add(str);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String beginWord = "hit";
        String endWord = "cog";
        List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
        System.out.println(findLadders(beginWord, endWord, wordList));

    }
}
