package com.rodrigo.practica_widgets;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText txtNombre;
    private Button btnValorar;
    private RadioGroup radioGroup;
    private RatingBar ratingBar;
    private CheckBox checkBox;
    private boolean NameOk = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtNombre = findViewById(R.id.txtNombre);
        btnValorar = findViewById(R.id.btnValorar);
        radioGroup = findViewById(R.id.radioGroup);
        checkBox = findViewById(R.id.cbRecomendar);
        ratingBar = findViewById(R.id.ratingBar);

        ratingBar.setEnabled(false);
        btnValorar.setEnabled(false);
        checkBox.setEnabled(false);
        btnValorar.setBackgroundResource(R.drawable.cancelform);
        //findViewById(R.id.cbSi).setEnabled(false);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (i == R.id.cbSi){
                    ratingBar.setEnabled(true);
                    checkBox.setEnabled(true);
                        btnValorar.setBackgroundResource(R.drawable.checkform);
                }else{
                    ratingBar.setRating(0);
                    ratingBar.setEnabled(false);
                    checkBox.setChecked(false);
                    checkBox.setEnabled(false);
                    btnValorar.setBackgroundResource(R.drawable.cancelform);
                }
                if (NameOk == true){
                    btnValorar.setEnabled(true);

                }
            }
        });

        txtNombre.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                Toast.makeText(MainActivity.this,
                        "Texto : "+txtNombre.getText().toString(),
                        Toast.LENGTH_SHORT).show();

                if (txtNombre.getText().toString().length() < 3 ){
                    txtNombre.setError("El Nombre es muy Corto");
                    btnValorar.setEnabled(false);
                }else{
                    NameOk = true;
                }
                return false;
            }
        });
    }
}