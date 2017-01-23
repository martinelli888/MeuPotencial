package meupotencial.com.br.fragments;

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


public class Fragment7 extends Fragment {

    Comunicador7 comunicador;
    int valorEscolhido;

    public Fragment7() {
    }

    public interface Comunicador7 {
        public void enviar(Integer valor, int position);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment7_layout, container, false);

        final TextView tv;
        final Button btnProximo;
        final Button btnVoltar;
        final SeekBar mySeek;

        tv = (TextView) v.findViewById(R.id.textView7);
        mySeek = (SeekBar) v.findViewById(R.id.seekBar);
        valorEscolhido = mySeek.getProgress();
        btnProximo = (Button) v.findViewById(R.id.proximo);
        btnVoltar = (Button) v.findViewById(R.id.voltar);

        btnProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.tabHost.setCurrentTab(7);
                valorEscolhido = mySeek.getProgress();
                comunicador.enviar(valorEscolhido, 6);
            }
        });

        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainActivity.tabHost.setCurrentTab(5);
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
        AdView adView = (AdView) v.findViewById(R.id.Propaganda_7);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        comunicador = (Comunicador7) context;
        super.onAttach(context);
    }
}