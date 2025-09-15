public class MinStepsTOConvertNumberToTarget {

    /**
     * Problem recap:
     * You can change a number by either +3 or -2 in one step.
     * Given start and target, find the minimum number of steps to reach target from start.
     *
     * Mathematical model:
     * Let a = number of +3 steps, b = number of -2 steps.
     * Then: start + 3a - 2b = target  =>  3a - 2b = d   (where d = target - start)
     *
     * We want integer solutions with a >= 0, b >= 0 and minimize a + b.
     *
     * Key observations (used in code):
     * 1) A particular integer solution is a0 = d, b0 = d because 3d - 2d = d.
     * 2) The homogeneous solutions of 3x - 2y = 0 are of the form (x, y) = (2t, 3t)
     *    because 3*(2t) - 2*(3t) = 0.
     * 3) So the general integer solution is:
     *       a = d + 2t
     *       b = d + 3t
     *    for any integer t.
     * 4) To make a,b non-negative we need:
     *       d + 2t >= 0  => t >= -d/2
     *       d + 3t >= 0  => t >= -d/3
     *    So feasible t >= max( -d/2, -d/3 ). Since t must be integer we take ceiling.
     * 5) The total steps = a + b = (d + 2t) + (d + 3t) = 2d + 5t.
     *    This is linear and increases with t, so the minimal total is achieved by the smallest feasible t.
     *
     * Edge notes:
     * - We use Math.ceil on (-d / 2.0) and (-d / 3.0) to correctly handle negative/positive d.
     * - For extremely large values prefer 'long' to avoid overflow; this implementation uses int for clarity.
     */

    public static int minSteps(int start, int target) {
        // d is the net amount we need to add to start to reach target.
        // Positive d means we need a net increase; negative d means net decrease.
        int d = target - start;

        // If no net change needed, 0 steps.
        if (d == 0) return 0;

        /*
         * Compute the smallest integer t that satisfies both:
         *    t >= -d/2   and   t >= -d/3
         *
         * We compute ceilings of these real values. Use double division to avoid
         * integer-truncation pitfalls when d is odd or negative.
         *
         * Example (d = -7): -d/2.0 = 3.5 -> ceil = 4
         *                   -d/3.0 = 7/3 -> 2.333.. -> ceil = 3
         *    tMin = max(4, 3) = 4
         */
        int tLowerBoundFromA = (int) Math.ceil(-d / 2.0); // corresponds to a >= 0 constraint
        int tLowerBoundFromB = (int) Math.ceil(-d / 3.0); // corresponds to b >= 0 constraint
        int tMin = Math.max(tLowerBoundFromA, tLowerBoundFromB);

        /*
         * Using tMin we can compute a and b:
         *    a = d + 2*tMin  (number of +3 steps)
         *    b = d + 3*tMin  (number of -2 steps)
         *
         * They should be non-negative by construction.
         */
        int a = d + 2 * tMin;
        int b = d + 3 * tMin;

        // Defensive check: rounding or unexpected corner cases shouldn't occur, but handle just in case.
        // If either is negative (due to some numeric edge-case), adjust t upward until non-negative.
        if (a < 0 || b < 0) {
            while (a < 0 || b < 0) {
                tMin++;
                a = d + 2 * tMin;
                b = d + 3 * tMin;
            }
        }

        // total steps is the sum of the +3 steps and -2 steps
        int totalSteps = a + b;

        // (Optional) sanity: totalSteps equals formula 2*d + 5*tMin
        // int checkTotal = 2 * d + 5 * tMin; // should equal totalSteps

        return totalSteps;
    }

    public static void main(String[] args) {
        // Example runs (printed results explained below):
        System.out.println(minSteps(5, 14));  // expected 3  (3 * +3)
        System.out.println(minSteps(8, 1));   // expected 6  (example from chat: result was 6)
        System.out.println(minSteps(10, 10)); // expected 0  (already equal)

        // Walkthrough example in plain terms:
        // start = 8, target = 1 => d = -7
        // t1 = ceil(-d/2) = ceil(7/2) = 4
        // t2 = ceil(-d/3) = ceil(7/3) = 3
        // tMin = max(4,3) = 4
        // a = d + 2*tMin = -7 + 8 = 1  (one +3)
        // b = d + 3*tMin = -7 + 12 = 5 (five -2)
        // total steps = a + b = 1 + 5 = 6
        // Sequence example: 8 -> 11 (+3) -> 9 (-2) -> 7 -> 5 -> 3 -> 1 (five -2 after first +3)
    }
}
