package com.mao.util;

/**
 * 非工具类，作测试使用，记录一下排序方法
 * @author mao by 11:40 2019/8/30
 */
public class SortUtil {

    //冒泡
    public static int[] bubbleSort(int array[]) {
        int t = 0;
        for (int i = 0; i < array.length - 1; i++)
            for (int j = 0; j < array.length - 1 - i; j++)
                if (array[j] > array[j + 1]) {
                    t = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = t;
                }
        return array;
    }

    //选择
    public static int[] selectSort(int array[]) {
        int t = 0;
        for (int i = 0; i < array.length - 1; i++){
            int index=i;
            for (int j = i + 1; j < array.length; j++){
                if (array[index] > array[j]){
                    index=j;
                }
            }
            if(index!=i){ //找到了比array[i]小的则与array[i]交换位置
                t = array[i];
                array[i] = array[index];
                array[index] = t;
            }
        }
        return array;
    }

    //插入
    public static int[] insertionSort(int array[]) {
        int i, j, t = 0;
        for (i = 1; i < array.length; i++) {
            if(array[i]<array[i-1]){
                t = array[i];
                for (j = i - 1; j >= 0 && t < array[j]; j--)
                    array[j + 1] = array[j];
                //插入array[i]
                array[j + 1] = t;
            }
        }
        return array;
    }

    //快速
    public static int[] quickSort(int array[], int low, int high) {// 传入low=0，high=array.length-1;
        int pivot, p_pos, i, t;// pivot->位索引;p_pos->轴值。
        if (low < high) {
            p_pos = low;
            pivot = array[p_pos];
            for (i = low + 1; i <= high; i++)
                if (array[i] < pivot) {
                    p_pos++;
                    t = array[p_pos];
                    array[p_pos] = array[i];
                    array[i] = t;
                }
            t = array[low];
            array[low] = array[p_pos];
            array[p_pos] = t;
            // 分而治之
            quickSort(array, low, p_pos - 1);// 排序左半部分
            quickSort(array, p_pos + 1, high);// 排序右半部分
        }
        return array;
    }

}