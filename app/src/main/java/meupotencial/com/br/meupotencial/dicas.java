package meupotencial.com.br.meupotencial;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;
import butterknife.Bind;
import butterknife.ButterKnife;
import se.emilsjolander.sprinkles.Query;
import static meupotencial.com.br.meupotencial.R.layout.dicas;

// busca ultimo deposito
public class dicas extends AppCompatActivity{

    @Bind(R.id.saude1)
    EditText Saude1;
    @Bind(R.id.dica1)
    EditText dica1;

    @Bind(R.id.saude2)
    EditText Saude2;
    @Bind(R.id.dica2)
    EditText dica2;

    @Bind(R.id.saude3)
    EditText Saude3;
    @Bind(R.id.dica3)
    EditText dica3;

    @Bind(R.id.saude4)
    EditText Saude4;
    @Bind(R.id.dica4)
    EditText dica4;

    @Bind(R.id.saude5)
    EditText Saude5;
    @Bind(R.id.dica5)
    EditText dica5;

    @Bind(R.id.saude6)
    EditText Saude6;
    @Bind(R.id.dica6)
    EditText dica6;

    @Bind(R.id.saude7)
    EditText Saude7;
    @Bind(R.id.dica7)
    EditText dica7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dicas);
        ButterKnife.bind(this);
        BuscarUltimoDeposito();}

    private void BuscarUltimoDeposito() {
        Deposito ultimoDeposito = Query.one(Deposito.class, "SELECT * FROM Deposito order by id desc limit 1").get();
        if (ultimoDeposito != null) {
            Integer cnfis = ultimoDeposito.getNfis();
            Integer cnesp = ultimoDeposito.getNesp();
            Integer cnfam = ultimoDeposito.getNfam();
            Integer cnint = ultimoDeposito.getNint();
            Integer cnsoc = ultimoDeposito.getNsoc();
            Integer cnpro = ultimoDeposito.getNpro();
            Integer cnfin = ultimoDeposito.getNfin();

// se a nota da saude menor que 5.4
            if (cnfis >= 5.4) {
                Saude1.setText(R.string.titulo1);
                dica1.setText(R.string.dica1);
            }
            if (cnesp >= 5.4) {
                Saude2.setText(R.string.titulo2);
                dica2.setText(R.string.dica2);
            }
            if (cnfam >= 5.4) {
                Saude3.setText(R.string.titulo3);
                dica3.setText(R.string.dica3);
            }
            if (cnint >= 5.4) {
                Saude4.setText(R.string.titulo4);
                dica4.setText(R.string.dica4);
            }
            if (cnsoc >= 5.4) {
                Saude5.setText(R.string.titulo5);
                dica5.setText(R.string.dica5);
            }
            if (cnpro >= 5.4) {
                Saude6.setText(R.string.titulo6);
                dica6.setText(R.string.dica6);
            }
            if (cnfin >= 5.4) {
                Saude7.setText(R.string.titulo7);
                dica7.setText(R.string.dica7);
            }
            else {
                    Toast.makeText(dicas.this, "Refaça sua Avaliação", Toast.LENGTH_LONG).show();
                }
            finishActivity(dicas);
            }
        }
    }
