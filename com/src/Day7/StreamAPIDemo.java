package com.Day7;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

    public class StreamAPIDemo {
        public static void main(String[] args) {
            List<Integer> list= Arrays.asList(10,20,30,40,50,60,99,77);
            System.out.println(list);
            Stream<Integer> s=list.stream();

//        for(int i=0;i<list.size();i++){
//            list.set(i, list.get(i)+5);
//        }
//        System.out.print(list);
//        List<Integer> list1=list.stream().map(I->I+5).collect(Collectors.toList());
//        System.out.println(list1);
            List<Integer> list2=list.stream().filter(I->I%2!=0).collect(Collectors.toList());
            System.out.println(list2);

            list.forEach(System.out::println);
        }
    }

