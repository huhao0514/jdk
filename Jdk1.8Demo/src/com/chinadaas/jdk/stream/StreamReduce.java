package com.chinadaas.jdk.stream;

import com.chinadaas.jdk.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by: huhao
 * Date: 2021/2/5
 * 归约(reduce)
 * 归约，也称缩减，顾名思义，是把一个流缩减成一个值，能实现对集合求和、求乘积和求最值操作。
 */
public class StreamReduce {

    public static void main(String[] args) {

        //求Integer集合的元素之和、乘积和最大值。
        List<Integer> list = Arrays.asList(1, 3, 2, 8, 11, 4);
        //求和方式1
        Optional<Integer> sum1 = list.stream().reduce(Integer::sum);
        System.out.println("求和方式1：" + sum1.get());
        //求和方式2
        Optional<Integer> sum2 = list.stream().reduce((x, y) -> x + y);
        System.out.println("求和方式2：" + sum2.get());
        //求和方式3
        Integer sum3 = list.stream().reduce(0, Integer::sum);
        System.out.println("求和方式3：" + sum3);

        //求乘积
        Optional<Integer> reduce = list.stream().reduce((x, y) -> x * y);
        System.out.println("乘积：" + reduce.get());

        //求最大值方式1
        Optional<Integer> reduce1 = list.stream().reduce((x, y) -> x > y ? x : y);
        System.out.println("最大值方式1：" + reduce1.get());

        //求最大值方式2
        Optional<Integer> reduce2 = list.stream().reduce(Integer::max);
        System.out.println("求最大值方式2:" + reduce2.get());//11

        //求最大值方式3,若identity的数值超过了数组中元素的值，最大值为identity
        Integer reduce3 = list.stream().reduce(12, Integer::max); //12
        System.out.println(reduce3);

        Integer reduce4 = list.stream().reduce(0, Integer::max); //11
        System.out.println("求最大值方式3：" + reduce4);

        //求所有员工的工资之和和最高工资
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        //求工资之和方式1：
        Optional<Integer> salarySum1 = personList.stream().map(Person::getSalary).reduce(Integer::sum);
        System.out.println("求工资之和方式1：" + salarySum1.get());
        //求工资之和方式2：
        Integer salarySum2 = personList.stream().reduce(0, (total, p) -> total += p.getSalary(), Integer::sum);
        System.out.println("求工资之和方式2：" + salarySum2);

        //求工资之和方式3
        Integer salarySum3 = personList.stream().reduce(0, (total, p) -> total += p.getSalary(), (total1, total2) -> total1 + total2);
        System.out.println("求工资之和方式3：" + salarySum3);

        // 求最高工资方式1：
        Optional<Integer> countMax1 = personList.stream().map(Person::getSalary).reduce(Integer::max);
        System.out.println("求最高工资方式1:" + countMax1.get());

        // 求最高工资方式2
        Integer countMax2 = personList.stream().reduce(0, (big, p) -> big > p.getSalary() ? big : p.getSalary(), Integer::max);
        System.out.println("求最高工资方式2:" + countMax2);


        // 求最高工资方式3
        Integer maxSalary2 = personList.stream().reduce(0, (max, p) -> max > p.getSalary() ? max : p.getSalary(),
                (max1, max2) -> max1 > max2 ? max1 : max2);

        System.out.println("求最高工资方式3:"+maxSalary2);

    }
}
