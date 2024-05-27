package org.example;

public class Department {
    private String departmentId;
    private String departmentName;
    private static int nextId = 1;

    public Department(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentName = departmentName;
            this.departmentId = generateDepartmentId();
        } else {
            this.departmentId = null;
            this.departmentName = null;
        }
    }

    public static boolean validateDepartmentName(String departmentName) {
        if (departmentName == null) {
            return false;
        }
        for (char c : departmentName.toCharArray()) {
            if (!Character.isLetter(c) && c != ' ') {
                return false;
            }
        }
        return true;
    }

    private String generateDepartmentId() {
        String id = "D" + (nextId < 10 ? "0" : "") + nextId;
        nextId++;
        return id;
    }

    public String toString() {
        return "Department " +
                "departmentId: " + departmentId + " " +
                "departmentName: " + departmentName;
    }

    public boolean equals(Department o){
        if (departmentId.equals(o.departmentId) && departmentName.equals(o.departmentName)) {
            return true;
        } else {
            return false;
        }
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        if (validateDepartmentName(departmentName)) {
            this.departmentName = departmentName;
        }
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Department.nextId = nextId;
    }
}
