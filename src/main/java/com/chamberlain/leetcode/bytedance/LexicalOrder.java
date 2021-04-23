package com.chamberlain.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by chamberlain on 2021/4/23.
 * 给定一个整数 n, 返回从 1 到 n 的字典顺序。
 * 例如，给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * 请尽可能的优化算法的时间复杂度和空间复杂度。 输入的数据 n 小于等于 5,000,000。
 * 链接：https://leetcode-cn.com/problems/lexicographical-numbers
 */
public class LexicalOrder {

    public List<Integer> lexicalOrder(int n) {
        String[] array = new String[n];
        for (int i = 1; i <= n; i++) {
            array[i-1] = String.valueOf(i);
        }
        quicksort(array, 0, array.length -1);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            result.add(Integer.parseInt(array[i]));
        }
        return result;
    }

    void quicksort(String array[],int start,int end){
        int q=-1;
        if(start<end){
            q=partition(array,start,end);
            quicksort(array,start,q-1);
            quicksort(array,q+1,end);
        }
    }

    int partition(String array[],int start,int end){
        int i=start;
        int j=end;
        String temp=array[start];
        while(i!=j){
            while(array[j].compareTo(temp)>=0&&i<j){
                j--;
            }
            while(array[i].compareTo(temp) <= 0&&i<j){
                i++;
            }
            if(i<j)
            {
                String t=array[i];
                array[i]=array[j];
                array[j]=t;
            }
        }
        array[start]=array[i];
        array[i]=temp;
        return i;
    }

    public static void main(String[] args) {
        LexicalOrder lexicalOrder = new LexicalOrder();
        for (Integer integer : lexicalOrder.lexicalOrder(13)) {
            System.out.println(integer + " " );
        }
    }


}
