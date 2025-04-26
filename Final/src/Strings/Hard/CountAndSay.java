package Strings.Hard;


public class CountAndSay {
    //In this proble we have to see how many times a number will repeat and we have to give a string as answer containing a count and number 
    //for instance if we have n = 4  first n = 1 so the answer will be "1" then in n = 2 we will have '11' then in n = 3 we will have "21"

    public static  String countAndSay(int n) {
        if(n==1){
            return "1";
        }

        String say = countAndSay(n-1);
        
        //Processing

        StringBuilder res = new StringBuilder("");

        for(int i = 0;i<say.length();i++){
            char ch = say.charAt(i);
            int count = 1;
            while(i<say.length()-1 && say.charAt(i) == say.charAt(i+1)){
                count++;
                i++;
            }
            res.append(count);
            res.append(ch);
        }
        return res.toString();
    }
}
