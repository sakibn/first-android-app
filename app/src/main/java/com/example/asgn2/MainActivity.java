package com.example.asgn2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText individual_possible;
    EditText individual_earned;
    EditText team_possible;
    EditText team_earned;
    EditText midterm_earned;
    EditText midterm_possible;
    EditText final_earned;
    EditText final_possible;
    TextView grade;
    Button submit;
    Button clear;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        individual_possible = (EditText) findViewById(R.id.i_a_p_p);
        individual_earned = (EditText) findViewById(R.id.i_a_p_e);
        team_earned = (EditText) findViewById(R.id.t_p_p_e);
        team_possible = (EditText) findViewById(R.id.t_p_p_p);
        midterm_earned = (EditText) findViewById(R.id.m_e_p_e);
        midterm_possible = (EditText) findViewById(R.id.m_e_p_p);
        final_earned = (EditText) findViewById(R.id.f_e_p_e);
        final_possible = (EditText) findViewById(R.id.f_e_p_p);
        grade = (TextView) findViewById(R.id.editText9);
        submit = (Button) findViewById(R.id.submit);
        clear = (Button) findViewById(R.id.clear);


        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                grade.setText("");
                individual_possible.setText("");
                individual_earned.setText("");
                team_earned.setText("");
                team_possible.setText("");
                midterm_earned.setText("");
                midterm_possible.setText("");
                final_earned.setText("");
                final_possible.setText("");

            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double individual_earned1 = Double.valueOf(individual_earned.getText().toString().trim());
                double individual_possible1 = Double.valueOf(individual_possible.getText().toString().trim());
                double team_earned1 = Double.valueOf(team_earned.getText().toString().trim());
                double team_possible1 = Double.valueOf(team_possible.getText().toString().trim());
                double midterm_earned1 = Double.valueOf(midterm_earned.getText().toString().trim());
                double midterm_possible1 = Double.valueOf(midterm_possible.getText().toString().trim());
                double final_earned1 = Double.valueOf(final_earned.getText().toString().trim());
                double final_possible1 = Double.valueOf(final_possible.getText().toString().trim());

                double sum= grade1(individual_earned1,individual_possible1,team_earned1,
                        team_possible1,midterm_earned1,midterm_possible1,final_earned1,final_possible1);
                if(sum>=90){
                    grade.setText("A");
                }else if(sum>=80 && sum<90){
                    grade.setText("B");
                }else if(sum>=70 && sum<80){
                    grade.setText("C");
                }else if(sum>=60 && sum<70){
                    grade.setText("D");
                }else if(sum<60){
                    grade.setText("F");
                }
            }
        });
    }
    public double grade1(double individual_earned, double individual_possible, double team_earned,
                        double team_possible, double midterm_earned, double midterm_possible,
                        double final_earned, double final_possible){
        individual_earned= (individual_earned/individual_possible)*20;
        team_earned= (team_earned/team_possible)*30;
        midterm_earned = (midterm_earned/midterm_possible)*20;
        final_earned =(final_earned/final_possible)*30;
        double sum= individual_earned+team_earned+midterm_earned+final_earned;
        return sum;
    }

}
