package main.practice;

import java.util.ArrayList;

public class CollectionTest {

    public static void main(String ... args){
        var list = new ArrayList<Integer>();
        for(int i = 0; i < 30; i++)
            list.add(i);
        list.forEach(System.out::println);
        list.removeIf((x)->x<10);
        list.forEach(System.out::println);
    }

}
