package com.brioal.xiaomingapple;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取果树数量
        int treeCount = scanner.nextInt();
        // 获取轮数
        int rolCount = scanner.nextInt();
        // 存储全部数量
        int[] all = new int[treeCount];
        // 存储去掉的数量
        int[] remove = new int[treeCount];
        // 总数
        int t = 0;
        // 去掉最多的编号
        int k = 0;
        for (int i = 0; i < treeCount; i++) {
            for (int j = 0; j < rolCount+1; j++) {
                int n = scanner.nextInt();
                n = Math.abs(n);
                if (j == 0) {
                    // 读取的是初始的数量
                    all[i] = n;
                } else {
                    // 读取的是去掉的数量
                    remove[i] += n;
                    // 减掉原本的
                    all[i] -= n;
                }
            }
        }
        // 计算总数
        for (int i = 0; i < all.length; i++) {
            t += all[i];
        }
        // 获取去掉最多的数量的下标
        int max = 0;
        for (int i = 0; i < remove.length; i++) {
            int n = remove[i];
            if (n > max) {
                max = n;
                k = i;
            }
        }
        // 输出
        System.out.println(t + " " + (k + 1) + " " + remove[k]);
    }
}
