package meupotencial.com.br.meupotencial.Aplication;

import android.database.sqlite.SQLiteDatabase;

import se.emilsjolander.sprinkles.Migration;

public class CreateDepositoMigration extends Migration {

    @Override
    protected void doMigration(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE Deposito (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "data_Dep TEXT, " +
                "nota_Fisica INT, " +
                "nota_Espiritual INT, " +
                "nota_Familiar INT, " +
                "nota_Profissional INT, " +
                "nota_Intelectual INT, " +
                "nota_Social INT, " +
                "nota_Financeira INT, ");
    }
}