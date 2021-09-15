package com.chamberlain.leetcode.easy;

/**
 * Created by chamberlain on 2021/9/14.
 */
public class ReverseInt {

    public int reverse(int x) {

        if(x == 0){
            return 0;
        }
        long result = 0;
        while(x%10 == 0){
            x = x/10;
        }
        while(x != 0){
            result = result*10 + x%10;
            x=x/10;
        }
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE){
            return 0;
        }
        return (int)result;
    }

    public static void main(String[] args) {
        ReverseInt ri = new ReverseInt();
        System.out.println(ri.reverse(1534236469));
    }
}
