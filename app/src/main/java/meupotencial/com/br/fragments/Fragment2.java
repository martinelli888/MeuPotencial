package meupotencial.com.br.fragments;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import meupotencial.com.br.meupotencial.MainActivity;
import meupotencial.com.br.meupotencial.R;

public class Fragment2 extends Fragment {

    Comunicador2 comunicador;
    int valorEscolhido;

    public Fragment2() {
    }

    public interface Comunicador2 {
        public void enviar(Integer valor, int position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment2_layout, container, false);
//
        final TextView tv;
        final Button btnProximo;
        final Button btnVoltar;
        final SeekBar mySeek;


        btnProximo = (Button) v.findViewById(R.id.proximo);
        btnVoltar = (Button) v.findViewById(R.id.voltar);
        tv = (TextView) v.findViewById(R.id.textView2);
        mySeek = (SeekBar) v.findViewById(R.id.seekBar);
        valorEscolhido = mySeek.getProgress();

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.tabHost.setCurrentTab(2);
                valorEscolhido = mySeek.getProgress();
                comunicador.enviar(valorEscolhido, 1);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.tabHost.setCurrentTab(0);
            }
        });

        mySeek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                tv.setText(String.valueOf(i));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
//monetização
        MobileAds.initialize(v.getContext(),"ca-app-pub-6526158567739347~9122323311");
        AdView adView = (AdView) v.findViewById(R.id.Propaganda_2);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        comunicador = (Comunicador2) context;
        super.onAttach(context);
    }
}

