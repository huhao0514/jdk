package com.chinadaas.jdk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by: huhao
 * Date: 2021/1/27
 * Stream 创建
 */
public class CreateStreamDemo {
    public static void main(String[] args) {
//        demo1();
//        demo2();
        demo3();
    }


    /**
     * Stream可以通过集合数组创建.
     * 通过 java.util.Collection.stream() 方法用集合创建流
     *
     * @return
     */
    public static Stream<String> demo1() {
        List<String> list = Arrays.asList("1", "2", "3");
        //创建一个顺序流
        Stream<String> stream = list.stream();
        //创建一个并行流
        Stream<String> parallelStream = list.parallelStream();
        stream.forEach(System.out::println);
        return stream;

    }

    /**
     * 使用java.util.Arrays.stream(T[] array)方法用数组创建流
     */
    public static IntStream demo2() {
        int[] arr = {1, 2, 3};
        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
        return stream;
    }

    /**
     * 使用Stream的静态方法：of()、iterate()、generate()
     */
    public static Stream<Integer> demo3() {
        Stream<Integer> stream = Stream.of(1, 2, 3, 4);
        stream.forEach(System.out::println);
        Stream<Integer> stream2 = Stream.iterate(1, (x) -> x + 2).limit(5);
        stream2.forEach(System.out::println);
        Stream<Double> stream3 = Stream.generate(Math::random).limit(4);
        stream3.forEach(System.out::println);
        return stream;

    }

}

