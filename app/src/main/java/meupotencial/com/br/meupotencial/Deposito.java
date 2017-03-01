package meupotencial.com.br.meupotencial;

import java.io.Serializable;

        import se.emilsjolander.sprinkles.Model;
        import se.emilsjolander.sprinkles.annotations.AutoIncrement;
        import se.emilsjolander.sprinkles.annotations.Column;
        import se.emilsjolander.sprinkles.annotations.Key;
        import se.emilsjolander.sprinkles.annotations.Table;

@Table("Deposito")
// coloca a serie serializable
public class Deposito extends Model implements Serializable {

//cria o banco de dados, oolunas do bd nome e respectivos codigos
    @AutoIncrement
    @Key
    @Column("id")
    private long id;
    @Column("data_Dep")
    private String data_deposito;
    @Column("nota_Fisica")
    private Integer nfis;
    @Column("nota_Espiritual")
    private Integer nesp;
    @Column("nota_Familiar")
    private Integer nfam;
    @Column("nota_Profissional")
    private Integer npro;
    @Column("nota_Intelectual")
    private Integer nint;
    @Column("nota_Social")
    private Integer nsoc;
    @Column("nota_Financeira")
    private Integer nfin;

    // get and setters...
    public Integer getNfin() {
        return nfin;
    }
    public void setNfin(Integer nfin) {
        this.nfin = nfin;
    }
    public String getData_deposito() {
        return data_deposito;
    }
    public void setData_deposito(String data_deposito) {
        this.data_deposito = data_deposito;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Integer getNfis() {
        return nfis;
    }
    public void setNfis(Integer nfis) {
        this.nfis = nfis;
    }
    public Integer getNesp() {
        return nesp;
    }
    public void setNesp(Integer nesp) {
        this.nesp = nesp;
    }
    public Integer getNfam() {
        return nfam;
    }
    public void setNfam(Integer nfam) {
        this.nfam = nfam;
    }
    public Integer getNpro() {
        return npro;
    }
    public void setNpro(Integer npro) {
        this.npro = npro;
    }
    public Integer getNint() {
        return nint;
    }
    public void setNint(Integer nint) {
        this.nint = nint;
    }
    public Integer getNsoc() {
        return nsoc;
    }
    public void setNsoc(Integer nsoc) {
        this.nsoc = nsoc;
    }

    //veio do pergaminho
// metodo ja editado traz ultimo deposito
//    static public Deposito BuscarUltimoDeposito() {
//        Deposito Ultimo = Query.one(Deposito.class, "SELECT * FROM Deposito order by id desc limit 1").get();
//        return Ultimo;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        Gaivotas gaivotas = (Gaivotas) o;
//
//        if (id != gaivotas.id) return false;
//        if (nomeAtual != null ? !nomeAtual.equals(gaivotas.nomeAtual) : gaivotas.nomeAtual != null)
//            return false;
//        if (pergaminhoAtual != null ? !pergaminhoAtual.equals(gaivotas.pergaminhoAtual) : gaivotas.pergaminhoAtual != null)
//            return false;
//        if (dataAtual != null ? !dataAtual.equals(gaivotas.dataAtual) : gaivotas.dataAtual != null)
//            return false;
//        if (inicio != null ? !inicio.equals(gaivotas.inicio) : gaivotas.inicio != null)
//            return false;
//        if (diferenca != null ? !diferenca.equals(gaivotas.diferenca) : gaivotas.diferenca != null)
//            return false;
//        if (manha != null ? !manha.equals(gaivotas.manha) : gaivotas.manha != null) return false;
//        if (tarde != null ? !tarde.equals(gaivotas.tarde) : gaivotas.tarde != null) return false;
//        if (noite != null ? !noite.equals(gaivotas.noite) : gaivotas.noite != null) return false;
//        if (alarmeManha != null ? !alarmeManha.equals(gaivotas.alarmeManha) : gaivotas.alarmeManha != null)
//            return false;
//        if (alarmeTarde != null ? !alarmeTarde.equals(gaivotas.alarmeTarde) : gaivotas.alarmeTarde != null)
//            return false;
//        return alarmeNoite != null ? alarmeNoite.equals(gaivotas.alarmeNoite) : gaivotas.alarmeNoite == null;
//
//    }
//
//    @Override
//    public int hashCode() {
//        int result = (int) (id ^ (id >>> 32));
//        result = 31 * result + (nomeAtual != null ? nomeAtual.hashCode() : 0);
//        result = 31 * result + (pergaminhoAtual != null ? pergaminhoAtual.hashCode() : 0);
//        result = 31 * result + (dataAtual != null ? dataAtual.hashCode() : 0);
//        result = 31 * result + (inicio != null ? inicio.hashCode() : 0);
//        result = 31 * result + (diferenca != null ? diferenca.hashCode() : 0);
//        result = 31 * result + (manha != null ? manha.hashCode() : 0);
//        result = 31 * result + (tarde != null ? tarde.hashCode() : 0);
//        result = 31 * result + (noite != null ? noite.hashCode() : 0);
//        result = 31 * result + (alarmeManha != null ? alarmeManha.hashCode() : 0);
//        result = 31 * result + (alarmeTarde != null ? alarmeTarde.hashCode() : 0);
//        result = 31 * result + (alarmeNoite != null ? alarmeNoite.hashCode() : 0);
//        return result;
//    }
//
//    public long getId() {
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public String getNomeAtual() {
//        return nomeAtual;
//    }
//
//    public void setNomeAtual(String nomeAtual) {
//        this.nomeAtual = nomeAtual;
//    }
//
//    public String getPergaminhoAtual() {
//        return pergaminhoAtual;
//    }
//
//    public void setPergaminhoAtual(String pergaminhoAtual) {
//        this.pergaminhoAtual = pergaminhoAtual;
//    }
//
//    public String getDataAtual() {
//        return dataAtual;
//    }
//
//    public void setDataAtual(String dataAtual) {
//        this.dataAtual = dataAtual;
//    }
//
//    public String getInicio() {
//        return inicio;
//    }
//
//    public void setInicio(String inicio) {
//        this.inicio = inicio;
//    }
//
//    public Double getDiferenca() {
//        return diferenca;
//    }
//
//    public void setDiferenca(Double diferenca) {
//        this.diferenca = diferenca;
//    }
//
//    public String getManha() {
//        return manha;
//    }
//
//    public void setManha(String manha) {
//        this.manha = manha;
//    }
//
//    public String getTarde() {
//        return tarde;
//    }
//
//    public void setTarde(String tarde) {
//        this.tarde = tarde;
//    }
//
//    public String getNoite() {
//        return noite;
//    }
//
//    public void setNoite(String noite) {
//        this.noite = noite;
//    }
//
//    public String getAlarmeManha() {
//        return alarmeManha;
//    }
//
//    public void setAlarmeManha(String alarmeManha) {
//        this.alarmeManha = alarmeManha;
//    }
//
//    public String getAlarmeTarde() {
//        return alarmeTarde;
//    }
//
//    public void setAlarmeTarde(String alarmeTarde) {
//        this.alarmeTarde = alarmeTarde;
//    }
//
//    public String getAlarmeNoite() {
//        return alarmeNoite;
//    }
//
//    public void setAlarmeNoite(String alarmeNoite) {
//        this.alarmeNoite = alarmeNoite;
//    }

    @Override
    public String toString() {
        return "Depositos{" +
                "id=" + id +
                ", dataDeposito='" + data_deposito + '\'' +
                ", nota_Fisica='" + nfis + '\'' +
                ", nota_Espiritual='" + nesp + '\'' +
                ", nota_Familiar='" + nfam + '\'' +
                ", nota_Intelectual='" + nint + '\'' +
                ", nota_Profissional='" + npro + '\'' +
                ", nota_Social='" + nsoc + '\'' +
                ", nota_Fin='" + nfin + '\'' +
                '}';
    }
}