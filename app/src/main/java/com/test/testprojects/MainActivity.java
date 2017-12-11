package com.test.testprojects;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private StringBuilder m_operand1 = new StringBuilder();
    private StringBuilder m_operand2 = new StringBuilder();
    private Calculator    m_calculator = new Calculator();
    private int m_isEqual = 0;
    private final View.OnClickListener onClickListenerOperation = new View.OnClickListener()
    {
        @Override
        public void onClick(View view){
            if((view.getId() != R.id.viewEqual) && (m_isEqual == -1) && (view.getId() != R.id.viewDel)){
                return;
            }
            switch (view.getId()){
                case R.id.viewEqual:
                    if(m_operand2.length() == 0){
                        return;
                    }
                    if(Double.parseDouble(m_operand2.toString()) == 0 && m_calculator.getCurrentOperaton().equals("/")){
                        Toast toast = Toast.makeText(MainActivity.this, "division by zero", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();
                        textView.setText("");
                        textResult.setText("");
                    } else {
                        m_calculator.enterNumber(m_operand2.toString());
                        String result = m_calculator.calculate();
                        if(result.endsWith(".0")){
                            result = result.replace(".0", "");
                        }
                        textResult.setText(result);
                    }
                    m_operand2 = new StringBuilder();
                    m_operand1 = new StringBuilder();
                    m_calculator.clearTwoOperand();
                    m_calculator.clearOneOperand();
                    m_calculator.clearOperation();
                    m_isEqual = 0;
                    break;
                case R.id.viewAdd:
                    if(m_calculator.isResultNotNull()){
                        String operand = m_calculator.getResult().toString();
                        if(m_calculator.getResult().toString().endsWith(".0")){
                            operand = operand.replace(".0", "");
                        }
                        m_operand1.append(operand);
                        textView.setText(operand);
                        textResult.setText("");
                    }
                    if(m_operand1.length() == 0){
                        return;
                    }
                    textView.append("+");
                    m_calculator.setCurrentOperaton("+");
                    m_calculator.enterNumber(m_operand1.toString());
                    m_isEqual = -1;
                    break;
                case  R.id.viewSub:
                    if(m_calculator.isResultNotNull()){
                        String operand = m_calculator.getResult().toString();
                        if(m_calculator.getResult().toString().endsWith(".0")){
                            operand = operand.replace(".0", "");
                        }
                        m_operand1.append(operand);
                        textView.setText(operand);
                        textResult.setText("");
                    }
                    if(m_operand1.length() == 0){
                        return;
                    }
                    textView.append("-");
                    m_calculator.setCurrentOperaton("-");
                    m_calculator.enterNumber(m_operand1.toString());
                    m_isEqual = -1;
                    break;
                case R.id.viewMult:
                    if(m_calculator.isResultNotNull()){
                        String operand = m_calculator.getResult().toString();
                        if(m_calculator.getResult().toString().endsWith(".0")){
                            operand = operand.replace(".0", "");
                        }
                        m_operand1.append(operand);
                        textView.setText(operand);
                        textResult.setText("");
                    }
                    if(m_operand1.length() == 0){
                        return;
                    }
                    textView.append("*");
                    m_calculator.setCurrentOperaton("*");
                    m_calculator.enterNumber(m_operand1.toString());
                    m_isEqual = -1;
                    break;
                case R.id.viewDiv:
                    if(m_calculator.isResultNotNull()){
                        String operand = m_calculator.getResult().toString();
                        if(m_calculator.getResult().toString().endsWith(".0")){
                            operand = operand.replace(".0", "");
                        }
                        m_operand1.append(operand);
                        textView.setText(operand);
                        textResult.setText("");
                    }
                    if(m_operand1.length() == 0){
                        return;
                    }
                    textView.append("/");
                    m_calculator.setCurrentOperaton("/");
                    m_calculator.enterNumber(m_operand1.toString());
                    m_isEqual = -1;
                    break;
                case R.id.viewDel:
                    m_operand2 = new StringBuilder();
                    m_operand1 = new StringBuilder();
                    m_calculator.clearResult();
                    m_calculator.clearTwoOperand();
                    m_calculator.clearOneOperand();
                    m_calculator.clearOperation();
                    textResult.setText("");
                    textView.setText("");
                    m_isEqual = 0;
                    break;
            }
        }
    };

    private final View.OnClickListener onClickListenerNum = new View.OnClickListener()
    {
        @Override
        public void onClick(View view) {
            if(m_calculator.isResultNotNull() && !m_calculator.isOneOperandNotNull()){
                textView.setText("");
                m_calculator.clearResult();
            }
            switch (view.getId()){
                case R.id.view0:
                    textView.append("0");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("0");
                    } else {
                        m_operand1.append("0");
                    }
                    break;
                case R.id.view1:
                    textView.append("1");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("1");
                    } else {
                        m_operand1.append("1");
                    }
                    break;
                case R.id.view2:
                    textView.append("2");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("2");
                    } else {
                        m_operand1.append("2");
                    }
                    break;
                case R.id.view3:
                    textView.append("3");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("3");
                    } else {
                        m_operand1.append("3");
                    }
                    break;
                case R.id.view4:
                    textView.append("4");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("4");
                    } else {
                        m_operand1.append("4");
                    }
                    break;
                case R.id.view5:
                    textView.append("5");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("5");
                    } else {
                        m_operand1.append("5");
                    }
                    break;
                case R.id.view6:
                    textView.append("6");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("6");
                    } else {
                        m_operand1.append("6");
                    }
                    break;
                case R.id.view7:
                    textView.append("7");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("7");
                    } else {
                        m_operand1.append("7");
                    }
                    break;
                case R.id.view8:
                    textView.append("8");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("8");
                    } else {
                        m_operand1.append("8");
                    }
                    break;
                case R.id.view9:
                    textView.append("9");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append("9");
                    } else {
                        m_operand1.append("9");
                    }
                    break;
                case R.id.viewPoint:
                    textView.append(".");
                    if(m_calculator.isOperationNotNull()){
                        m_operand2.append(".");
                    } else {
                        m_operand1.append(".");
                    }
                    break;
            }

        }
    };

    TextView textView;
    TextView textResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonAdd = (Button)findViewById(R.id.viewAdd);
        Button buttonSub = (Button)findViewById(R.id.viewSub);
        Button buttonMult = (Button)findViewById(R.id.viewMult);
        Button buttonDiv = (Button)findViewById(R.id.viewDiv);
        Button buttonDel = (Button)findViewById(R.id.viewDel);
        Button buttonEqual = (Button)findViewById(R.id.viewEqual);

        Button button0 = (Button)findViewById(R.id.view0);
        Button button1 = (Button)findViewById(R.id.view1);
        Button button2 = (Button)findViewById(R.id.view2);
        Button button3 = (Button)findViewById(R.id.view3);
        Button button4 = (Button)findViewById(R.id.view4);
        Button button5 = (Button)findViewById(R.id.view5);
        Button button6 = (Button)findViewById(R.id.view6);
        Button button7 = (Button)findViewById(R.id.view7);
        Button button8 = (Button)findViewById(R.id.view8);
        Button button9 = (Button)findViewById(R.id.view9);
        Button buttonPoint = (Button)findViewById(R.id.viewPoint);

        buttonAdd.setOnClickListener(onClickListenerOperation);
        buttonSub.setOnClickListener(onClickListenerOperation);
        buttonMult.setOnClickListener(onClickListenerOperation);
        buttonDiv.setOnClickListener(onClickListenerOperation);
        buttonDel.setOnClickListener(onClickListenerOperation);
        buttonEqual.setOnClickListener(onClickListenerOperation);

        button0.setOnClickListener(onClickListenerNum);
        button1.setOnClickListener(onClickListenerNum);
        button2.setOnClickListener(onClickListenerNum);
        button3.setOnClickListener(onClickListenerNum);
        button4.setOnClickListener(onClickListenerNum);
        button5.setOnClickListener(onClickListenerNum);
        button6.setOnClickListener(onClickListenerNum);
        button7.setOnClickListener(onClickListenerNum);
        button8.setOnClickListener(onClickListenerNum);
        button9.setOnClickListener(onClickListenerNum);
        buttonPoint.setOnClickListener(onClickListenerNum);

        textView = (TextView)findViewById(R.id.textView);
        textResult = (TextView)findViewById(R.id.textResult);
    }
}
