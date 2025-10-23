package com.example.demo.practice;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.var;

public class streams {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
            new Employee("John", 30, "Developer"),
            new Employee("Jane", 25, "Designer"),
            new Employee("Mike", 35, "Manager"),
            new Employee("Emily", 28, "Developer")
        );

        Map<String, Long> roleCount =  employees.stream()
        .collect(Collectors.groupingBy(
            Employee::getRole, 
            Collectors.counting()
            ));
        
        List<String> MostEmployees = roleCount.entrySet().stream()
        .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
        .map(Map.Entry::getKey)
        .toList();
        
        System.err.println(MostEmployees.get(0) + " has the most employees with a count of " + roleCount.get(MostEmployees.get(0)) );
        }

        
    }

    
  
    
class Employee {
    String name;
    int age;
    String role;

    public Employee(String name, int age, String role) {
        this.name = name;
        this.age = age;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getRole() {
        return role;
    }
   
}
