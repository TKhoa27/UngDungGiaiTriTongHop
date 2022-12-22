package com.example.ungdunggiaitritonghop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ungdunggiaitritonghop.QuizGame.DatabaseCopyHelper;
import com.example.ungdunggiaitritonghop.QuizGame.QuizActivity;

public class MainActivityQuiz extends AppCompatActivity {
    private TextView textViewStart;
    private Button buttonStart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_quiz);

        textViewStart = findViewById(R.id.textViewStart);
        buttonStart = findViewById(R.id.buttonStart);

        copyDatabase();

        buttonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivityQuiz.this, QuizActivity.class);
                startActivity(intent);
            }
        });

    }

    public void copyDatabase()
    {
        try {

            DatabaseCopyHelper helper = new DatabaseCopyHelper(MainActivityQuiz.this);
            helper.createDataBase();
            helper.openDataBase();

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}