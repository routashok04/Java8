package com.ashok;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        List<Employee> emplist=new ArrayList<>();
        emplist.add(new Employee(101,"sudeep",101,"active",2000));
        emplist.add(new Employee(102,"akash",101,"active",2500));
        emplist.add(new Employee(103,"kamal",102,"inactive",2200));
        emplist.add(new Employee(104,"naresh",102,"inactive",2900));
        emplist.add(new Employee(105,"bob",103,"active",3500));
        emplist.add(new Employee(106,"guru",103,"inactive",3000));
        emplist.add(new Employee(107,"prakash",104,"active",3400));

        //to print emp details using streams
        Map<Integer, List<Employee>> collect = emplist.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.toList()));
        collect.entrySet().forEach(integerListEntry -> {
            System.out.println(integerListEntry.getKey() +"--------"+integerListEntry.getValue());
        });

        //count allemployee using each Dept
        Map<Integer, Long> empCountDept = emplist.stream().collect(Collectors.groupingBy(Employee::getDeptId, Collectors.counting()));
        empCountDept.entrySet().forEach(integerLongEntry -> {
            System.out.println(integerLongEntry.getKey() + "----" + integerLongEntry.getValue());
        });
    }
}
