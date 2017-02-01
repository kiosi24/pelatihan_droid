package com.example.d2j_00.javaclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public String showStrig;
    public TextView showText;
    public Barang [] arrBarang = new Barang[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = (TextView) findViewById(R.id.show_text);


        showStrig = "manipulasi Class Java Android";
        addseparator();

        initBarang();
//        showStrig += arrBarang[5].toString();
//        addseparator();
//       showStrig += arrBarang[2].toString();
//        showText.setText(showStrig);

        Transaksi trans1 = new Transaksi();
        trans1.addBarang(arrBarang[3]);
        trans1.addBarang(arrBarang[5]);
        trans1.addBarang(arrBarang[2]);
        showStrig += trans1.printTransaksi();
        showStrig += "rata-rata harga barang yang dibeli: "+
                trans1.averageTransaksi();
        showStrig += "\n+"+trans1.maxBarang();

        showText.setText(showStrig);
    }
    public void addseparator(){
        showStrig += "\n---------------------------------------------\n";
    }

    public void initBarang(){
        arrBarang[0] = new Barang("laptop", 1, 7000000);
        arrBarang[1] = new Barang("Printer",Barang.ELEKTRONIK , 7000000);
        arrBarang[2] = new Barang("Yizzy", Barang.NON_ELEKTRONIK, 20000000);
        arrBarang[3] = new Barang("LCD", Barang.ELEKTRONIK, 7000000);
        arrBarang[4] = new Barang("Rijal", Barang.NON_ELEKTRONIK, 100);
        arrBarang[5] = new Barang("Vibrator", Barang.ELEKTRONIK, 7000);
        arrBarang[6] = new Barang("Keyboard", Barang.ELEKTRONIK, 1000);
        arrBarang[7] = new Barang("Mouse", Barang.ELEKTRONIK, 7000000);
        arrBarang[8] = new Barang("KacaMata", Barang.NON_ELEKTRONIK, 5000);
        arrBarang[9] = new Barang("KaosKaki", Barang.NON_ELEKTRONIK, 1000);
    }
}
