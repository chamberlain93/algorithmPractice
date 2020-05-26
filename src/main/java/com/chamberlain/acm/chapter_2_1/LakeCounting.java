package com.chamberlain.acm.chapter_2_1;

/**
 * Created by chamberlain on 2020/5/26.
 */
public class LakeCounting {

    private int x=6;
    private int y=6;
    private char[][] field = {{'w','w','*','*','*','*'},
                              {'*','w','*','*','w','w'},
                              {'*','w','*','*','w','w'},
                              {'w','w','*','*','w','*'},
                              {'*','w','*','*','w','w'},
                              {'*','w','*','*','w','w'}};


    public void dfs(int i,int j){
        field[i][j]='*';
        for (int ai=-1;ai<=1;ai++){
            for (int bi=-1;bi<=1;bi++){
                int ci = i+ai;
                int cj = j+bi;
                if (ci<=x-1&&ci>=0&&cj<=y-1&&cj>=0&&field[ci][cj]=='w'){
                    dfs(ci,cj);
                }
            }
        }
    }

    public int solve(){
        int result= 0;
        for (int i =0;i<x;i++){
            for (int j = 0;j<y;j++){
                if (field[i][j]=='w'){
                    dfs(i,j);
                    result++;
                }

            }
        }
        return result;
    }

    public static void main(String[] args){
        System.out.println(new LakeCounting().solve());
    }
}
