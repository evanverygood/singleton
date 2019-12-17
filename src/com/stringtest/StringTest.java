package com.stringtest;

public class StringTest {

    public static void main(String[] args) {
        String s3 = new String("a"+"b");
        String s1 = "a"+"b";
        String s2 = "a"+"b";


        System.out.println(s1==s2);  //比较地址值
        System.out.println(s1==s3);  //加了“”的地址值不会变
        System.out.println(s2==s3);
        System.out.println(s2.equals(s3)); //new一个出来肯定是变的，但是值是一样的，所以

    }
}
