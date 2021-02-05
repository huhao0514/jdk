package com.chinadaas.jdk.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by: huhao
 * Date: 2021/2/5
 * 遍历/匹配（foreach/find/match）
 * Stream也是支持类似集合的遍历和匹配元素的，只是Stream中的元素是以Optional类型存在的。
 */

public class StreamForeachAndMatch {

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        // 遍历输出符合条件大于6的元素
        list.stream().filter(l -> l > 6).forEach(System.out::print);
        System.out.println("");
        // 匹配符合条件的第一个
        Optional<Integer> first = list.stream().filter(l -> l > 3).findFirst();
        if(first.isPresent()){
            System.out.print(first.get());
            System.out.println("");
        }
        //匹配任意（适用于并行流）还是取出符合条件的任意一个值
        Optional<Integer> any = list.parallelStream().filter(l -> l > 5).findAny();
        System.out.print(any.get());
        System.out.println("");
        //是否包含符合特定条件的元素
        boolean b = list.stream().anyMatch(l -> l > 10); //false
        System.out.println(b);
        boolean b2 = list.stream().anyMatch(l -> l > 5); //false
        System.out.println(b2);
        //stream中所有元素是否都匹配特定条件
        boolean b3 = list.stream().allMatch(l -> l > 4); //false
        System.out.println(b3);
        //stream中所有元素都不匹配特定条件
        boolean b4 = list.stream().noneMatch(l -> l > 10); //true
        System.out.println(b4);

    }
}
