package com.example.ungdunggiaitritonghop.QuizGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ungdunggiaitritonghop.MainActivity;
import com.example.ungdunggiaitritonghop.MainActivityQuiz;
import com.example.ungdunggiaitritonghop.R;

public class ResultActivity extends AppCompatActivity {

    private TextView textViewTotalCorrect,textViewTotalWrong,textViewTotalEmpty,textViewSuccess;
    private Button buttonAgain,buttonQuit;
    int correct,wrong,empty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        textViewTotalCorrect = findViewById(R.id.textViewTotalCorrect);
        textViewTotalWrong = findViewById(R.id.textViewTotalWrong);
        textViewTotalEmpty = findViewById(R.id.textViewTotalEmpty);
        textViewSuccess = findViewById(R.id.textViewSuccess);
        buttonAgain = findViewById(R.id.buttonAgain);
        buttonQuit = findViewById(R.id.buttonQuit);

        correct = getIntent().getIntExtra("correct",0);
        wrong = getIntent().getIntExtra("wrong",0);
        empty = getIntent().getIntExtra("empty",0);

        textViewTotalCorrect.setText("Trả lời đúng : "+correct);
        textViewTotalWrong.setText("Trả lời sai : "+ wrong);
        textViewTotalEmpty.setText("Không trả lời : "+empty);
        textViewSuccess.setText("Tỉ lệ : "+(correct*10) +"%");

        buttonAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this, MainActivityQuiz.class);
                startActivity(intent);
                finish();

            }
        });

        buttonQuit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });

    }
}