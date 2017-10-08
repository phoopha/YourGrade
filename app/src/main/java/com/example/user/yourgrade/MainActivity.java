package com.example.user.yourgrade;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mNameEditText, mScoreEditText;
    private Button mFindGradeButton, mExitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.name_edit_text);
        //((EditText) findViewById(R.id.name_edit_text)).setError("ป้อนชื่น");

        mScoreEditText = (EditText) findViewById(R.id.score_edit_text);
        //((EditText) findViewById(R.id.score_edit_text)).setError("ป้อนคะแนน");
        mFindGradeButton = (Button) findViewById(R.id.find_grade_button);
        mExitButton = (Button) findViewById(R.id.exit_button);

        mFindGradeButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String name = mNameEditText.getText().toString();
                if(name.length() == 0 ) {
                    mNameEditText.setError("ป้อนชื่น");
                }
                if (name.length()>0){
                    Integer score = Integer.valueOf(mScoreEditText.getText().toString());
                    if (score == null){
                        mScoreEditText.setError("ป้อนคะแนน");
                    }else{
                        String scoreText = getscoreText(score);
                        Intent intent = new Intent(MainActivity.this, GradeCalculator.class);
                        intent.putExtra("name_text",name);
                        intent.putExtra("score_text",scoreText);
                        startActivity(intent);
                    }
                }
                /*Integer score = Integer.valueOf(mScoreEditText.getText().toString());
                String scoreText = getscoreText(score);

                Intent intent = new Intent(MainActivity.this, GradeCalculator.class);
                intent.putExtra("name_text",name);
                intent.putExtra("score_text",scoreText);
                startActivity(intent);*/
            }

        });

        mExitButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                String result = String.format("แน่ใจว่าต้องการออกจากแอพ?");

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Confirm Exit");
                dialog.setMessage(result);
                dialog.setNegativeButton("ยกเลิก", null);
                dialog.setPositiveButton("ออก",new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                dialog.show();
            }
        });

    }

    private String getscoreText(Integer score) {

        String scoreText = "";

        if (score < 49){
            scoreText = "F";
        }else if (score <59){
            scoreText = "D";
        }else if (score < 69){
            scoreText = "C";
        }else if (score < 79){
            scoreText = "B";
        }else{
            scoreText = "A";
        }
        return scoreText;
    }
}
