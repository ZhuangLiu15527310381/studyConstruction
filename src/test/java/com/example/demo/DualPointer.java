package com.example.demo;


import org.junit.jupiter.api.Test;

import java.util.Objects;

/**
 * 双指针主要用于数组，字符串，链表等数据结构
 */

public class DualPointer {



    @Test
    void contextLoads() {


        String abcdefg = reverseString2("abcdefg", 2);
        System.out.println(abcdefg);

    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     * <img src="https://camo.githubusercontent.com/af914d7ac56d356860bc689966e569893795615f940f5f725321f649d2b5af2f/68747470733a2f2f636f64652d7468696e6b696e672e63646e2e626365626f732e636f6d2f676966732f32372e2545372541372542422545392539392541342545352538352538332545372542342541302d2545362539412542342545352538412539422545382541372541332545362542332539352e676966"/>
     */
    public int removeValue(int[] nums,int value){
        int slowIndex = 0;
        for (int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            if (nums[fastIndex] != value){
                nums[slowIndex++] = nums[fastIndex];
            }
        }
        return slowIndex;
    }

    /**
     * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
     *
     * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
     *
     * 你可以假设数组中的所有字符都是 ASCII 码表中的可打印字符。
     *
     * 示例 1：
     * 输入：["h","e","l","l","o"]
     * 输出：["o","l","l","e","h"]
     *
     * 示例 2：
     * 输入：["H","a","n","n","a","h"]
     * 输出：["h","a","n","n","a","H"]
     */

    public String[] reverseChar(String[] chars){
        if (Objects.isNull(chars) || chars.length==0){
            return chars;
        }
        int leftIndex = 0;
        int rightIndex = chars.length -1;
        while (leftIndex < rightIndex){
            String ch = chars[leftIndex];
            chars[leftIndex] = chars[rightIndex];
            chars[rightIndex] = ch;
            leftIndex++;
            rightIndex--;
        }
        return chars;
    }


    /**
     * 给定一个字符串 s 和一个整数 k，从字符串开头算起, 每计数至 2k 个字符，就反转这 2k 个字符中的前 k 个字符。
     *
     * 如果剩余字符少于 k 个，则将剩余字符全部反转。
     *
     * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
     *
     * 示例:
     *
     * 输入: s = "abcdefg", k = 2
     * 输出: "bacdfeg"
     */
    public String reverseString(String input,int k){
        if (Objects.isNull(input)){
            return null;
        }

        int startIndex = 0;
        int length = input.length();
        StringBuilder res = new StringBuilder();
        while (startIndex < length) {
            int firstK = Math.min((startIndex + k), length);
            int secondK = Math.min((startIndex + 2 * k), length);
            StringBuilder temp = new StringBuilder();
            temp.append(input, startIndex, firstK).reverse();
            temp.append(input, firstK, secondK);
            res.append(temp);
            startIndex = startIndex + 2 * k;
        }
        return res.toString();
    }

    public String reverseString2(String input,int k){
        if (Objects.isNull(input)){
            return null;
        }
        char[] charArray = input.toCharArray();
        for (int i = 0; i < charArray.length; i= i+2*k) {
            int leftIndex = i;
            int rightIndex = Math.min(leftIndex + k -1 ,charArray.length-1);
            while (leftIndex < rightIndex){
                char temp = charArray[leftIndex];
                charArray[leftIndex] = charArray[rightIndex];
                charArray[rightIndex] = temp;
                leftIndex++;
                rightIndex--;
            }
        }
        return new String(charArray);
    }







}
