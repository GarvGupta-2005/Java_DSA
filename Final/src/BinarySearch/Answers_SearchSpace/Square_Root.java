package BinarySearch.Answers_SearchSpace;
public class Square_Root {
    public static int sqrtN(long N) {
		/*
		 * Write your code here
		 */
		long low = 1, high = N;
        //Binary search on the answers:
        while (low <= high) {
            long mid = (low + high) / 2;
            long val = mid * mid;
            if (val <= N) {
                //eliminate the left half:
                low = (mid + 1);
            } else {
                //eliminate the right half:
                high = (mid - 1);
            }
        }
        return (int)high;
	}
}
