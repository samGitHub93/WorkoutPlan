package it.sam.workoutplan;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            TestExample.run(this);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
