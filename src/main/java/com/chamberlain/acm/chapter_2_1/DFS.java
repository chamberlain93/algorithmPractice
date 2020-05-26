package com.chamberlain.acm.chapter_2_1;

/**
 * Created by chamberlain on 2020/5/23.给定n个数 a1,a2,a3....an,求是否存在这样的组合之和等于K
 */
public class DFS {
    public static final int[] array = {1,2,3,4,5};
    public static final int sum = 9;
    public static  int result = 0;
    boolean dfs(int i,int m){

        if (i==array.length-1){

            return sum == m;
        }
        if (dfs(i+1,m)) return true;
        if (dfs(i+1,m+array[i+1])) return true;
        return false;
    }

    public static void main(String[] args){
        DFS dfs=new DFS();
        System.out.print(dfs.dfs(0,0));
    }

}
