# Java 8 stream Interview Questions & Answers

> Click :star:if you like the project. Pull Requests are highly appreciated. Connect me [@Ruptam](https://www.linkedin.com/in/ruptamsadhukhan/) for technical content.

### Table of Contents

| No. | Questions                                                                                                                                                         |
| --- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| 1   | [Find list of employees whose name starts with alphabet A](#find-list-of-employees-whose-name-starts-with-alphabet-A)                                         |
| 2   | [Group The employees By Department Names](#group-the-employees-by-department-names)                                                         |
| 3   | [Find the total count of employees using stream](#find-the-total-count-of-employees-using-stream)                                                         |
| 4   | [Find the max age of employees](#find-the-max-age-of-employees)                                                         |
| 5   | [Find all department names](#find-all-department-names)                                                         |
| 6   | [Find the count of employee in each department](#find-the-count-of-employee-in-each-department)                                                         |
| 7   | [Find the list of employees whose age is less than 30](#find-the-list-of-employees-whose-age-is-less-than-30)                                                         |
| 8   | [Find the list of employees whose age is in between 26 and 31](#find-the-list-of-employees-whose-age-is-in-between-26-and-31)                                                         |
| 9   | [Find the average age of male and female employee](#find-the-average-age-of-male-and-female-employee)|
| 10   | [Find the department who is having maximum number of employee](#find-the-department-who-is-having-maximum-number-of-employee)|
| 11   | [Find the Employee who stays in Delhi and sort them by their names](#find-the-employee-who-stays-in-delhi-and-sort-them-by-their-names)|
| 12   | [Find the average salary in all departments](#find-the-average-salary-in-all-departments)|
| 13   | [Find the highest salary in each department](#find-the-highest-salary-in-each-department)|
| 14   | [Find the list of employee and sort them by their salary](#find-the-list-of-employee-and-sort-them-by-their-salary)|
| 15   | [Find the employee who has second highest salary](#find-the-employee-who-has-second-highest-salary)|

1. ### Find list of employees whose name starts with alphabet A


      ```java
      List<Employee> aEmp = empList.stream()
			.filter(emp -> emp.getName().startsWith("A"))
						.collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**

2. ### Group The employees By Department Names

   ````java
      Map<String, List<Employee>> deptMap = empList.stream()
	.collect(Collectors.groupingBy(emp -> emp.getDepartmentName()));
      ````

**[⬆ Back to Top](#table-of-contents)**

3. ### Find the total count of employees using stream

   ```java
      long empCount = empList.stream().count();
      ```

**[⬆ Back to Top](#table-of-contents)**

4. ### Find the max age of employees

   ```java
      int maxAge = empList.stream().mapToInt(emp -> emp.getAge()).max().getAsInt();
      ```

**[⬆ Back to Top](#table-of-contents)**

5. ### Find all department names

   ```java
      List<String> deptNamesList = empList.stream()
	.map(emp -> emp.getDepartmentName()).collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**

6. ### Find the count of employee in each department

   ```java
      Map<String, Long> deptCountMap = empList.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.counting()));
      ```

**[⬆ Back to Top](#table-of-contents)**

7. ### Find the list of employees whose age is less than 30

   ```java
      List<Employee> ageList = empList.stream().filter(emp -> emp.getAge() < 30).collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**

8. ### Find the list of employees whose age is in between 26 and 31

   ```java
      List<Employee> ageBetween26And30 = employees.stream().filter(emp -> emp.getAge() < 30 && emp.getAge() > 26).collect(Collectors.toList());
      ```

**[⬆ Back to Top](#table-of-contents)**

9. ### Find the average age of male and female employee

   ```java
      Map<String, Double> avgAgeMap = empList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
      ```

**[⬆ Back to Top](#table-of-contents)**


10. ### Find the department who is having maximum number of employee

   ```java
      Map.Entry<String, Long> deptMaxCount = empList.stream().collect(Collectors.groupingBy(
				Employee::getDepartmentName, Collectors.counting()))
				.entrySet().stream().max(Map.Entry.comparingByValue()).get();
```

**[⬆ Back to Top](#table-of-contents)**

11. ### Find the Employee who stays in Delhi and sort them by their names

   ```java
      List<Employee> employees = empList.stream().filter(emp -> emp.getAddress().equals("Delhi")).sorted(Comparator.comparing(Employee::getName)).collect(Collectors.toList());
```

**[⬆ Back to Top](#table-of-contents)**

12. ### Find the average salary in all departments

   ```java
      Map<String, Double> deptAvgSalary = empList.stream().collect(Collectors.groupingBy(Employee::getDepartmentName, Collectors.averagingDouble(Employee::getSalary)));
```

**[⬆ Back to Top](#table-of-contents)**

13. ### Find the highest salary in each department

   ```java
      Map<String, Optional<Employee>> highestSalForEachDedpt = employees.stream().collect(Collectors.groupingBy(Employee::getDepartNames, Collectors.maxBy(Comparator.comparing(Employee::getSalary))));
```

**[⬆ Back to Top](#table-of-contents)**

14. ### Find the list of employee and sort them by their salary

   ```java
      List<Employee> emps = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).collect(Collectors.toList());
```

**[⬆ Back to Top](#table-of-contents)**

15. ### Find the employee who has second lowest salary

   ```java
      Employee emp = empList.stream().sorted(Comparator.comparing(Employee::getSalary)).skip(1).findFirst().get();
```

**[⬆ Back to Top](#table-of-contents)**














Good luck with your interview 😊

---

