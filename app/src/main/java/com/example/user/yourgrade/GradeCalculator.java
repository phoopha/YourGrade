package com.example.user.yourgrade;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class GradeCalculator extends AppCompatActivity {

    private TextView mNameTextView,mGradeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_calculator);

        mNameTextView = (TextView) findViewById(R.id.name_textview);
        mGradeTextView = (TextView) findViewById(R.id.grade_textview);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name_text");
        String scoreText = intent.getStringExtra("score_text");
        String result1 = String.format(name);
        String result2 = String.format(scoreText);

        mNameTextView.setText(result1);
        mGradeTextView.setText(result2);


    }
}
