package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class ArrayListTest {
    public static void main(String[] args) {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Martin", 800, "IT"));
        employeeList.add(new Employee("james", 400, "IT"));
        employeeList.add(new Employee("scot", 600, "IT"));

        employeeList.add(new Employee("Tom", 400, "Admin"));
        employeeList.add(new Employee("bob", 300, "Admin"));

        employeeList.add(new Employee("Alex", 350, "HR"));
        employeeList.add(new Employee("miller", 200, "HR"));
        employeeList.add(new Employee("max", 200, "HR"));

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {
                return o2.getSalary() - o1.getSalary();
            }
        };

        employeeList.stream().sorted(comparator).collect(Collectors.toList())
                .forEach(System.out::println);

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return null;
            }
        };

        Future<Integer> submit = Executors.newFixedThreadPool(10).submit(callable);
    }
}
