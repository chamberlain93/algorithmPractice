package com.chamberlain.leetcode.dfs;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Created by chamberlain on 2021/11/28.
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * <p>
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * <p>
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * https://leetcode-cn.com/problems/course-schedule/
 */
public class ClassSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        int[] indegree = new int[numCourses];

        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        Queue<Integer> queue = new ArrayBlockingQueue<>(numCourses);

        for (int[] item : prerequisites) {
            indegree[item[0]]++;
            adjacencyList.get(item[1]).add(item[0]);
        }

        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            numCourses--;
            int pre = queue.poll();
            for (Integer item : adjacencyList.get(pre)) {
                if (--indegree[item] == 0) {
                    queue.add(item);
                }
            }

        }
        return numCourses == 0;
    }

    public boolean canFinish2(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacencyList = new ArrayList<>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        for (int[] item : prerequisites) {
            adjacencyList.get(item[1]).add(item[0]);
        }
        int[] flags = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(adjacencyList, flags, i)) {
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<List<Integer>> adjacencyList, int[] flags, int i) {
        if (flags[i] == -1) {
            return true;
        }
        if (flags[i] == 1) {
            return false;
        }

        flags[i] = 1;
        for (Integer j : adjacencyList.get(i)) {
            if (!dfs(adjacencyList, flags, j)) {
                return false;
            }
        }
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        int[][] array = {{1, 4}, {2, 4}, {3, 1}, {3, 2}};
        int course = 5;
        ClassSchedule classSchedule = new ClassSchedule();
        System.out.println(classSchedule.canFinish(5, array));
    }

}
