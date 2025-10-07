package com.example.demo;

import java.util.*;
import java.util.stream.Collectors;


public class DemoApplication {

	static List<Employee> employees = Arrays.asList(
			new Employee(1, "Abraham", 29, "IT", "Mumbai", 20000, "Male"),
			new Employee(2, "Mary", 27, "Sales", "Chennai", 25000, "Female"),
			new Employee(3, "Joe", 28, "IT", "Chennai", 22000, "Male"),
			new Employee(4, "John", 29, "Sales", "Gurgaon", 29000, "Male"),
			new Employee(5, "Liza", 25, "Sales", "Bangalore", 32000, "Female"),
			new Employee(6, "Peter", 27, "Admin", "Mumbai", 31500, "Male"),
			new Employee(7, "Harry", 30, "Research", "Kochi", 21000, "Male")
			);

	public static void main(String[] args) {

		List<Employee> employeeWithA = employees.stream().filter(emp -> emp.getName().startsWith("A")).collect(Collectors.toList());
		System.out.println("Employees whose name starts with A \n" + employeeWithA);


		Map<String, List<Employee>> deptWithEmployee = employees.stream().collect(Collectors.groupingBy(Employee::getDepartNames));
		System.out.println("Group employees by department names \n"+deptWithEmployee);

		long count = employees.stream().count();
		System.out.println("Total Number of employees " + count);

		int age = employees.stream().mapToInt(Employee::getAge).max().getAsInt();
		System.out.println("Maximum age of employee "+ age);

		Set<String> allDepartmentNames = employees.stream().map(Employee::getDepartNames).collect(Collectors.toSet());
		System.out.println("Name of all department "+ allDepartmentNames);

		Map<String, Long> employeeCountByDepartment = employees.stream().collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.counting()));
		System.out.println(employeeCountByDepartment);

		List<Employee> ageLessThan30 = employees.stream().filter(emp -> emp.getAge() < 30).collect(Collectors.toList());
		System.out.println(ageLessThan30);

		List<Employee> ageBetween26And30 = employees.stream().filter(emp -> emp.getAge() < 30 && emp.getAge() > 26).collect(Collectors.toList());
		System.out.println(ageBetween26And30);

		Map<String, Double> avgAgeOfMaleAndFemale = employees.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println("Average age of male & female "+ avgAgeOfMaleAndFemale);

		Map.Entry<String, Long> deptMaxcount = employees.stream().collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).get();
		System.out.println("Department having maximum number of employees " + deptMaxcount);


		List<Employee> chennaiEmployee = employees.stream().filter(emp -> emp.getAddress().equals("Chennai")).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
		System.out.println("Employee staying in Chnnai and sorted by their names " + chennaiEmployee);

		Map<String, Double> avgSalForEachDept = employees.stream().collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.averagingDouble(Employee::getSalary)));
		System.out.println("Average salary of each department " + avgSalForEachDept);

		Map<String, Optional<Employee>> highestSalForEachDedpt = employees.stream().collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
		System.out.println(highestSalForEachDedpt);

		List<Employee> employeesWithSortedSalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
		System.out.println(employeesWithSortedSalary);

		Employee withSecondHighestSalary = employees.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get();
		System.out.println(withSecondHighestSalary);
	}

}
