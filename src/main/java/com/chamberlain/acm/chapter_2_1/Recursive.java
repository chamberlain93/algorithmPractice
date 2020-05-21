package com.chamberlain.acm.chapter_2_1;

/**
 * Created by chamberlain on 2020/5/21.
 */
public class Recursive {

    public int fact(int n) {
        if (n == 1) {
            return 1;
        }
        return n * fact(n - 1);
    }

    public int fib(int n){
        if (n==1||n==2){
            return 1;
        }
       return fib(n-1)+fib(n-2);
    }

    public static void main(String[] args) {
        Recursive re = new Recursive();
        System.out.println(re.fact(3));
        System.out.println(re.fib(7));
    }

}
