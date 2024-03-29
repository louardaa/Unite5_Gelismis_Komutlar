package com.example.unite5_gelisimizkonular.Uyg11;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.unite5_gelisimizkonular.R;

public class Uyg11 extends AppCompatActivity {

    public Integer[] notlar = new Integer[6];
    public int indis =0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uyg11);
        TextView textViewIndis = findViewById(R.id.textViewIndis);
        TextView textViewToplam = findViewById(R.id.textViewToplam);
        EditText editTextSayi = findViewById(R.id.uyg11);
        Button buttonEkle = findViewById(R.id.buttonEkle);
        Button buttonSifirla = findViewById(R.id.buttonSifirla);
        buttonEkle.setOnClickListener(view -> {
            if (indis <6){
                int sayi;
                sayi = Integer.parseInt(editTextSayi.getText().toString());
                notlar[indis]=sayi;
                indis++;
                textViewIndis.setText("İndis: " + Integer.toString(indis));
                int toplam = 0;
                for (int i = 0; i < indis; i++) {
                    toplam += notlar[i];
                }
                textViewToplam.setText("Toplam: " + Integer.toString(toplam));
                editTextSayi.getText().clear();
            }
            else{
                textViewIndis.setText("Dizi dolu");

                Context context = getApplicationContext();
                CharSequence mesaj = "Daha fazla dizi eklenemez!!";
                int sure = Toast.LENGTH_SHORT;

                Toast toast = Toast.makeText(context, mesaj, sure);

                toast.setGravity(Gravity.CENTER,500,300);//TOAST KONUM

                toast.show();
            }
        });
        buttonSifirla.setOnClickListener(view -> {
            indis=0;
            textViewIndis.setText("İndis: 0");
            textViewToplam.setText("Toplam: 0");
            notlar = new Integer[6];
        });
    }
}


