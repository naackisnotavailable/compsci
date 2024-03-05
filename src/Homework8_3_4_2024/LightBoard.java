package Homework8_3_4_2024;
    /**
     * Represents a light board with a specified number of rows and columns.
     * Each light on the board can be either on or off.
     */
    public class LightBoard {
        private boolean[][] lights;

        /**
         * Constructs a LightBoard object with the specified number of rows and columns.
         * Each light on the board is randomly set to be on or off.
         *
         * @param rows    the number of rows on the light board
         * @param columns the number of columns on the light board
         */
        public LightBoard(int rows, int columns) {
            lights = new boolean[rows][columns];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    lights[i][j] = Math.random() < 0.4;
                }
            }
        }

    /**
     * Evaluates the state of a light at the specified row and column.
     * 
     * @param row    the row index of the light
     * @param column the column index of the light
     * @return true if the light is on, false if the light is off
     */
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
