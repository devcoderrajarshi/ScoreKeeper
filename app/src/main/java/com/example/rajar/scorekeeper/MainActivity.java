package com.example.rajar.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * This activity keeps track of the basketball score for 2 teams.
 */
public class MainActivity extends AppCompatActivity {
    private TextView scoreViewA;
    private TextView scoreViewB;

    // Tracks the score for Team A
    private int scoreTeamA = 0;
    // Tracks the score for Team B
    private int scoreTeamB = 0;


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("ScoreA", scoreTeamA);
        outState.putInt("ScoreB", scoreTeamB);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreViewA = findViewById(R.id.team_a_score);
        scoreViewB = findViewById(R.id.team_b_score);
        if (savedInstanceState != null) {
            scoreTeamA = savedInstanceState.getInt("ScoreA");
            scoreTeamB = savedInstanceState.getInt("ScoreB");
            scoreViewA.setText(String.valueOf(scoreTeamA));
            scoreViewB.setText(String.valueOf(scoreTeamB));
        } else {
            scoreViewA.setText(String.valueOf(scoreTeamA));
            scoreViewB.setText(String.valueOf(scoreTeamB));
        }
    }


    /**
     * Increase the score for Team A by 2 point.
     */
    public void safetyForTeamA(View v) {
        scoreTeamA = scoreTeamA + 2;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 3 points.
     */
    public void fieldGoalForTeamA(View v) {
        scoreTeamA = scoreTeamA + 3;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team A by 6 points.
     */
    public void aTouchdownForTeamA(View v) {
        scoreTeamA = scoreTeamA + 6;
        displayForTeamA(scoreTeamA);
    }

    /**
     * Increase the score for Team B by 2 point.
     */
    public void safetyForTeamB(View v) {
        scoreTeamB = scoreTeamB + 2;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 3 points.
     */
    public void fieldGoalForTeamB(View v) {
        scoreTeamB = scoreTeamB + 3;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Increase the score for Team B by 6 points.
     */
    public void aTouchdownForTeamB(View v) {
        scoreTeamB = scoreTeamB + 6;
        displayForTeamB(scoreTeamB);
    }

    /**
     * Resets the score for both teams back to 0.
     */
    public void resetScore(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        displayForTeamA(scoreTeamA);
        displayForTeamB(scoreTeamB);
    }

    /**
     * Displays the given score for Team A.
     */
    private void displayForTeamA(int score) {

        scoreViewA.setText(String.valueOf(score));
    }

    /**
     * Displays the given score for Team B.
     */
    private void displayForTeamB(int score) {
        scoreViewB.setText(String.valueOf(score));
    }
}
