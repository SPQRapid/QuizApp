package com.example.android.quizapp;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Private method for the score of the quiz
     */
    private void quizGrade(int howManyPoints) {
        TextView gradeTextView = (TextView) findViewById(R.id.quiz_grade);
        gradeTextView.setText(" " + howManyPoints);
    }

    /**
     * When you press the review score button
     */
    public void reviewScore(View view) {
        // If the user selects 1878 (Question 1)
        RadioButton firstYear = (RadioButton) findViewById(R.id.first_year);
        boolean checkedFirstYear = firstYear.isChecked();

        // If the user selects 1988 (Question 1)
        RadioButton secondYear = (RadioButton) findViewById(R.id.second_year);
        boolean checkedSecondYear = secondYear.isChecked();

        // If the user selects 1907 (Question 1)
        RadioButton thirdYear = (RadioButton) findViewById(R.id.third_year);
        boolean checkedThirdYear = thirdYear.isChecked();

        // If the user selects 1876 (Question 1)
        RadioButton fourthYear = (RadioButton) findViewById(R.id.fourth_year);
        boolean checkedFourthYear = fourthYear.isChecked();

        // If the user selects Rooney (Question 2)
        RadioButton wazza = (RadioButton) findViewById(R.id.wayne_rooney);
        boolean checkedWazza = wazza.isChecked();

        // If the user selects Cristiano Ronaldo (Question 2)
        RadioButton cristiano = (RadioButton) findViewById(R.id.cristiano_ronaldo);
        boolean checkedCristiano = cristiano.isChecked();

        // If the user selects Scholes (Question 2)
        RadioButton scholsey = (RadioButton) findViewById(R.id.paul_scholes);
        boolean checkedScholsey = scholsey.isChecked();

        // If the user selects Anfield (Question 3)
        RadioButton scousers = (RadioButton) findViewById(R.id.anfield_liverpool);
        boolean checkedScousers = scousers.isChecked();

        // If the user selects Old Trafford (Question 3)
        RadioButton united = (RadioButton) findViewById(R.id.old_trafford);
        boolean checkedUnited = united.isChecked();

        // If the user selects Emirates (Question 3)
        RadioButton gunners = (RadioButton) findViewById(R.id.emirates_arsenal);
        boolean checkedGunners = gunners.isChecked();

        // If the user selects La Bombonera (Question 4)
        CheckBox bomboana = (CheckBox) findViewById(R.id.boca_juniors);
        boolean checkedBomboana = bomboana.isChecked();

        // If the user selects The Theatre of Dreams (Question 4)
        CheckBox redDevils = (CheckBox) findViewById(R.id.united_stand);
        boolean checkedRedDevils = redDevils.isChecked();

        // If the user selects El Teatro de los Sueños (Question 4)
        CheckBox spanishDevils = (CheckBox) findViewById(R.id.united_spanish);
        boolean checkedSpanishDevils = spanishDevils.isChecked();

        // If the user selects 19 (Question 5)
        RadioButton firstTime = (RadioButton) findViewById(R.id.champions_first);
        boolean checkedFirstTime = firstTime.isChecked();

        // If the user selects 28 (Question 5)
        RadioButton secondTime = (RadioButton) findViewById(R.id.champions_second);
        boolean checkedSecondTime = secondTime.isChecked();

        // If the user selects 23 (Question 5)
        RadioButton thirdTime = (RadioButton) findViewById(R.id.champions_third);
        boolean checkedthirdTime = thirdTime.isChecked();

        // If the user selects 20 (Question 5)
        RadioButton fourthTime = (RadioButton) findViewById(R.id.champions_fourth);
        boolean checkedFourthTime = fourthTime.isChecked();

        int firstQuestion = allQuestions(checkedFirstYear, checkedSecondYear, checkedThirdYear, checkedFourthYear, checkedWazza, checkedCristiano, checkedScholsey, checkedScousers, checkedUnited, checkedGunners, checkedBomboana, checkedRedDevils, checkedSpanishDevils, checkedFirstTime, checkedSecondTime, checkedthirdTime, checkedFourthTime);
        quizGrade(firstQuestion);
        if (allQuestions(checkedFirstYear, checkedSecondYear, checkedThirdYear, checkedFourthYear, checkedWazza, checkedCristiano, checkedScholsey, checkedScousers, checkedUnited, checkedGunners, checkedBomboana, checkedRedDevils, checkedSpanishDevils, checkedFirstTime, checkedSecondTime, checkedthirdTime, checkedFourthTime) <= 0) {
            Toast.makeText(this, "You are clearly not a TRUE FAN.", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this, "You are a red true and true.", Toast.LENGTH_LONG).show();
        }
    }

    /**
     * Private method for points distribution
     */
    private int allQuestions(boolean checkedFirstYear, boolean checkedSecondYear, boolean checkedThirdYear, boolean checkedFourthYear, boolean checkedWazza, boolean checkedCristiano, boolean checkedScholsey, boolean checkedScousers, boolean checkedUnited, boolean checkedGunners, boolean checkedBomboana, boolean checkedRedDevils, boolean checkedSpanishDevils, boolean checkedFirstTime, boolean checkedSecondTime, boolean checkedthirdTime, boolean checkedFourthTime) {
        /**
         * int to help with the point distribution
         */
        int questionAnswers = 0;
        /**
         * Question 1 all if statements
         */
        // If the user selects 1878, then + 5 points
        if (checkedFirstYear) {
            questionAnswers += 5;
        }

        /**
         * Question 2 all if statements
         */
        // If the user selects Rooney, then + 5 points
        if (checkedWazza) {
            questionAnswers += 5;
        }

        /**
         * Question 3 all if statements
         */
        // If the user selects Old Trafford, then + 5 points
        if (checkedUnited) {
            questionAnswers += 5;
        }

        /**
         * Question 4 all if statements
         */

        // If the user selects la Bombonera, then - 5 point
        if (checkedBomboana & checkedRedDevils & checkedSpanishDevils) {
            questionAnswers += 5;
        }

        /**
         * Question 5 all if statements
         */

        // If the user selects 20, then  + 5 points
        if (checkedFourthTime) {
            questionAnswers += 5;
        }
        // When the user enters the answer in the Edit Text
        String sirAlex = "Sir Alex Ferguson";
        String different = getString(R.string.sir_ferguson);
        EditText theLegend = (EditText) findViewById(R.id.sir_alex);
        String livingLegend = theLegend.getText().toString();
        if (livingLegend.equalsIgnoreCase(sirAlex)) {
            questionAnswers += 5;

        }
        return questionAnswers;
    }

}

















