package meupotencial.com.br.adapters;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import butterknife.Bind;
import butterknife.ButterKnife;
import meupotencial.com.br.Registro.Deposito;
import meupotencial.com.br.meupotencial.R;


public class User_List_Adapter extends ArrayAdapter<Deposito> {

//Construtor
    public User_List_Adapter(Context context, List<Deposito> registro_List) {
        super(context, R.layout.resumo, registro_List);
    }


@Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;
        if(convertView == null){
            convertView = View.inflate(getContext(), R.layout.resumo, null);
            holder = new ViewHolder();
            ButterKnife.bind(holder,convertView);
            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
        }

    Deposito registro = getItem(position);
    if(registro!=null){
            holder.diamma.setText(registro.getData_deposito());
            holder.Not_fis.setText(registro.getNfis());
            holder.Not_esp.setText(registro.getNesp());
            holder.Not_fam.setText(registro.getNfam());
            holder.Not_int.setText(registro.getNint());
            holder.Not_soc.setText(registro.getNsoc());
            holder.Not_pro.setText(registro.getNpro());
            holder.Not_fin.setText(registro.getNfin());
        }
            return convertView;
    }

    //Classe que fará o vinculo o resumo
    public class ViewHolder {

        @Bind(R.id.diammaa)
        TextView diamma;
        @Bind(R.id.Not_fis)
        TextView Not_fis;
        @Bind(R.id.Not_esp)
        TextView Not_esp;
        @Bind(R.id.Not_fam)
        TextView Not_fam;
        @Bind(R.id.Not_int)
        TextView Not_int;
        @Bind(R.id.Not_soc)
        TextView Not_soc;
        @Bind(R.id.Not_pro)
        TextView Not_pro;
        @Bind(R.id.Not_fin)
        TextView Not_fin;
    }
}
