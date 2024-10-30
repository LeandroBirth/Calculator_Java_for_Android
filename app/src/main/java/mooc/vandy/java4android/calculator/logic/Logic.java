package mooc.vandy.java4android.calculator.logic;

import mooc.vandy.java4android.calculator.ui.ActivityInterface;

public class Logic implements LogicInterface {
    protected ActivityInterface mOut;

    public static final int ADDITION = 1;
    public static final int SUBTRACTION = 2;
    public static final int MULTIPLICATION = 3;
    public static final int DIVISION = 4;

    public Logic(ActivityInterface out) {
        mOut = out;
    }

    @Override
    public void process(double argumentOne, double argumentTwo, int operation) {
        Operation selectedOperation = null;

        switch (operation) {
            case ADDITION:
                selectedOperation = new Add();
                break;
            case SUBTRACTION:
                selectedOperation = new Subtract();
                break;
            case MULTIPLICATION:
                selectedOperation = new Multiply();
                break;
            case DIVISION:
                selectedOperation = new Divide();
                break;
            default:
                mOut.print("Invalid operation selected.");
                return;
        }

        try {
            double result = selectedOperation.performOperation(argumentOne, argumentTwo);
            mOut.print("The result is: " + result);
        } catch (ArithmeticException e) {
            mOut.print(e.getMessage());
        }
    }

}
