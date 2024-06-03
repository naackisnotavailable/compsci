package Homework7_1_29_2024;

import java.util.ArrayList;
import java.util.List;

public class ClimbingClub {
    private List<ClimbInfo> climbList;

    public ClimbingClub() {
        climbList = new ArrayList<>();
    }

    public void addClimb(String name, int time) {
        ClimbInfo climbInfo = new ClimbInfo(name, time);
        climbList.add(climbInfo);
    }
    
    
}
