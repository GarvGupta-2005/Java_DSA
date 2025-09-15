public class MinStepsGeneral {

    // Utility function: gcd using Euclid's algorithm
    private static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Extended Euclidean Algorithm
    // Returns {x, y, g} such that a*x + b*y = g where g = gcd(a, b)
    private static int[] extendedGcd(int a, int b) {
        if (b == 0) return new int[]{1, 0, a};
        int[] vals = extendedGcd(b, a % b);
        int x1 = vals[0], y1 = vals[1], g = vals[2];
        int x = y1;
        int y = x1 - (a / b) * y1;
        return new int[]{x, y, g};
    }

    /**
     * General solver:
     * Operations: +p and -q
     * Start -> Target
     * Equation: p*a - q*b = d  (d = target - start)
     */
    public static int minSteps(int start, int target, int p, int q) {
        int d = target - start;

        // Step 1: gcd check
        int g = gcd(p, q);
        if (d % g != 0) {
            // No integer solution exists
            return -1;
        }

        // Step 2: find one particular solution (a0, b0) using Extended Euclid
        int[] eg = extendedGcd(p, q);
        int x = eg[0], y = eg[1];
        // Now: p*x + q*y = g
        // But we want: p*a - q*b = d
        // Trick: replace q with -q → equation becomes p*a + (-q)*b = d
        // So scale solution:
        x *= d / g;
        y *= d / g;

        // Particular solution:
        int a0 = x;     // candidate for number of +p steps
        int b0 = -y;    // candidate for number of -q steps (note the sign!)

        // Step 3: general solution
        // a = a0 + (q/g)*t
        // b = b0 + (p/g)*t
        int stepA = q / g;
        int stepB = p / g;

        // Step 4: find smallest t making a >= 0 and b >= 0
        int tMin = 0;

        if (stepA != 0) {
            double tNeeded = (-1.0 * a0) / stepA;
            tMin = (int) Math.ceil(tNeeded);
        }
        if (stepB != 0) {
            double tNeeded = (-1.0 * b0) / stepB;
            tMin = Math.max(tMin, (int) Math.ceil(tNeeded));
        }

        // Shift solution by tMin
        int a = a0 + stepA * tMin;
        int b = b0 + stepB * tMin;

        // Now both should be >= 0
        if (a < 0 || b < 0) {
            return -1; // Just in case: if still invalid, no non-negative solution
        }

        // Total steps = a + b
        return a + b;
    }

    public static void main(String[] args) {
        // Classic case (+3, -2)
        System.out.println(minSteps(5, 14, 3, 2)); // 3

        // Example (+2, -1)
        System.out.println(minSteps(3, 10, 2, 1)); // 14

        // Case with no solution (gcd test fails)
        System.out.println(minSteps(0, 7, 4, 6));  // -1
    }
}
