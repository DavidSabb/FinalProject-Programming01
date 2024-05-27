package org.example;
import java.util.ArrayList;
import java.util.Random;

public class Assignment {
    private String assignmentId;
    private String assignmentName;
    private double weight;
    private int maxScore;
    private double assignmentAverage;
    private ArrayList<Integer> scores;
    private static int nextId = 1;

    public Assignment(String assignmentName, double weight, int maxScore) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.assignmentId = generateAssignmentId();
        this.scores = new ArrayList<>();
    }
    public Assignment(String assignmentName, double weight, int maxScore, ArrayList<Integer> scores) {
        this.assignmentName = assignmentName;
        this.weight = weight;
        this.maxScore = maxScore;
        this.assignmentId = generateAssignmentId();
        this.scores = scores;
    }

    private String generateAssignmentId() {
        String id = "A" + Integer.toString(nextId++);
        return id;
    }

    public void calcAssignmentAvg() {
        if (scores.isEmpty()) {
            assignmentAverage = 0;
            return;
        }
        double sum = 0;
        for (int score : scores) {
            sum += score;
        }
        assignmentAverage = sum / scores.size();
    }

    public void generateRandomScore() {
        Random random = new Random();
        scores.clear();
        for (int i = 0; i < 100; i++) { // Assuming 100 students for example
            int randNum = random.nextInt(11);
            int score;
            if (randNum == 0) {
                score = random.nextInt(60);
            } else if (randNum <= 2) {
                score = 60 + random.nextInt(10);
            } else if (randNum <= 4) {
                score = 70 + random.nextInt(10);
            } else if (randNum <= 8) {
                score = 80 + random.nextInt(10);
            } else {
                score = 90 + random.nextInt(11);
            }
            scores.add(score);
        }
        calcAssignmentAvg();
    }

    public String toString() {
        return "Assignment: " +
                "assignmentId: " + assignmentId + " " +
                "assignmentName: " + assignmentName + " " +
                "weight: " + weight + " " +
                "maxScore: " + maxScore + " " +
                "assignmentAverage: " + assignmentAverage;
    }
    public String getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(String assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentName() {
        return assignmentName;
    }

    public void setAssignmentName(String assignmentName) {
        this.assignmentName = assignmentName;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getMaxScore() {
        return maxScore;
    }

    public void setMaxScore(int maxScore) {
        this.maxScore = maxScore;
    }

    public double getAssignmentAverage() {
        return assignmentAverage;
    }

    public void setAssignmentAverage(double assignmentAverage) {
        this.assignmentAverage = assignmentAverage;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void setScores(ArrayList<Integer> scores) {
        this.scores = scores;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        Assignment.nextId = nextId;
    }
}
