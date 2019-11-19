package com.brioal.Imstuck;

import java.util.Scanner;

public class Main {

    private static int row = 0;
    private static int col = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 读取行数
        row = scanner.nextInt();
        // 读取列数
        col = scanner.nextInt();
        // 数组
        char[][] matrix = new char[row][];
        for (int i = 0; i < row; i++) {
            char[] chs = new char[col];
            for (int j = 0; j < col; j++) {
                char ch = scanner.next().charAt(0);
                chs[j] = ch;
            }
            matrix[i] = chs;
        }

    }
//
//    /**
//     * 判断是否能达到
//     * @param matrix
//     * @param startX
//     * @param startY
//     * @param endX
//     * @param endY
//     * @return
//     */
//    public static boolean canArrive(char[][] matrix, int startX, int startY, int endX, int endY) {
//        if (startX < 0 || startY < 0 || endX > row - 1 || endY > col - 1) {
//            return false;
//        }
//
//    }
}
