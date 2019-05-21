package nachete.cfic.edu.mi_imc;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private static final String URL_BUSCADOR = "https://www.google.com/search?q=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.mipmap.ic_launcher);

        if (savedInstanceState == null) {
            Log.d("MIAPP", "Es la primera vez que se ejecuta");
        } else {
            Log.d("MIAPP", "No es la primera ejecucion");
        }
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

    public void calcular_Imc(View view) {
        //TODO GESTIONAR EL EVENTO DEL BOTÓN
        // Recoger peso y altura
        EditText editText = this.findViewById(R.id.editText_peso);
        String speso = editText.getText().toString();
        float peso = Float.parseFloat(speso);

        EditText editText1 = this.findViewById(R.id.editText2);
        String saltura = editText1.getText().toString();
        float altura = Float.parseFloat(saltura);

        // calcular imc

        Float imc = (peso / (altura * altura));
        Float imc_en = imc * 703;

        // Mostrar IMC y Resultado

        String idioma = Locale.getDefault().getLanguage();
        TextView textView = findViewById(R.id.textView_imc);

        if (idioma == "en") {
            textView.setText(imc_en.toString());
            imc = imc_en;
        } else {
            textView.setText(imc.toString());
        }

        TextView textView1 = findViewById(R.id.textViewResultado);


        ImageView imageView = findViewById(R.id.imageView);

        if (imc <= 18) {
            imageView.setImageResource(R.drawable.imc_desnutrido);
            textView1.setText(getString(R.string.desnutrido));
        } else if (imc <= 25) {
            imageView.setImageResource(R.drawable.imc_delgado);
            textView1.setText(getString(R.string.delgado));
        } else if (imc <= 30) {
            imageView.setImageResource(R.drawable.imc_obeso);
            textView1.setText(getString(R.string.sobrepeso));
        } else {
            imageView.setImageResource(R.drawable.icm_sobrepeso);
            textView1.setText(getString(R.string.obeso));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        buscar();
        return super.onOptionsItemSelected(item);

    }

    public void buscar() {
        String query = "https://es.wikipedia.org/wiki/%C3%8Dndice_de_masa_corporal";
        Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
        intent.putExtra(SearchManager.QUERY, query);
        if (intent.resolveActivity(getPackageManager()) != null) // Si hay alguna actividad compatible con esa acción
        {
            startActivity(intent);
        }
    }
}