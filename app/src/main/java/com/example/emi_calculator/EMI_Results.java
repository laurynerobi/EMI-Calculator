package com.example.emi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
public class EMI_Results extends AppCompatActivity {
    private TextView monthlyAmount;
    private TextView mortgageAmount;
    private TextView amortizationPeriod;
    private TextView interest;
    private TextView totalTerm;

    private Button goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emi_results);

        monthlyAmount = (TextView)findViewById(R.id.emi);
        DecimalFormat dec1 = new DecimalFormat("#.##");


        mortgageAmount = (TextView)findViewById(R.id.totalMortageI);
        amortizationPeriod = (TextView)findViewById(R.id.tenure);

        interest = (TextView)findViewById(R.id.totalInterestRate);
        DecimalFormat dec2 = new DecimalFormat("#.##");

        totalTerm = (TextView)findViewById(R.id.totalpayments);
        DecimalFormat dec3 = new DecimalFormat("#.##");


//retrieving values
        double addValue =getIntent().getDoubleExtra("monthlyAmount",0.0);


        String tenureValue = getIntent().getStringExtra("amortizationPeriod");
        double interestValue = getIntent().getDoubleExtra("interest",0.0);
        double totalTermValue = getIntent().getDoubleExtra("totalTerm", 0.0);
        double mortgageValue = getIntent().getDoubleExtra("mortgageAmount",0.0);

        //set add to monthlyAmount
//        monthlyAmount.setText(String.valueOf(addValue));

        String monthlyAmount1 = dec1.format(addValue);
        monthlyAmount.setText(monthlyAmount1);

        amortizationPeriod.setText(String.valueOf(tenureValue));

        String interest1 = dec2.format(interestValue);
        interest.setText(interest1);

        String totalTerm1 = dec3.format(totalTermValue);
        totalTerm.setText(totalTerm1);

        mortgageAmount.setText(String.valueOf(mortgageValue));

            goBack = findViewById(R.id.btnBack);
            goBack.setOnClickListener(new View.OnClickListener() {

                public void onClick(View view) {
                    Intent intent = new Intent(EMI_Results.this, MainActivity.class);
                    EMI_Results.this.onBackPressed();
                }
            });
        }


    }
