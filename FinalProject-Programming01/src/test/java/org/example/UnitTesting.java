package org.example;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class UnitTesting {
    @Test
    public void testIsPostalCodeValid() {
        Address address = new Address(1908, "Dudemaine", "Montreal", "Quebec", "J4V4N5", "Canada");
        assertTrue(address.isPostalCodeValid("J4V4N5"));

        Address addressInvalid = new Address(1853, "Henri-Bourrassa", "Montreal", "Quebec", "4J5B6V", "Albania");
        assertFalse(addressInvalid.isPostalCodeValid("4J5B6V"));
    }
    @Test
    public void testCalcAssignmentAvg() {
        Assignment assignment = new Assignment("Math Exam", 0.25, 100);
        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80, 90, 100, 70));
        assignment.setScores(scores);
        assignment.calcAssignmentAvg();
        assertEquals(85.0, assignment.getAssignmentAverage(), 0.01);
    }
    @BeforeAll
    public static void setUp() {
        Department  department = new Department("Computer Science");
        Course course = new Course("Programming 1", 3.0, department);
    }

    @Test
    public void testIsAssignmentWeightValid_ValidWeights() {
        Course.addAssignment("Assignment 1", 0.3, 100);
        Course.addAssignment("Assignment 2", 0.4, 100);
        Course.addAssignment("Final Exam", 0.3, 100);

        assertTrue(Course.isAssignmentWeightValid());
    }

    @Test
    public void testIsAssignmentWeightValid_InvalidWeights() {
        Course.addAssignment("Assignment 1", 0.3, 100);
        Course.addAssignment("Assignment 2", 0.5, 100);
    }
    @BeforeAll
    public static void setUp2() {
        Department department = new Department("Computer Science");
        Course course = new Course("Programming 1", 3.0, department);

        Address address = new Address(123, "Main St", "Anytown", "ON", "A1B2C3", "Canada");

        Student student1 = new Student("Alice", Gender.FEMALE, address, department);
        Student student2 = new Student("Bob", Gender.MALE, address, department);

        Course.registerStudent(student1);
        Course.registerStudent(student2);
    }

    @Test
    public void testCalcStudentsAverage() {

        ArrayList<Integer> scores = new ArrayList<>(Arrays.asList(80,90,70));

        Assignment assignment1 = new Assignment("Assignment 1", 0.3, 100, scores);
        Assignment assignment2 = new Assignment("Assignment 2", 0.4, 100, scores);
        Assignment finalExam = new Assignment("Final Exam", 0.3, 100,scores);

        assignment1.calcAssignmentAvg();
        System.out.println(assignment1);

        Course.getAssignments().add(assignment1);
        Course.getAssignments().add(assignment2);
        Course.getAssignments().add(finalExam);

        int[] calculatedAverage = {80, 90};
        int[] expectedAverages = {80, 90};
        int[] calculatedAverages = Course.calcStudentsAverage();

        assertArrayEquals(expectedAverages, calculatedAverage);
    }
    @Test
    public void testToTitleCase(){
        assertEquals("Yi Wang", Util.toTitleCase("yi wang"));
        assertEquals("Computer Science", Util.toTitleCase("computer science"));
        assertEquals("Hello World", Util.toTitleCase("hello world"));
        assertEquals("Java Programming", Util.toTitleCase("java programming"));
        assertEquals("Test", Util.toTitleCase("test"));
        assertEquals("A", Util.toTitleCase("a"));
        assertEquals("", Util.toTitleCase(""));
        assertEquals("Multiple   Spaces", Util.toTitleCase("multiple   spaces"));
        assertNull(Util.toTitleCase(null));
    }
}

