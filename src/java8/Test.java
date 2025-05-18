package java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Test {
    public static void main(String[] args) {
        List<Employee1> list = new ArrayList<>();
        list.add(new Employee1("Scott", 100.0, "Tech"));
        list.add(new Employee1("Bob", 150.0, "Tech"));
        list.add(new Employee1("Martin", 200.0, "HR"));
        list.add(new Employee1("Alex", 250.0, "Sales"));
        list.add(new Employee1("Alan", 300.0, "Sales"));

        list.stream()
                .collect(Collectors.groupingBy(Employee1::getDept))
                .forEach((dept, employees) -> {
                    Collections.sort(employees, Comparator.comparing(Employee1::getSalary).reversed());
                    System.out.println();
                });


    }
}

class Employee1 {
    String name;
    double salary;
    String dept;

    public Employee1(String name, double salary, String dept) {
        this.name = name;
        this.salary = salary;
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }
}