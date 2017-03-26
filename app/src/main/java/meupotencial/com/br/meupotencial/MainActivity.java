package meupotencial.com.br.meupotencial;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.HorizontalScrollView;
import android.widget.TabHost;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

import butterknife.OnClick;
import meupotencial.com.br.Registro.Deposito;
import meupotencial.com.br.adapters.MyFragmentPagerAdapter;
import meupotencial.com.br.fragments.Fragment1;
import meupotencial.com.br.fragments.Fragment1.Comunicador1;
import meupotencial.com.br.fragments.Fragment2;
import meupotencial.com.br.fragments.Fragment3;
import meupotencial.com.br.fragments.Fragment4;
import meupotencial.com.br.fragments.Fragment5;
import meupotencial.com.br.fragments.Fragment6;
import meupotencial.com.br.fragments.Fragment7;
import meupotencial.com.br.fragments.Resultado;
import meupotencial.com.br.Registro.Armazenado;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, TabHost.OnTabChangeListener, Comunicador1, Fragment2.Comunicador2, Fragment3.Comunicador3, Fragment4.Comunicador4, Fragment5.Comunicador5, Fragment6.Comunicador6, Fragment7.Comunicador7, Resultado.ComunicadorResultado, Resultado.ComunicadorReiniciar {

    private static String MINHAS_PREFERENCIAS = "Minhas Preferencias";

    ViewPager viewPager;
    public static TabHost tabHost;
    private Integer valorRecebido = 0;
    public static List<Integer> listaValores;
    public static Integer[] valores;
    public static Integer somaValores = 0;
    int pega_fis;
    int pega_esp;
    int pega_fam;
    int pega_int;
    int pega_soc;
    int pega_pro;
    int pega_fin;
    String pega_data = "15mar2017";
    Deposito DepositoNovo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPager();
        initTabHost();

        if (valores == null) {
            valores = new Integer[7];
        }

        if (listaValores == null) {
            listaValores = new ArrayList<>();
        }

        if (somaValores == null) {
            somaValores = 0;
        }
    }





    @OnClick(R.id.Depositar)
    public void depositar() {

        if (DepositoNovo == null) {
         Deposito DepositoNovo = new Deposito();}
        else{
            DepositoNovo.setData_deposito(pega_data);
            DepositoNovo.setNfis(pega_fis);
            DepositoNovo.setNesp(pega_esp);
            DepositoNovo.setNfam(pega_fam);
            DepositoNovo.setNint(pega_int);
            DepositoNovo.setNint(pega_soc);
            DepositoNovo.setNint(pega_pro);
            DepositoNovo.setNint(pega_fin);
        }
            //Sprinkles vai salvar o usuario editado como esta
            DepositoNovo.save();
            /* Aqui, a ideia é fazer com que esse intent seja fechada e enviar um extra para
     * a activity que tem a lista de usuário dizendo que o usuário foi salvo com sucesso! */
            Intent i = new Intent(MainActivity.this, dicas.class);
            Toast.makeText(MainActivity.this, "Avaliação salva!", Toast.LENGTH_SHORT).show();
            startActivity(i);
            finish();
    }

    private void initTabHost() {
        tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();

        String[] tabNames = {"Física", "Espiritual", "Intelectual", "Familiar", "Social", "Profissional", "Financeira", "Resultado"};

        for (int i = 0; i < tabNames.length; i++) {
            TabHost.TabSpec tabSpec;
            tabSpec = tabHost.newTabSpec(tabNames[i]);
            tabSpec.setIndicator(tabNames[i]);
            tabSpec.setContent(new FakeContent(getApplicationContext()));
            tabHost.addTab(tabSpec);
        }

        tabHost.setOnTabChangedListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }
    @Override
    public void onPageSelected(int position) {
        tabHost.setCurrentTab(position);
    }
    @Override
    public void onPageScrollStateChanged(int state) {
    }

    @Override
    public void onTabChanged(String s) {
        int selectedItem = tabHost.getCurrentTab();
        viewPager.setCurrentItem(selectedItem);

        HorizontalScrollView hScrollView = (HorizontalScrollView) findViewById(R.id.h_scroll_view);
        View tabView = tabHost.getCurrentTabView();
        int scrollPos = tabView.getLeft() - (hScrollView.getWidth() - tabView.getWidth()) / 2;

        hScrollView.smoothScrollTo(scrollPos, 0);

    }


    @Override
    public void enviar(Integer valor, int position) {
        valorRecebido = valor;
        salvar(valorRecebido, position);
    }

    @Override
    public Integer calcularResultado() {
        somaValores = 0;
        try {
            for (int i = 0; i < valores.length; i++) {
                somaValores += valores[i];
            }
        }catch (Exception e) {
            Toast.makeText(MainActivity.this, "Avalie para continuar", Toast.LENGTH_SHORT).show();
        }
        return somaValores;
    }



    public void salvar(Integer valor, int position) {
        //listaValores.add(position, valor);

        valores[position] = valor;

        SharedPreferences sharedPreferences = getSharedPreferences(MINHAS_PREFERENCIAS, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putFloat("valor", valorRecebido);
        if(position == 0);
        {pega_fis = valorRecebido;}
        if(position == 1);
        {pega_esp = valorRecebido;}
        if(position == 2);
        {pega_fam = valorRecebido;}
        if(position == 3);
        {pega_int = valorRecebido;}
        if(position == 4);
        {pega_soc = valorRecebido;}
        if(position == 5);
        {pega_pro = valorRecebido;}
        if(position == 6);
        {pega_fin = valorRecebido;}

        editor.commit();
    }

    @Override
    public void reiniciar() {
        //listaValores = new ArrayList<>();
        somaValores = 0;
        valores = new Integer[7];
    }


    public class FakeContent implements TabHost.TabContentFactory {
        Context context;
        public FakeContent(Context mContext) {
            context = mContext;
        }

        @Override
        public View createTabContent(String s) {
            View fakeView = new View(context);
            fakeView.setMinimumHeight(0);
            fakeView.setMinimumWidth(0);
            return fakeView;
        }

    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        List<Fragment> listFragments = new ArrayList<>();

        listFragments.add(new Fragment1());
        listFragments.add(new Fragment2());
        listFragments.add(new Fragment3());
        listFragments.add(new Fragment4());
        listFragments.add(new Fragment5());
        listFragments.add(new Fragment6());
        listFragments.add(new Fragment7());
        listFragments.add(new Resultado());

        MyFragmentPagerAdapter myFragmentPagerAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), listFragments);

        viewPager.setAdapter(myFragmentPagerAdapter);

        viewPager.setOnPageChangeListener(this);
    }
}


