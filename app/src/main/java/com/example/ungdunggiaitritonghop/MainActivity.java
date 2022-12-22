package com.example.ungdunggiaitritonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.ungdunggiaitritonghop.Caculator.Calculator;
import com.example.ungdunggiaitritonghop.QuizGame.QuizActivity;

public class MainActivity extends AppCompatActivity {

    Button btnQuiz, btnCalculator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnQuiz = findViewById(R.id.btnQuizApp);
        btnCalculator = findViewById(R.id.btnCalculatorApp);

        btnCalculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent( MainActivity.this, Calculator.class );
                startActivity(intent);
            }
        });

        btnQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivityQuiz.class);
                startActivity(intent);
            }
        });

    }
}