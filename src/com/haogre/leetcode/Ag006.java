package com.haogre.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Project : Jnotes
 * @Description: https://leetcode-cn.com/problems/zigzag-conversion/
 * @Author : haogre@gmail.com
 * @Date : 2020-05-20 17:06
 * @Version : V1.0
 */
public class Ag006 {

    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++)
            rows.add(new StringBuilder());

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) ret.append(row);
        return ret.toString();
    }
}
