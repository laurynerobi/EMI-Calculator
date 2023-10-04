package com.example.emi_calculator;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText principal;
    private EditText interestRate;
    private EditText year;
    private EditText month;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        principal = findViewById(R.id.principal);
        interestRate = findViewById(R.id.InterestRate);
        year = findViewById(R.id.yearValue);
        month = findViewById(R.id.monthValue);

        Button calcLoanBtn = findViewById(R.id.calcLoan);
        calcLoanBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcLoan(v);
            }
        });
    }

    public void calcLoan(View v) {
        double principal1 = Double.parseDouble(principal.getText().toString());
        double interest1 = Double.parseDouble(interestRate.getText().toString());
        double year1 = Double.parseDouble(year.getText().toString());
        double month1 = Double.parseDouble(month.getText().toString());

        int totalMonths = (int) ((year1 * 12) + month1);
        double principalInterest = (principal1 * interest1) / 100;
        double n = Math.pow((1 + interest1 / 100), totalMonths);
        double emi = (principal1 * interest1 / 100 * n) / (n - 1);
        double interestTotal = (emi * totalMonths) - principal1;
        double totalLoan = principal1 + interestTotal;

        Intent intent = new Intent(this, EMI_Results.class);
        intent.putExtra("monthlyAmount", emi);
        intent.putExtra("amortizationPeriod", totalMonths + " months");
        intent.putExtra("interest", interestTotal);
        intent.putExtra("totalTerm", totalLoan);
        intent.putExtra("mortgageAmount", principal1);
        startActivity(intent);
    }
}
