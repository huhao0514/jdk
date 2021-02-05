package com.chinadaas.jdk.stream;

import com.chinadaas.jdk.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by: huhao
 * Date: 2021/2/5
 * 映射(map/flatMap)
 * 映射，可以将一个流的元素按照一定的映射规则映射到另一个流中。分为map和flatMap
 * map：接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素
 * flatMap：接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流。
 */
public class StreamMap {

    public static void main(String[] args) {

        //英文字符串数组的元素全部改为大写
        String[] strArr = {"abcd", "bcdd", "defde", "fTr"};
        List<String> strList = Arrays.stream(strArr).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(strList);

        //整数数组每个元素+3
        List<Integer> intList = Arrays.asList(1, 3, 5, 7, 9, 11);
        List<Integer> integerList = intList.stream().map(i -> i + 3).collect(Collectors.toList());
        System.out.println(integerList);

        //将员工的薪资全部增加1000。
        List<Person> personList = new ArrayList<Person>();
        personList.add(new Person("Tom", 8900, 23, "male", "New York"));
        personList.add(new Person("Jack", 7000, 25, "male", "Washington"));
        personList.add(new Person("Lily", 7800, 21, "female", "Washington"));
        personList.add(new Person("Anni", 8200, 24, "female", "New York"));
        personList.add(new Person("Owen", 9500, 25, "male", "New York"));
        personList.add(new Person("Alisa", 7900, 26, "female", "New York"));
        //不改变原来员工集合的方式
        List<Person> personNewList = personList.stream().map(person -> {
            Person personNew = new Person(person.getName(), person.getSalary() + 1000, 0, null, null);
            return personNew;
        }).collect(Collectors.toList());
        System.out.println("一次改动前：" + personList.get(0).getName() + ",工资：" + personList.get(0).getSalary());
        System.out.println("一次改动后：" + personNewList.get(0).getName() + ",工资：" + personNewList.get(0).getSalary());

        //改变原来员工集合的方式
        List<Person> personList1 = personList.stream().map(person -> {
            person.setSalary(person.getSalary() + 1000);
            return person;
        }).collect(Collectors.toList());

        System.out.println("二次改动前：" + personList.get(0).getName() + ",工资：" + personList.get(0).getSalary());
        System.out.println("二次改动后：" + personList1.get(0).getName() + ",工资：" + personList1.get(0).getSalary());

        //将两个字符数组合并成一个新的字符数组。flatMap
        List<String> list = Arrays.asList("m,k,l,a", "1,3,5,7");
        List<String> collect = list.stream().flatMap(s -> {
            //将每个元素转换成一个stream
            String[] split = s.split(",");
            Stream<String> stream = Arrays.stream(split);
            return stream;
        }).collect(Collectors.toList());
        System.out.println("处理前集合：" + list);
        System.out.println("处理后集合" + collect);
    }

}
