package Math.Advance;

public class powerExponentiation {
    // the brute solution is to multiply the number n times unitl we rach the power
    // this will lead to a time complexity of O(N) which can be very large for large n 

    //This can be optimized by dividing the powers by 2 and multiplying the number with itself
    //for example 2^21 = 2*2^20 , now ans = 1*2 , 2^20 = (2^2)^10 = 4^10  = (4^2)^5 = 16^5
    //Now 16^5 = 16*16^4 thus ans = 1*2*16 and 16^4 = (16^2)^2 = 256^2 = 65536

        public double myPow(double x, int n) {
            double ans = 1.0;
            long nn = n;
            if(nn<0) nn = -1*nn;
            while(nn>0){
                if(nn%2==1){
                    ans = ans*x; // If the power is odd then multiply the number with the answer
                    nn = nn-1;   //Reduce the power by 1 to make it even
                }else{
                    x = x*x; // If the power is even then multiply the number with itself
                    nn = nn/2; //Power becomes half in this step 
                }
            }
            if(n<0){
                ans = (double)(1.0)/(double)(ans);
            }
            return ans;
        }
    }

