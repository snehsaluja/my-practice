package com.practice.mypractice.programs;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
import com.practice.mypractice.programs.dto.Employee;

// Learning Streams:

public class EmployeeService {
    public static void main(String[] args) {
        Employee e1 = new Employee("Sneh", 6000000, "Engineering");
        Employee e2 = new Employee("Bhavana", 7000000, "Engineering");
        Employee e3 = new Employee("Yo Yo honey singh", 100000, "Engineering");
        Employee e4 = new Employee("Badshah", 1000000, "Engineering");
        Employee e5 = new Employee("Diljit", 5000000, "Engineering");
        Employee e6 = new Employee("Sonu Nigam", 20000, "Singing");

        List<Employee> list = Lists.newArrayList(e1, e2, e3, e4, e5, e6);

        // Get top 3 salaried employees in Engineering dept:
        list.stream()
                .filter(employee -> employee.getDept().equals("Engineering"))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .forEach(System.out::println);

    }
}
