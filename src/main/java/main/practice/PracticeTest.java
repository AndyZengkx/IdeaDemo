package main.practice;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class PracticeTest {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, InstantiationException {
        var employee = new Employee("employee", 2000, 1999, 4, 23);
        var test = Employee.class;
        System.out.println(test.getName());
        var constructors = test.getConstructors();
        for (var constructor : constructors) {
            System.out.println((constructor));
        }
        Method[] methods = test.getDeclaredMethods();
        for (var method : methods) {
            if (method.getModifiers() == 2) {
                method.setAccessible(true);
                method.invoke(employee, 200);
            }
        }
        System.out.println(employee.getSalary());
        var constructorNode = (Employee) constructors[0].newInstance("employee", 2000, 1999, 4, 23);
        System.out.println(constructorNode);

        Scanner input = new Scanner(System.in);
        int inputInt = input.nextInt();
        System.out.println(inputInt);
        var line = input.nextLine();
        System.out.println(line);
    }
}