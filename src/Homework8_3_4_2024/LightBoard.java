package Homework8_3_4_2024;

public class LightBoard{
    private boolean[][] lights;

    public LightBoard(int rows, int columns){
        lights = new boolean[rows][columns];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                lights[i][j] = Math.random() < 0.4;
            }
        }
    }

    public boolean evaluateLight(int row, int column){
        if(lights[row][column]){
        int count = 0;
        for(int i = 0; i < lights.length; i++){
            if(lights[i][column]){
                count++;
            }
        }
        if(count % 2 == 0){
            return false;
        }
    } else{
        int count = 0;
        for(int i = 0; i < lights[0].length; i++){
            if(lights[row][i]){
                count++;
            }
        }
        if(count % 3 == 0){
            return true;
        }
    }
    return lights[row][column];
    }
}
