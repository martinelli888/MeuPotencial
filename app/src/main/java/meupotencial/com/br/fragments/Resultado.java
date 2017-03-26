package meupotencial.com.br.fragments;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import java.util.Locale;
import meupotencial.com.br.meupotencial.MainActivity;
import meupotencial.com.br.meupotencial.R;

public class Resultado extends android.support.v4.app.Fragment {

    ComunicadorResultado comunicadorResultado;
    ComunicadorReiniciar comunicadorReiniciar;

    public Resultado() {
    }

    public interface ComunicadorReiniciar {
        void reiniciar();
    }

    public interface ComunicadorResultado {
        Integer calcularResultado();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.resultado_layout, container, false);

        final TextView tv;
        final Button btnRecomeca;
        final Button btnVoltar;
        final Button btnCalular;

        tv = (TextView) v.findViewById(R.id.resultado);
        btnRecomeca = (Button) v.findViewById(R.id.recomecar);
        btnVoltar = (Button) v.findViewById(R.id.voltar);

        TextView CalcularNovo;
        CalcularNovo = (TextView) v.findViewById(R.id.resultado);
        CalcularNovo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Integer resultadoCalculado = 0;
                resultadoCalculado = comunicadorResultado.calcularResultado();
                Double resultadoFinal = resultadoCalculado / 0.631021;
                resultadoFinal = Double.valueOf(String.format(Locale.US, "%.2f", resultadoFinal));
                if ((resultadoFinal) > 16.18) {
                    tv.setText(String.valueOf(resultadoFinal) + "%");
                }else {
                    tv.setText(String.valueOf(16.18) + "%");
                }
            }
        });
        btnRecomeca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.tabHost.setCurrentTab(0);
                comunicadorReiniciar.reiniciar();
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.tabHost.setCurrentTab(6);
            }
        });

//monetização
        MobileAds.initialize(v.getContext(),"ca-app-pub-6526158567739347~9122323311");
        AdView adView = (AdView) v.findViewById(R.id.Propaganda_8);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        comunicadorReiniciar = (ComunicadorReiniciar) context;
        comunicadorResultado = (ComunicadorResultado) context;
        super.onAttach(context);
    }
}