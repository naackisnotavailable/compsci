package Homework7_1_29_2024;

public class ClimbInfo {
    private String peakName;
    private int climbingTime;

    /**
     * Represents information about a climbing event.
     */
    public ClimbInfo(String peakName, int climbingTime) {
        this.peakName = peakName;
        this.climbingTime = climbingTime;
    }

    public String getPeakName() {
        return peakName;
    }

    public int getClimbingTime() {
        return climbingTime;
    }
}
    
