package com.example.demo;


import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.AnnotationUtils;
import org.junit.platform.commons.util.StringUtils;

import java.util.ArrayList;
import java.util.Objects;

/**
 * 双指针主要用于数组，字符串，链表等数据结构
 */

public class DualPointer {



    @Test
    void contextLoads() {


//        removeExtraSpaces(" a  ss b s  ");
    }

    /**
     * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并原地修改输入数组。
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <img src="https://camo.githubusercontent.com/af914d7ac56d356860bc689966e569893795615f940f5f725321f649d2b5af2f/68747470733a2f2f636f64652d7468696e6b696e672e63646e2e626365626f732e636f6d2f676966732f32372e2545372541372542422545392539392541342545352538352538332545372542342541302d2545362539412542342545352538412539422545382541372541332545362542332539352e676966"/>
     *
     *
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


    /**
     *给定一个字符串，逐个翻转字符串中的每个单词。
     *
     * 示例 1：
     * 输入: "the sky is blue"
     * 输出: "blue is sky the"
     *
     * 示例 2：
     * 输入: "  hello world!  "
     * 输出: "world! hello"
     * 解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     *
     * 示例 3：
     * 输入: "a good   example"
     * 输出: "example good a"
     * 解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
     */

    @Test
    public void testWordsReverse(){

        String s = reverseWords("a good  example   ");
        System.out.println(s);


    }


    public String reverseWords(String s) {
        StringBuilder stringBuilder = removeExtrSpace(s);
        //字符串全部反转
        stringBuilder = reverseStringBuilder(stringBuilder,0,stringBuilder.length()-1);
        stringBuilder = reverseEveryWord(stringBuilder);
        return stringBuilder.toString();
    }


    /**
     * 去除字符串中的空格
     * @param input
     * @return
     */
    public StringBuilder removeExtrSpace(String input) {
        char[] charArray = input.toCharArray();
        int startIndex = 0;
        int rightIndex = charArray.length - 1;
        StringBuilder stringBuilder = new StringBuilder();
        while (charArray[startIndex] == ' ') {
            startIndex++;
        }
        while (charArray[rightIndex] == ' ') {
            rightIndex--;
        }
        while (startIndex <= rightIndex) {
            if (charArray[startIndex] !=' ' || stringBuilder.charAt(stringBuilder.length()-1) != ' '){
                stringBuilder.append(charArray[startIndex]);
            }
            startIndex++;
        }
        return stringBuilder;
    }

    /**
     * 反转字符串指定区间[start, end]的字符
     */
    private StringBuilder reverseStringBuilder(StringBuilder stringBuilder, int leftIndex, int rightIndex) {
        while (leftIndex <= rightIndex){
            char temp = stringBuilder.charAt(leftIndex);
            stringBuilder.setCharAt(leftIndex,stringBuilder.charAt(rightIndex));
            stringBuilder.setCharAt(rightIndex,temp);
            leftIndex++;
            rightIndex--;
        }
        return stringBuilder;
    }

    private StringBuilder reverseEveryWord(StringBuilder stringBuilder) {
        int startIndex = 0;
        int endIndex = 1;
        while (startIndex <= endIndex && endIndex < stringBuilder.length()){
            if (stringBuilder.charAt(endIndex) ==' '){
                reverseStringBuilder(stringBuilder,startIndex,endIndex-1);
                startIndex =Math.min(endIndex+1,stringBuilder.length()-1);
                endIndex = Math.min(startIndex+1,stringBuilder.length()-1);
            }
            endIndex++;
        }
        return stringBuilder;
    }


    /**
     * 字符串的右旋转操作是把字符串尾部的若干个字符转移到字符串的前面。
     * 给定一个字符串 s 和一个正整数 k，请编写一个函数，将字符串中的后面 k 个字符移到字符串的前面，实现字符串的右旋转操作。
     *
     * 例如，对于输入字符串 "abcdefg" 和整数 2，函数应该将其转换为 "fgabcde"。
     *
     * 输入：输入共包含两行，第一行为一个正整数 k，代表右旋转的位数。第二行为字符串 s，代表需要旋转的字符串。
     *
     * 输出：输出共一行，为进行了右旋转操作后的字符串。
     */
    @Test
    public void testRight(){

        String abcdefg = rightReverse("abcdefg", 2);
        System.out.println(abcdefg);

    }

    public String rightReverse(String inputString , int k){
        if (Objects.isNull(inputString)){
            return inputString;
        }
        if (k > inputString.length()){
            return inputString;
        }
        char[] charArray = inputString.toCharArray();
        int startIndex=0;
        int endIndex = charArray.length - k;
        StringBuilder sb = new StringBuilder();
        while (endIndex < charArray.length){
            sb.append(charArray[endIndex]);
            endIndex++;
        }
        while (startIndex < charArray.length-k){
            sb.append(charArray[startIndex]);
            startIndex++;
        }

        return sb.toString();
    }


    /**
     * 给定一个字符串 s，它包含小写字母和数字字符，请编写一个函数，将字符串中的字母字符保持不变，而将每个数字字符替换为number。
     *
     * 例如，对于输入字符串 "a1b2c3"，函数应该将其转换为 "anumberbnumbercnumber"。
     *
     * 对于输入字符串 "a5b"，函数应该将其转换为 "anumberb"
     *
     * 输入：一个字符串 s,s 仅包含小写字母和数字字符。
     *
     * 输出：打印一个新的字符串，其中每个数字字符都被替换为了number
     *
     * 样例输入：a1b2c3
     *
     * 样例输出：anumberbnumbercnumber
     *
     * 数据范围：1 <= s.length < 10000。
     *
     */
    public String replaceDigital(String input){
        if (Objects.isNull(input)){
            return null;
        }
        char[] charArray = input.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : charArray) {
            if (Character.isDigit(c)){
                stringBuilder.append("number");
            }else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }


    /**
     *  KMP算法   先计算前后缀公共最长子序列
     * 实现 strStr() 函数。
     *
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * 示例 1: 输入: haystack = "hello", needle = "ll" 输出: 2
     *
     * 示例 2: 输入: haystack = "aaaaa", needle = "bba" 输出: -1
     *
     *
     */

    public int getIndexOfString(String input,String key){
        int[] next = getNext(key);
        char[] charArray = input.toCharArray();
        char[] keyCharArray = key.toCharArray();
        int j = 0;
        for (int i = 0; i < charArray.length; i++) {
            while (j > 0 && charArray[i] != charArray[j]){
                j = next[j-1];
            }
            if (charArray[i] == keyCharArray[j]){
                j++;
            }
            if (j == keyCharArray.length-1){
                return j;
            }
        }
        return -1;
    }


    public int[] getNext(String input){
        int[] next = new int[input.length()];
        char[] charArray = input.toCharArray();
        int j = 0;
        for (int i = 1; i < charArray.length; i++) {
            while (j > 0 && charArray[j] != charArray[i]) {
                j = next[j - 1];
            }
            if (charArray[i] == charArray[j] ){
                j++;
            }
            next[i] = j;
        }
        return next;
    }










}
