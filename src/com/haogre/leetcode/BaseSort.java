package com.haogre.leetcode;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: 基本排序
 * @Author : haogre@gmail.com
 * @Date : 2020/5/23 23:11
 * @Version : V1.0
 **/
public class BaseSort {

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        int tmp;
        // 外层循环 len - 1
        // 内层循环 len - 1 - i
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
        return array;
    }


    /**
     * 选择排序
     *
     * @param array
     * @return
     */
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                // 数据交换
                int tmp = array[minIndex];
                array[minIndex] = array[i];
                array[i] = tmp;
            }
        }
        return array;
    }

    /**
     * 插入排序
     *
     * @param array
     * @return
     */
    public static int[] insertionSort(int[] array) {
        int current;
        for (int i = 0; i < array.length; i++) {
            int preIndex = i;
            current = array[i + 1];

            while (preIndex >= 0 && current < array[preIndex]) {

                array[]
                // TODO 睡觉
            }


        }

    }
}
