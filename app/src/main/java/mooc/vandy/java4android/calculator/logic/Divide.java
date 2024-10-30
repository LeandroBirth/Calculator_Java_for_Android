package mooc.vandy.java4android.calculator.logic;

import java.text.DecimalFormat;

public class Divide implements Operation {
    @Override
    public double performOperation(double argumentOne, double argumentTwo) {
        if (argumentTwo == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        }

        double result = argumentOne / argumentTwo;

        // Format the result to two decimal places
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        return Double.parseDouble(decimalFormat.format(result));
    }
}


