package com.brioal.xiaomingapple2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取树的总数
        int treeCount = scanner.nextInt();
        // 存储剩余苹果总数
        int[] all = new int[treeCount];
        // 存储是否掉落了
        boolean[] drop = new boolean[treeCount];
        for (int i = 0; i < treeCount; i++) {
            int times = scanner.nextInt();
            for (int j = 0; j < times; j++) {
                int n = scanner.nextInt();
                if (n > 0) {
                    // 获取到的是苹果的总数
                    if (all[i] == 0) {
                        // 第一次赋值
                    } else {
                        // 重新计算了
                        if (n != all[i]) {
                            // 发生了掉落
                            drop[i] = true;
                        }
                    }
                    all[i] = n;
                } else {
                    // 掉落的数量
                    all[i] += n;
                }
            }
        }
        // 获取苹果总数
        int allApple = 0;
        // 获取掉落的树的数量
        int dropTreeCount = 0;
        // 连续三个的组数量
        for (int i = 0; i < all.length; i++) {
            allApple += all[i];
            if (drop[i]) {
                dropTreeCount++;
            }
        }
        // 判断是否连续
        int succession = 0;
        for (int i = 0; i < drop.length; i++) {
            if (drop[i] && drop[(i + 1) % drop.length] && drop[(i + 2) % drop.length]) {
                succession++;
            }
        }
        System.out.println(allApple + " " + dropTreeCount + " " + succession);
    }
}
