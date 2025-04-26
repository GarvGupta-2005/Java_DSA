package BinarySearch.two_D_Matrix;

public class medianInMatrix {
//     What is the search space where we will apply binary search?

// If we carefully observe, our answer lies between the smallest and the largest number in the given matrix. So, the search space will be [min(matrix), max(matrix)].
// While applying binary search how to check if an element ‘x’ is a possible median?

// If ‘x’ is the median, the number of elements smaller or equal to ‘x’ will be surely greater than (MXN) // 2 (integer division).
// How to check how many numbers are smaller or equal to an element ‘mid’?

// One of the ways is to traverse the whole matrix and count the numbers. But in that case, the time complexity will be high. So, we have to find other ways. It is given that the matrix is row-wise sorted. So, we can apply the concept of upper bound
// For every particular row, we will find the upper bound of the current element ‘mid’. The index returned will be the number of smaller or equal elements in that row.
// We will do it for each row and add them to get the total number for the whole matrix.
// Mathematically, smaller_equal_in_row = upperBound(matrix[row], mid)
// We will just convert the above observation into code.

// Algorithm:

// Calculate min(matrix) and max(matrix): As the given matrix is row-wise sorted the minimum element will be the minimum element in the first column and the maximum will be the maximum in the last column.
// Place the 2 pointers low and high: Initially, we will place the pointers. The pointer low will point to min(matrix) and the high will point to max(matrix).
// Calculate the ‘mid’: Now, inside a loop, we will calculate the value of ‘mid’ using the following formula: mid = (low+high) // 2 ( ‘//’ refers to integer division)
// Use the calculateSmallEqual() function to get the number of elements <= mid: Inside the function, we will use the above-mentioned upper bound formula for each row and calculate the total number of elements <= mid. Then we will return the total number from the function calculateSmallEqual().
// If smallEqual <= (M*N) // 2: We can conclude that our median must be a bigger number. So, we will eliminate the left i.e. the smaller half (low = mid+1).
// If smallEqual > (M*N) // 2: We can conclude that the element mid might be the median. But we have to reach the smallest number to find the actual median. So, in this case, we will remove the right half( i.e. high = mid-1).
static int upperBound(int[] arr, int x, int n) {
    int low = 0, high = n - 1;
    int ans = n;

    while (low <= high) {
        int mid = (low + high) / 2;
        // maybe an answer
        if (arr[mid] > x) {
            ans = mid;
            // look for a smaller index on the left
            high = mid - 1;
        } else {
            low = mid + 1; // look on the right
        }
    }
    return ans;
}

static int countSmallEqual(int[][] matrix, int m, int n, int x) {
    int cnt = 0;
    for (int i = 0; i < m; i++) {
        cnt += upperBound(matrix[i], x, n);
    }
    return cnt;
}

static int median(int[][] matrix, int m, int n) {
    int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

    // point low and high to right elements
    for (int i = 0; i < m; i++) {
        low = Math.min(low, matrix[i][0]);
        high = Math.max(high, matrix[i][n - 1]);
    }

    int req = (n * m) / 2;
    while (low <= high) {
        int mid = (low + high) / 2;
        int smallEqual = countSmallEqual(matrix, m, n, mid);
        if (smallEqual <= req) low = mid + 1;
        else high = mid - 1;
    }
    return low;
}

}
