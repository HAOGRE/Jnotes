package com.haogre.leetcode;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/short-encoding-of-words/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-26 16:22
 * @Version : V1.0
 * 给定一个单词列表，我们将这个列表编码成一个索引字符串 S 与一个索引列表 A。
 * <p>
 * 例如，如果这个列表是 ["time", "me", "bell"]，我们就可以将其表示为 S = "time#bell#" 和 indexes = [0, 2, 5]。
 * <p>
 * 对于每一个索引，我们可以通过从字符串 S 中索引的位置开始读取字符串，直到 "#" 结束，来恢复我们之前的单词列表。
 * <p>
 * 那么成功对给定单词列表进行编码的最小字符串长度是多少呢？
 * <p>
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 7
 * 每个单词都是小写字母 。
 */
public class Ag820 {
    public int minimumLengthEncoding(String[] words) {
        return 1;
    }
}
