package mooc.vandy.java4android.calculator.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

import mooc.vandy.java4android.calculator.R;
import mooc.vandy.java4android.calculator.logic.Logic;
import mooc.vandy.java4android.calculator.logic.LogicInterface;

public class MainActivity extends Activity implements ActivityInterface {
    private Spinner mMathSpinner;
    private EditText mValueOne;
    private EditText mValueTwo;
    private TextView mResult;
    private LogicInterface mLogic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initializeUI();
        mLogic = new Logic(this);
    }

    private void initializeUI() {
        setContentView(R.layout.activity_main);
        mValueOne = findViewById(R.id.valueOneEditText);
        mValueTwo = findViewById(R.id.valueTwoEditText);
        mMathSpinner = findViewById(R.id.mathSpinner);
        mResult = findViewById(R.id.results);

        ArrayAdapter<CharSequence> mAdapter = ArrayAdapter.createFromResource(this,
                R.array.math_options, R.layout.spinner_item);
        mAdapter.setDropDownViewResource(R.layout.spinner_item);
        mMathSpinner.setAdapter(mAdapter);
        mMathSpinner.setSelection(0);
    }

    public void buttonPressed(View view) {
        final int operation = getOperationNumber();
        double argOne, argTwo;

        try {
            argOne = getValueOne();
        } catch (Exception e) {
            Toast.makeText(this, "First value cannot be blank", Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            argTwo = getValueTwo();
        } catch (Exception e) {
            Toast.makeText(this, "Second value cannot be blank", Toast.LENGTH_SHORT).show();
            return;
        }

        mLogic.process(argOne, argTwo, operation);
    }

    @Override
    public double getValueOne() {
        return Double.parseDouble(mValueOne.getText().toString());
    }

    @Override
    public double getValueTwo() {
        return Double.parseDouble(mValueTwo.getText().toString());
    }

    @Override
    public int getOperationNumber() {
        return Arrays.asList(getResources()
                        .getStringArray(R.array.math_options))
                .indexOf(mMathSpinner.getSelectedItem().toString()) + 1;
    }

    @Override
    public void print(String resultString) {
        mResult.setText(resultString);
    }
}
