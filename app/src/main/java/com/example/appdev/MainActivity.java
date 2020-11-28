package com.example.appdev;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Moves Counter
    int m = 0;

    // Scores
    int P1 = 0;
    int P2 = 0;
    TextView Pl1;
    TextView Pl2;

    int[] B = {0,0,0,0,0,0,0,0,0,0};
    int[] Row = {0, 0, 0, 0};
    int[] C = {0, 0, 0, 0};
    int[] D = {0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Button input variables

        Button b1 = (Button) findViewById(R.id.Bu1);
        Button b2 = (Button) findViewById(R.id.Bu2);
        Button b3 = (Button) findViewById(R.id.Bu3);
        Button b4 = (Button) findViewById(R.id.Bu4);
        Button b5 = (Button) findViewById(R.id.Bu5);
        Button b6 = (Button) findViewById(R.id.Bu6);
        Button b7 = (Button) findViewById(R.id.Bu7);
        Button b8 = (Button) findViewById(R.id.Bu8);
        Button b9 = (Button) findViewById(R.id.Bu9);
        Button b0 = (Button) findViewById(R.id.Bu0);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(this);
        b5.setOnClickListener(this);
        b6.setOnClickListener(this);
        b7.setOnClickListener(this);
        b8.setOnClickListener(this);
        b9.setOnClickListener(this);

        b0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                P1 = 0;
                P2 = 0;
                Pl1 = findViewById(R.id.T1);
                Pl1.setText("Player 1 (O) : " + P1);
                Pl2 = findViewById(R.id.T2);
                Pl2.setText("Player 2 (X) : " + P2);
                reset();
            }
        });
    }

    @Override
    public void onClick(View v) {

        Button Button = findViewById(v.getId());
        int tag = Integer.parseInt(v.getTag().toString());

        if(B[tag] != 0){
            return;
        }

        if(m % 2 == 0){
            B[tag] = 1;
            Button.setText("O");
        }
        else{
            B[tag] = -1;
            Button.setText("X");
        }

        m++;

        values();

        wincheck();

        if(m == 9){
            reset();
            toastD();
        }

        return;

    }

    private void values(){
        Row[1] = B[1] + B[2] + B[3];
        Row[2] = B[4] + B[5] + B[6];
        Row[3] = B[7] + B[8] + B[9];

        C[1] = B[1] + B[4] + B[7];
        C[2] = B[2] + B[5] + B[8];
        C[3] = B[3] + B[6] + B[9];

        D[1] = B[1] + B[5] + B[9];
        D[2] = B[3] + B[5] + B[7];

    }

    private void wincheck(){
        if( Row[1] == 3 || Row[2] == 3 || Row[3] == 3 || C[1] == 3 || C[2] == 3 || C[3] == 3 || D[1] == 3 || D[2] == 3 ){

            reset();
            P1++;
            Pl1 = findViewById(R.id.T1);
            Pl1.setText("Player 1 (O) : " + P1);
            toastO();

        }

        else if(Row[1] == -3 || Row[2] == -3 || Row[3] == -3 || C[1] == -3 || C[2] == -3 || C[3] == -3 || D[1] == -3 || D[2] == -3){

            reset();
            P2++;
            Pl2 = findViewById(R.id.T2);
            Pl2.setText("Player 2 (X) : " + P2);
            toastX();
        }

        else{
            return;
        }

    }

    private void reset(){

        B = new int[]{0,0,0,0,0,0,0,0,0,0};

        m = 0;

        Button b1 = (Button) findViewById(R.id.Bu1);
        Button b2 = (Button) findViewById(R.id.Bu2);
        Button b3 = (Button) findViewById(R.id.Bu3);
        Button b4 = (Button) findViewById(R.id.Bu4);
        Button b5 = (Button) findViewById(R.id.Bu5);
        Button b6 = (Button) findViewById(R.id.Bu6);
        Button b7 = (Button) findViewById(R.id.Bu7);
        Button b8 = (Button) findViewById(R.id.Bu8);
        Button b9 = (Button) findViewById(R.id.Bu9);
        Button b0 = (Button) findViewById(R.id.Bu0);

        b1.setText("");
        b2.setText("");
        b3.setText("");
        b4.setText("");
        b5.setText("");
        b6.setText("");
        b7.setText("");
        b8.setText("");
        b9.setText("");
    }

    private void toastO(){
        Toast toast = Toast.makeText(getApplicationContext(),"O Wins !!", Toast.LENGTH_SHORT);
        toast.show();
    }

    private void toastX(){
        Toast toast = Toast.makeText(getApplicationContext(),"X Wins !!", Toast.LENGTH_SHORT);
        toast.show();

    }

    private void toastD(){
        Toast toast = Toast.makeText(getApplicationContext(),"Draw", Toast.LENGTH_SHORT);
        toast.show();

    }


}






















