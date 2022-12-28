package com.example.ungdunggiaitritonghop.BalloonGame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.ungdunggiaitritonghop.BalloonGameMain;
import com.example.ungdunggiaitritonghop.MainActivity;
import com.example.ungdunggiaitritonghop.R;

public class ResultActivity extends AppCompatActivity {


    private TextView textViewInfo,textViewMyScore,textViewHighestScore;
    private Button buttonPlayAgain,buttonQuitGame;

    int myScore;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result2);

        textViewHighestScore = findViewById(R.id.textViewHighest);
        textViewMyScore = findViewById(R.id.textViewMyScore);
        textViewInfo = findViewById(R.id.textViewInfo);
        buttonPlayAgain = findViewById(R.id.buttonPlayAgain);
        buttonQuitGame = findViewById(R.id.buttonQuitGame);

        myScore = getIntent().getIntExtra("score",0);
        textViewMyScore.setText("Điểm lần này : "+myScore);

        sharedPreferences = this.getSharedPreferences("Score", Context.MODE_PRIVATE);
        int highestScore = sharedPreferences.getInt("highestScore",0);

        if (myScore >= highestScore)
        {
            sharedPreferences.edit().putInt("highestScore",myScore).apply();
            textViewHighestScore.setText("Highest Score : "+myScore);
            textViewInfo.setText("Congratulations. Điểm cao đấy, thử thêm lần nữa không");
        }
        else
        {
            textViewHighestScore.setText("Kỷ lục : "+highestScore);
            if ((highestScore - myScore) > 10)
            {
                textViewInfo.setText("Còn non quá!");
            }
            if ((highestScore - myScore) > 3 && (highestScore - myScore) <= 10)
            {
                textViewInfo.setText("Tạm được thôi bạn ạ");
            }
            if ((highestScore - myScore) <= 3)
            {
                textViewInfo.setText("Nhanh hơn tý được hong :))");
            }
        }

        buttonPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        Intent intent = new Intent(ResultActivity.this, BalloonGameMain.class);
                startActivity(intent);
                finish();

            }
        });

        buttonQuitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent);
                finish();

            }
        });
    }
}