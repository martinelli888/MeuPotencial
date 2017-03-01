package meupotencial.com.br.meupotencial.Aplication;

import android.app.Application;
//import com..appergarminho.Migration.CreateUsuarioMigration;
import se.emilsjolander.sprinkles.Sprinkles;


public class DepositoAplication  extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //Instanciar Sprinkles
        Sprinkles sprinkles = Sprinkles.init(getApplicationContext());
        //Sprinkles execuar os migrations das entidades
        sprinkles.addMigration(new CreateDepositoMigration());
    }
}