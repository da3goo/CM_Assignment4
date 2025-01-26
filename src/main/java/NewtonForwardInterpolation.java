public class NewtonForwardInterpolation {


    public static double newtonForwardInterpolation(double[] xValues, double[] yValues, double xToInterpolate) {
        int n = xValues.length;
        double h = xValues[1] - xValues[0];  // Height between values
        double[][] diffTable = new double[n][n];  // Creates n by n table

        // Filling the first column Δ f(x)
        for (int i = 0; i < n; i++) {
            diffTable[i][0] = yValues[i];
        }

        // Calculate forward differences Δ2 f(x), Δ3 f(x), ...
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                diffTable[i][j] = diffTable[i + 1][j - 1] - diffTable[i][j - 1];
            }
        }

        // Calculate p
        double p = (xToInterpolate - xValues[0]) / h;  // p = (x - x0) / height

        // Newton's formula
        double yInterpolated = yValues[0];
        double pTerm = 1;  // The current p term in the formula: p(p-1)(p-2).../(n!)
        for (int j = 1; j < n; j++) {
            pTerm *= (p - (j - 1)) / j;
            yInterpolated += pTerm * diffTable[0][j];
        }

        return yInterpolated;
    }

    public static void main(String[] args) {
        double[] xValues = { 3, 5, 7, 9};
        double[] yValues = { 180, 150, 120, 90};
        double xToInterpolate = 4;

        double result = newtonForwardInterpolation(xValues, yValues, xToInterpolate);
        System.out.println("Interpolated value at x = " + xToInterpolate + " is: " + result);
    }
}
