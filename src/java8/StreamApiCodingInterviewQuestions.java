package java8;

import java.util.*;
import java.util.stream.Collectors;

public class StreamApiCodingInterviewQuestions {
    public static void main(String[] args) throws InterruptedException {
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee("Martin", 800, "IT"));
        employeeList.add(new Employee("james", 400, "IT"));
        employeeList.add(new Employee("scot", 600, "IT"));

        employeeList.add(new Employee("Tom", 400, "Admin"));
        employeeList.add(new Employee("bob", 300, "Admin"));

        employeeList.add(new Employee("Alex", 350, "HR"));
        employeeList.add(new Employee("miller", 200, "HR"));
        employeeList.add(new Employee("max", 200, "HR"));

//        printEmployeeWorkingInEachDepartment(employeeList);
//        print_Min_Salary_Employee(employeeList);
//        print_Max_Salary_Employee(employeeList);
//        print_Max_Salary_Employee_Working_In_Each_Department(employeeList);
        sort_By_Dept_Then_By_Salary(employeeList);

    }

    // Here we will use groupingBy to group employees dept wise
    public static void print_Employee_Name_Working_In_Each_Department(List<Employee> employeeList) {
        Map<String, List<Employee>> employeesDeptWise = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

//      Using this we can specify our own collector
//        Map<String, Set<Employee>> employeesDeptWiseSet = employeeList.stream()
//                .collect(Collectors.groupingBy(Employee::getDept, Collectors.toSet()));

        employeesDeptWise.forEach( (dept, employees) -> {
            System.out.println("Dept: " + dept + "  " + "employees=" + concatEmployeeNames(employees));
        });
    }

    // Here we will use joining to concatenate list<String> to single string
    public static String concatEmployeeNames(List<Employee> employees) {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(", "));
    }

    public static void printCountOf_Employee_Working_In_Each_Department(List<Employee> employeeList) {
        Map<String, List<Employee>> employeesDeptWise = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        employeesDeptWise.forEach( (dept, employees) -> {
            System.out.println("Dept: " + dept + "  " + "employees=" + employees.size());
        });
    }

    //Here min function requireds the stream to be sorted in ascending order and then it will take the first object
    public static void print_Min_Salary_Employee(List<Employee> employees) {
        Optional<Employee> employeeOptional = employees.stream()
                .min(Comparator.comparing(Employee::getSalary));
        System.out.println(employeeOptional.get());
    }


    //Here max function requireds the stream to be sorted in ascending order and then it will take the last object
    public static void print_Max_Salary_Employee(List<Employee> employees) {
        Optional<Employee> employeeOptional = employees.stream()
                .max(Comparator.comparing(Employee::getSalary));
        System.out.println(employeeOptional.get());
    }

    public static void print_Max_Salary_Employee_Working_In_Each_Department(List<Employee> employees) {
        Map<String, List<Employee>> employeesDeptWise = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        employeesDeptWise.forEach( (dept, employeesInDept) -> {
            System.out.println("Dept: " + dept + "  Salary: " + employeesInDept.stream().max(Comparator.comparing(Employee::getSalary)).get());
        });
    }

    public static void sort_By_Dept_Then_By_Salary(List<Employee> employees) {
        List<Employee> sortedEmployees = employees.stream().sorted(
                    Comparator.comparing(Employee::getDept)
                    .thenComparing(Employee::getSalary)
                ).collect(Collectors.toList());

        System.out.println(sortedEmployees);
    }
}



class Employee {
    String name;
    int salary;
    String dept;

    public Employee(String name, int salary, String dept) {
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                '}';
    }

    public void salaryIncrement(double v) {
    }
}