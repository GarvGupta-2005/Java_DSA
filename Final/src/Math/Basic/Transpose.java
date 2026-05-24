public void transpose(int [][] array){
        int row = array.length;
        int column = array[0].length;
        for(int i = 0 ; i < row ; i++){
            for(int j = i ; j< column ; j++){
                if(i!=j){
                    int temp = array[i][j];
                    array[i][j] = array[j][i];
                    array[j][i] = temp;
                }
            }
        }
    
    }
