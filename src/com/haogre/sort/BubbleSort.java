package com.haogre.sort;

/**
 * Created with IntelliJ IDEA
 *
 * @Project : Jnotes
 * @Description: 冒泡排序
 * @Author : haogre@gmail.com
 * @Date : 2019-09-09 14:38
 * @Version : V1.0
 **/
public class BubbleSort {
    public static void main(String[] args) {

        int[] arr = new int[4];

        arr[0] = 5;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;

        bubbleSort(arr);
        System.out.println(arr);

    }

    /**
     * 冒泡排序
     *
     * @param array
     * @return
     */
    public static int[] bubbleSort(int[] array) {
        if (array == null && array.length == 0) {
            return array;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j + 1] < array[j]) {
                    int temp = array[j + 1];
                    array[j + 1] = array[j];
                    array[j] = temp;
                }
            }
        }
        return array;
    }

    public static int[] selectionSort(int[] array) {

        return array;
    }
}
