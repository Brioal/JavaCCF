package com.brioal.ccf2;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 获取数量
        int count = scanner.nextInt();
        // 循环输入
        int[] array = new int[count];
        // 存储最大值
        int max = Integer.MIN_VALUE;
        // 存储最小值
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < count; i++) {
            int n = scanner.nextInt();
            array[i] = n;
            if (n > max) {
                max = n;
            }
            if (n < min) {
                min = n;
            }
        }
        // 获取中位数
        int middle = 0;
        if (count % 2 == 0) {
            // 能被整除
            int index = (int) (count / 2);
            middle = (array[index - 1] + array[index]) / 2;
        } else {
            // 不能被整除
            int index = (int) (count / 2);
            middle = array[index];
        }
        // 输出
        System.out.println(max + " " + middle + " " + min);

    }
}
