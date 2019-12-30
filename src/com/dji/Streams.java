package com.dji;

import java.util.Arrays;
import java.util.List;


public class Streams {

    public static void main(String[] args) {
        List list = Arrays.asList(1, 2);
        list.stream().distinct().forEach(x-> System.out.println(list));

    }
}
