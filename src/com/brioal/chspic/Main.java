package com.brioal.chspic;

import java.util.Scanner;

public class Main {
//    public static void main(String[] args) {
//        String[] colors = getRGB("#010203");
//        String result = appendStr(colors);
//        System.out.print(result);
//        System.out.print(result);
//        System.out.println(transToASC2(result));
//    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // 宽高
        int width = scanner.nextInt();
        int height = scanner.nextInt();
        // 每块的狂傲
        int widthPeer = scanner.nextInt();
        int heightPeer = scanner.nextInt();
        // 比例 用于计算平均值
        int row = width / widthPeer;
        int col = height / heightPeer;
        // 则一共有row*col个颜色
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                String str = scanner.next();
                // 补充完整
                str = expandStr(str);
                // 获取rgb
                String[] colors = getRGB(str);
                // 添加颜色
                String result = appendStr(colors);
                // 转化成十六进制
                String ascStr = transToASC2(result);
                System.out.print(ascStr);
            }
            String str = "\n";
            // 转化成十六进制
            System.out.print(transToASC2(str));
        }
    }

    /**
     * 转化成ASSC2码
     *
     * @param string
     * @return
     */
    public static String transToASC2(String string) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < string.length(); i++) {
            char ch = string.charAt(i);
            // 获取十六进制
            String strHex = Integer.toHexString(ch);
            // 变成大写
            strHex = strHex.toUpperCase();
            // 如果只有一位,增加0
            if (strHex.length() == 1) {
                strHex = "0" + strHex;
            }
            buffer.append("\\x");
            buffer.append(strHex);
        }
        return buffer.toString();
    }


    public static String appendStr(String[] colors) {
        // 拼接字符串
        StringBuffer strBuffer = new StringBuffer();
        strBuffer.append("\033[48;2;");
        strBuffer.append(colors[0]);
        strBuffer.append(";");
        strBuffer.append(colors[1]);
        strBuffer.append(";");
        strBuffer.append(colors[2]);
        strBuffer.append("m \033[0m");
        return strBuffer.toString();
    }

    /**
     * 返回RGB颜色的三个十进制的值
     *
     * @param str
     * @return
     */
    public static String[] getRGB(String str) {
        String[] result = new String[3];
        // 去除#号
        str = str.substring(1);
        // 分割成三分
        String r = str.substring(0, 2);
        String g = str.substring(2, 4);
        String b = str.substring(4);
        // 转换成十进制
        result[0] = Integer.parseInt(r, 16) + "";
        result[1] = Integer.parseInt(g, 16) + "";
        result[2] = Integer.parseInt(b, 16) + "";
        return result;
    }

    /**
     * 扩展字母,补全简写形式
     * #abc -> #aabbcc
     * #a ->#aaaaaa
     *
     * @param string
     * @return
     */
    public static String expandStr(String string) {
        StringBuffer buffer = new StringBuffer();
        int length = string.length();
        if (length == 7) {
            return string;
        }
        if (string.length() == 2) {
            buffer.append(string);
            // #a ->#aaaaaa
            for (int i = 0; i < 5; i++) {
                buffer.append(string.charAt(1) + "");
            }
            return buffer.toString();
        }
        // #abc -> #aabbcc
        if (length == 4) {
            buffer.append("#");
            buffer.append(string.charAt(1) + "");
            buffer.append(string.charAt(1) + "");
            buffer.append(string.charAt(2) + "");
            buffer.append(string.charAt(2) + "");
            buffer.append(string.charAt(3) + "");
            buffer.append(string.charAt(3) + "");
        }
        return buffer.toString();
    }
}
