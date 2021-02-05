package com.chinadaas.jdk.stream;

import com.chinadaas.jdk.model.Person;

import java.util.*;

/**
 * Created by: huhao
 * Date: 2021/2/5
 * 聚合（max/min/count)
 * max、min、count这些字眼你一定不陌生，没错，在mysql中我们常用它们进行数据统计。Java stream中也引入了这些概念和用法，极大地方便了我们对集合、数组的数据统计工作
 */
public class StreamMaxMinCount {

    public static void main(String[] args) {
        //获取String集合中最长的元素。
        List<String> list = Arrays.asList("adnm", "admmt", "pot", "xbangd", "weoujgsd");
        Optional<String> max = list.stream().max(Comparator.comparing(String::length));
        System.out.println("最长的元素为：" + max.get());

        //获取Integer集合中的最大值。
        List<Integer> list2 = Arrays.asList(7, 6, 9, 4, 11, 6);
        Optional<Integer> max1 = list2.stream().max(Comparator.comparing(Integer::intValue));
        System.out.println("最大的值为：" + max1.get());
        //自然排序
        Optional<Integer> max3 = list2.stream().max(Integer::compareTo);
        System.out.println("自然排序最大值：" + max3.get());
        //自定义排序
        Optional<Integer> max4 = list2.stream().max(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        });
        System.out.println("自定义排序最大值为：" + max4.get());

        //获取最大工资
        getMaxSalaryPersonName();

        //计算Integer集合中大于6的元素的个数。
        count();

    }

    /**
     * 获取员工最大工资
     */
    public static int getMaxSalaryPersonName() {
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));

        Optional<Person> max = personList.stream().max(Comparator.comparingInt(Person::getSalary));
        System.out.println("最大工资为：" + max.get().getSalary());

        return max.get().getSalary();
    }

    /**
     * 计算Integer集合中大于6的元素的个数。
     *
     * @return
     */
    public static int count() {
        List<Integer> list = Arrays.asList(7, 6, 4, 8, 2, 11, 9);
        long count = list.stream().filter(l -> l > 5).count();
        System.out.println("元素大于5的个数：" + count);
        return (int) count;

    }
}
