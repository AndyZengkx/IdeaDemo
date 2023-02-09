package main.practice;

import java.util.stream.Stream;

public class StreamPractice {

    public static void main(String ... args){
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7);
//        Integer[] nums = stream.filter(x->x>4).toArray(Integer[]::new);
        int[] nums = stream.mapToInt(Integer::intValue).toArray();
        for(var num : nums)
            System.out.println(num);
        System.out.println(System.getProperty("user.dir"));
    }

}
