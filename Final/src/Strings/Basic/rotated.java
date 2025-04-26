package Strings.Basic;

public class rotated {
    
        public static boolean rotateString(String s, String goal) {
            StringBuilder sb = new StringBuilder("");
            String rotated = "";
            for(int i = 1;i<=s.length();i++){
            sb.append(s.substring(i));
            sb.append(s.substring(0,i));
            rotated = sb.toString();
            if(rotated.equals(goal)){
                return true;
            }else{
                sb.setLength(0);
                rotated = "";
            }
            }
            return false;
        }
    
}
