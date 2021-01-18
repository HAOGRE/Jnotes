package com.haogre.leetcode2021;

import java.util.*;

/**
 * @Project : Jnotes
 * @Description: 账户合并 https://leetcode-cn.com/problems/accounts-merge/
 * @Author : haogre@gmail.com
 * @Date : 2021-01-18 09:41
 * @Version : V1.0
 */
public class Ag721 {
    /**
     * 给定一个列表 accounts，每个元素 accounts[i] 是一个字符串列表，其中第一个元素 accounts[i][0] 是 名称 (name)，其余元素是 emails 表示该账户的邮箱地址。
     * <p>
     * 现在，我们想合并这些账户。如果两个账户都有一些共同的邮箱地址，则两个账户必定属于同一个人。请注意，即使两个账户具有相同的名称，它们也可能属于不同的人，因为人们可能具有相同的名称。一个人最初可以拥有任意数量的账户，但其所有账户都具有相同的名称。
     * <p>
     * 合并账户后，按以下格式返回账户：每个账户的第一个元素是名称，其余元素是按顺序排列的邮箱地址。账户本身可以以任意顺序返回。
     */


    class Solution {
        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            Map<String, Integer> emailToIndex = new HashMap<String, Integer>();
            Map<String, String> emailToName = new HashMap<String, String>();
            int emailsCount = 0;
            for (List<String> account : accounts) {
                String name = account.get(0);
                int size = account.size();
                for (int i = 1; i < size; i++) {
                    String email = account.get(i);
                    if (!emailToIndex.containsKey(email)) {
                        emailToIndex.put(email, emailsCount++);
                        emailToName.put(email, name);
                    }
                }
            }
            UnionFind uf = new UnionFind(emailsCount);
            for (List<String> account : accounts) {
                String firstEmail = account.get(1);
                int firstIndex = emailToIndex.get(firstEmail);
                int size = account.size();
                for (int i = 2; i < size; i++) {
                    String nextEmail = account.get(i);
                    int nextIndex = emailToIndex.get(nextEmail);
                    uf.union(firstIndex, nextIndex);
                }
            }
            Map<Integer, List<String>> indexToEmails = new HashMap<Integer, List<String>>();
            for (String email : emailToIndex.keySet()) {
                int index = uf.find(emailToIndex.get(email));
                List<String> account = indexToEmails.getOrDefault(index, new ArrayList<String>());
                account.add(email);
                indexToEmails.put(index, account);
            }
            List<List<String>> merged = new ArrayList<List<String>>();
            for (List<String> emails : indexToEmails.values()) {
                Collections.sort(emails);
                String name = emailToName.get(emails.get(0));
                List<String> account = new ArrayList<String>();
                account.add(name);
                account.addAll(emails);
                merged.add(account);
            }
            return merged;
        }
    }

    class UnionFind {
        int[] parent;

        public UnionFind(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public void union(int index1, int index2) {
            parent[find(index2)] = find(index1);
        }

        public int find(int index) {
            if (parent[index] != index) {
                parent[index] = find(parent[index]);
            }
            return parent[index];
        }
    }

}
