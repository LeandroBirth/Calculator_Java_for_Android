package mooc.vandy.java4android.calculator.logic;

public class Multiply implements Operation {
    @Override
    public double performOperation(double argumentOne, double argumentTwo) {
        return argumentOne * argumentTwo;
    }
}
