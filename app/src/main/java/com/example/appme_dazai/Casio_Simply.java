package com.example.appme_dazai;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Casio_Simply extends AppCompatActivity {
    TextView txtResult;

    double num1 = 0, num2 = 0;
    String operator = "";
    boolean isNewInput = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_casio_simply);

        txtResult = findViewById(R.id.txtResult);
        //Số
        findViewById(R.id.btn0).setOnClickListener(v -> append("0"));
        findViewById(R.id.btn1).setOnClickListener(v -> append("1"));
        findViewById(R.id.btn2).setOnClickListener(v->append("2"));
        findViewById(R.id.btn3).setOnClickListener(v -> append("3"));
        findViewById(R.id.btn4).setOnClickListener(v -> append("4"));
        findViewById(R.id.btn5).setOnClickListener(v -> append("5"));
        findViewById(R.id.btn6).setOnClickListener(v->append("6"));
        findViewById(R.id.btn7).setOnClickListener(v->append("7"));
        findViewById(R.id.btn8).setOnClickListener(v -> append("8"));
        findViewById(R.id.btn9).setOnClickListener(v -> append("9"));

        //Phép toán
        findViewById(R.id.btnAdd).setOnClickListener(v -> setOp("+"));
        findViewById(R.id.btnSub).setOnClickListener(v->setOp("-"));
        findViewById(R.id.btnMul).setOnClickListener(v-> setOp("*"));
        findViewById(R.id.btnDiv).setOnClickListener(v -> setOp("/"));

        // Dấu bằng "="
        findViewById(R.id.btnEqual).setOnClickListener(v -> calculate());

        //Dấu C
        //findViewById(R.id.btnC).setOnClickListener(v -> clear());
    }

    private void append(String s) {
        if(isNewInput){
            txtResult.setText(s);
            isNewInput = false;
        }else{
            txtResult.append(s);
        }
    }
    private void setOp(String op){
        num1 = Double.parseDouble(txtResult.getText().toString());
        operator = op;
        isNewInput = true;
    }
    void calculate(){
        num2 = Double.parseDouble(txtResult.getText().toString());
        double result = 0;


    }

}