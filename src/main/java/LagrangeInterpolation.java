public class LagrangeInterpolation {


    public static double lagrangeInterpolation(double[] xPoints, double[] yPoints, double x) {
        if (xPoints.length != yPoints.length) {
            throw new IllegalArgumentException("xPoints and yPoints must have the same length.");
        }

        int n = xPoints.length;
        double y = 0;

        // Iterate through each data point
        for (int i = 0; i < n; i++) {
            double L = 1;

            // Calculate the Lagrange basis polynomial L_i(x)
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    L *= (x - xPoints[j]) / (xPoints[i] - xPoints[j]);
                }
            }

            // Add the contribution of this term to the result
            y += yPoints[i] * L;
        }

        return y;
    }

    public static void main(String[] args) {
        double[] xValues = { 3, 5, 7, 9};
        double[] yValues = { 180, 150, 120, 90};
        double xToInterpolate = 4;

        double result = lagrangeInterpolation(xValues, yValues, xToInterpolate);
        System.out.println("Interpolated value at x = " + xToInterpolate + " is: " + result);
    }
}