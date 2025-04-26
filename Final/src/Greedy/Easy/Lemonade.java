package Greedy.Easy;

public class Lemonade {
    public static boolean lemonadeChange(int[] bills) {
        int five = 0;//To keep the count of five dollar bills
        int ten = 0;//If we get a 10 dollar bill then we have to return a 5 dollar bill or false
        //for twenty we either return one 10 and 1 five or three 10 dollar bills
        
        for(int i = 0; i<bills.length;i++){
            switch (bills[i]) {
                case 5:
                    five++;
                    break;
                case 10:
                    if(five <= 0){
                        return false;
                    }   ten++;
                    five--;
                    break;
                default:
                    if(five>0 && ten>0){
                        five--;
                        ten--;
                    }else if(five>=3){
                        five = five-3;
                    }else{
                        return false;
                    }   break;
            }
        }
        return true;
        
            }
}
