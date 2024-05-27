package org.example;
import java.util.ArrayList;

public class Course {
    private String courseId;
    private String courseName;
    private double credits;
    private Department department;
    private static ArrayList<Assignment> assignments;
    private static ArrayList<Student> registeredStudents;
    private static ArrayList<Double> finalScores;
    private static int nextId = 1;

    public Course(String courseName, double credits, Department department) {
        this.courseName = courseName;
        this.credits = credits;
        this.department = department;
        this.courseId = generateCourseId();
        this.assignments = new ArrayList<>();
        this.registeredStudents = new ArrayList<>();
        this.finalScores = new ArrayList<>();
    }

    private String generateCourseId() {
        String id = "C-" + department.getDepartmentId() + "-" + Integer.toString(nextId++);
        return id;
    }

    public static boolean isAssignmentWeightValid() {
        double totalWeight = 0;
        for (Assignment assignment : assignments) {
            totalWeight += assignment.getWeight();
        }
        return totalWeight == 1;
    }

    public static boolean registerStudent(Student student) {
        if (registeredStudents.contains(student)) {
            return false;
        }
        registeredStudents.add(student);
        for (Assignment assignment : assignments) {
            assignment.getScores().add(null);
        }
        finalScores.add(null);
        return true;
    }
    public void removeStudent(Student student) {
        int index = registeredStudents.indexOf(student);
        if (index != -1) {
            registeredStudents.remove(index);
            for (Assignment assignment : assignments) {
                assignment.getScores().remove(index);
            }
            finalScores.remove(index);
        }
    }

    public static int[] calcStudentsAverage() {
        int[] averages = new int[registeredStudents.size()];

        for (int i = 0; i < registeredStudents.size(); i++) {
            double totalWeightedScore = 0;
            double totalWeight = 0;

            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                if (score != null) {
                    totalWeightedScore += score * assignment.getWeight();
                    totalWeight += assignment.getWeight();
                }
            }

            if (totalWeight > 0) {
                averages[i] = (int) Math.round(totalWeightedScore / totalWeight);
            } else {
                averages[i] = 0;
            }
        }

        return averages;
    }

    public static boolean addAssignment(String assignmentName, double weight, int maxScore) {
        if (weight <= 0 || weight > 1) {
            return false;
        }
        assignments.add(new Assignment(assignmentName, weight, maxScore));
        for (Student student : registeredStudents) {
            assignments.get(assignments.size() - 1).getScores().add(null);
        }
        return true;
    }

    public void generateScores() {
        for (Assignment assignment : assignments) {
            assignment.generateRandomScore();
        }
        calcFinalScores();
    }

    private void calcFinalScores() {
        for (int i = 0; i < registeredStudents.size(); i++) {
            double totalScore = 0;
            for (Assignment assignment : assignments) {
                if (assignment.getScores().get(i) != null) {
                    totalScore += assignment.getScores().get(i) * assignment.getWeight();
                }
            }
            finalScores.set(i, totalScore);
        }
    }

    public void displayScores() {
        System.out.println("Course: " + courseName + " (" + courseId + ")");
        System.out.print("           ");
        for (Assignment assignment : assignments) {
            System.out.print(assignment.getAssignmentName() + "   ");
        }
        System.out.println("Final Score");
        for (int i = 0; i < registeredStudents.size(); i++) {
            Student student = registeredStudents.get(i);
            System.out.print(student.getStudentName() + "   ");
            for (Assignment assignment : assignments) {
                Integer score = assignment.getScores().get(i);
                System.out.print((score != null ? score : "N/A") + "             ");
            }
            System.out.println(finalScores.get(i));
        }
        System.out.print("Average   ");
        for (Assignment assignment : assignments) {
            System.out.print(assignment.getAssignmentAverage() + "             ");
        }
        System.out.println();
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseId='" + courseId + '\'' +
                ", courseName='" + courseName + '\'' +
                ", credits=" + credits +
                ", department=" + department +
                '}';
    }

    public boolean equals(Course o) {
        if (courseId.equals(o.courseId) && courseName.equals(o.courseName) && credits == o.credits
                && department.equals(o.department) && assignments.equals(o.assignments) && registeredStudents.equals(o.registeredStudents)
                && finalScores.equals(finalScores)) {
            return true;
        } else {
            return false;
        }
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public double getCredits() {
        return credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public static ArrayList<Assignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(ArrayList<Assignment> assignments) {
        this.assignments = assignments;
    }

    public ArrayList<Student> getRegisteredStudents() {
        return registeredStudents;
    }

    public void setRegisteredStudents(ArrayList<Student> registeredStudents) {
        this.registeredStudents = registeredStudents;
    }

    public ArrayList<Double> getFinalScores() {
        return finalScores;
    }

    public void setFinalScores(ArrayList<Double> finalScores) {
        this.finalScores = finalScores;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Course.nextId = nextId;
    }
}
