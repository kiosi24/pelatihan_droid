package com.example.d2j_00.tipscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void hitung(View view) {
        EditText inp1 = (EditText) findViewById(R.id.input1);
        EditText inp2 = (EditText) findViewById(R.id.input2);
        EditText inp3 = (EditText) findViewById(R.id.input3);

        double input1,input2,input3;
        input1 = Double.parseDouble(inp1.getText().toString());
        input2 = Double.parseDouble(inp2.getText().toString());
        input3 = Double.parseDouble(inp3.getText().toString());

        String hasil = "";
            hasil = "Tips : "+(input1 *(input2 / 100))+"\n";
            hasil += "Total : "+(input1+(input1 *(input2 / 100)))+"\n";
            hasil += "Per Orang : " + ((input1+(input1 *(input2 / 100))) / input3)+"\n";

        TextView result = (TextView) findViewById(R.id.result);
        result.setText(hasil);

}
}
