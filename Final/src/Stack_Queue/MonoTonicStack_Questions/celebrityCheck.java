package Stack_Queue.MonoTonicStack_Questions;

public class celebrityCheck {
    //The brute way is to traverse the whole matrix and see if a row is entirely zero indicating this person knows nobody
    //But this is not optimal as it takes O(n*m)

    //The more optimal way is go on each row and go each row and column simultaneously
    //Let top be the first person and down be the last person then check corrspondingl whether top and down each other if nyes then incremnet and decrement accordingly
    //when the top==down;If the whole column is full of 1 except the row of that number and that row is full of zeroes 
    //indicating everybody knows that column person but that person knows nobody so that row number is our answer
    public int celebrity(int mat[][]) {
        // code here
        int top = 0;
        int down = mat.length-1;
        while(top<down){
            if(mat[top][down] == 1){
                top++; //Top knows somebody therefore he is not celeb thus increment
            }
            else if(mat[down][top]==1){
                down--; //Down knows somebode therefore decrement
            }else{
                top++; //He might be a celeb
                down--;
            }
        }
        if(top>down){ 
            return -1;
        }
        for(int i = 0;i<mat[0].length;i++){
            if(i == top){
                continue;
            }
            if(mat[top][i] == 0 && mat[i][top]==1){ //checking the row for top and column 
            }else{   
                return -1;
            }
        }
        return top;
    }

}
