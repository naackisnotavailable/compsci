package Homework8_3_4_2024;

public class TemperatureGrid {
    private double[][] temps;
    private double computeTemp(int row, int col){
        double sum = 0;
        int count = 0;
        for(int i = row - 1; i <= row + 1; i++){
            for(int j = col - 1; j <= col + 1; j++){
                if(i >= 0 && i < temps.length && j >= 0 && j < temps[0].length){
                    sum += temps[i][j];
                    count++;
                }
            }
        }
        return sum / count;
    }

    public boolean updateAllTemps(double tolerance){
        double[][] newTemps = new double[temps.length][temps[0].length];
        boolean changed = false;
        for(int i = 0; i < temps.length; i++){
            for(int j = 0; j < temps[0].length; j++){
                newTemps[i][j] = computeTemp(i, j);
                if(Math.abs(newTemps[i][j] - temps[i][j]) > tolerance){
                    changed = true;
                }
            }
        }
        temps = newTemps;
        return changed;
    }
}
