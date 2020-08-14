package com.soltani.currencyconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //Radio Section
    private RadioGroup m_rad_group;
    private MaterialEditText currency_amount;
    private TextView amount_converted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        m_rad_group = findViewById(R.id.m_rad_group);
        currency_amount = findViewById(R.id.currency_amount);
        amount_converted = findViewById(R.id.amount_converted);
        //Number Decimal

        getSupportActionBar().hide();
    }
    public void auClicMethode(View view) {
        if (!currency_amount.getText().toString().isEmpty()){
            float amount = Float.parseFloat(currency_amount.getText().toString());
            switch (m_rad_group.getCheckedRadioButtonId()){
                case R.id.dzd_euro_radio:
                    amount_converted.setText(""+new DecimalFormat("#.##").format(dinarsToEuro(amount))+" €");
                    break;
                case R.id.euro_dzd_radio:
                    amount_converted.setText(""+new DecimalFormat("#.##").format(euroToDinar(amount))+" DZD");
                    break;
            }

        }else
            Toast.makeText(this, "Veuillez saisir le montant", Toast.LENGTH_SHORT).show();
    }
    private float  dinarsToEuro(float amount) {
        amount_converted.setVisibility(amount !=0 ? View.VISIBLE : View.GONE);
        return (float) (amount/1.47);
    }
    private float euroToDinar(float amount) {
        amount_converted.setVisibility(amount !=0 ? View.VISIBLE : View.GONE);
        return (float) (amount*1.47);

    }
}
