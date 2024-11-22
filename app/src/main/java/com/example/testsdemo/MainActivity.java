package com.example.testsdemo;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText editTextFirstOperand, editTextSecondOperand;
    TextView textViewResult;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        editTextFirstOperand = findViewById(R.id.first_operand);
        editTextSecondOperand = findViewById(R.id.second_operand);
        textViewResult = findViewById(R.id.text_result);
        addButton = findViewById(R.id.add_button);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String firstOperandText = editTextFirstOperand.getText().toString();
                String secondOperandText = editTextSecondOperand.getText().toString();

                if (TextUtils.isEmpty(firstOperandText) || TextUtils.isEmpty(secondOperandText)) {
                    textViewResult.setText(R.string.empty_operands);
                } else {
                    textViewResult.setText(Double.parseDouble(firstOperandText)
                            + Double.parseDouble(secondOperandText) + "");
                }

            }
        });

    }
}