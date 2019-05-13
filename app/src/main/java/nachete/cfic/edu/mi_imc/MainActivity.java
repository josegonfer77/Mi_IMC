package nachete.cfic.edu.mi_imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.ic_launcher);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("MIAPP", "Estoy en onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("MIAPP", "Estoy en onresume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("MIAPP", "Estoy en onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("MIAPP", "Estoy en onpause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("MIAPP", "Estoy en ondestroy");
    }

    public void calcular_Imc (View view)
    {
        //TODO GESTIONAR EL EVENTO DEL BOTÓN
        // Recoger peso y altura
        EditText editText = this.findViewById(R.id.editText_peso);
        String speso = editText.getText().toString();
        float peso = Float.parseFloat(speso);

        EditText editText1 = this.findViewById(R.id.editText2);
        String saltura = editText1.getText().toString();
        float altura = Float.parseFloat(saltura);

        // calcular imc

        Float imc = (peso/(altura*altura));

        // Mostrar IMC

        TextView textView = findViewById(R.id.textView_imc);
        textView.setText(imc.toString());

        ImageView imageView = findViewById(R.id.imageView);

        if (imc<=18){
            imageView.setImageResource(R.drawable.imc_desnutrido);
        }else if (imc<=25){
            imageView.setImageResource(R.drawable.imc_delgado);
        }else if (imc<=30){
            imageView.setImageResource(R.drawable.imc_obeso);
        }else {
            imageView.setImageResource(R.drawable.icm_sobrepeso);
        }

    }

}
