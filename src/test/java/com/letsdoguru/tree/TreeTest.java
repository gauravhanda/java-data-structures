package com.letsdoguru.tree;

import com.letsdoguru.model.Employee;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TreeTest {
    private List<Employee> employees;

    @Before
    public void setup() {
        employees = Arrays.asList(new Employee("Gaurav", (byte) 41),
                new Employee("Gaurav-Child", (byte) 12),
                new Employee("Gaurav-Spouse", (byte) 40));
    }

    @Test
    public void sortEmployeesByAge() {
        BinaryTree<Employee> employeeBinaryTree = new BinaryTree<>((emp1, emp2) -> emp1.getAge() <= emp2.getAge() ? -1 : 1);
        employees.stream().forEach(employeeBinaryTree::addNode);
        employeeBinaryTree.print(BinaryTree.TraversalType.IN_ORDER);
    }
}
