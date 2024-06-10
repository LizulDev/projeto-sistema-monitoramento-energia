import java.util.ArrayList;

public class Morador {
   private String nome;
   private int numeroApart;
   private ArrayList <Dispositivos> listaDispositivos = new ArrayList<>();
   private ArrayList <Double> historicoDeConsumo = new ArrayList<>();
   private double limiteGastoDeEnergia;

    public Morador(String nome, int numeroApart) {
        this.nome = nome;
        this.numeroApart = numeroApart;
    }

    public String getNome() {
        return nome;
    }

    public int getNumeroApart() {
        return numeroApart;
    }

    public ArrayList<Dispositivos> getListaDispositivos() {
        return listaDispositivos;
    }

    public ArrayList<Double> getHistoricoDeConsumo() {
        return historicoDeConsumo;
    }

    public void setLimiteGastoDeEnergia(double gastoDeEnergia){
        this.limiteGastoDeEnergia = gastoDeEnergia;
    }
    public double getLimiteGastoDeEnergia() {
        return limiteGastoDeEnergia;
    }


    public void setListaDispositivos(Dispositivos dispositivo) {
        this.listaDispositivos.add(dispositivo);
    }

    public void setHistoricoDeConsumo(double historicoDeConsumo) {
        if(!(this.historicoDeConsumo.contains(historicoDeConsumo))){
            this.historicoDeConsumo.add(historicoDeConsumo);
        }
    }

    @Override
    public String toString() {
        return "Morador [nome=" + nome + ", numeroApart=" + numeroApart + ", listaDispositivos=" + listaDispositivos
                + ", historicoDeConsumo=" + historicoDeConsumo + ", limiteGastoDeEnergia=" + limiteGastoDeEnergia + "]";
    }
    
    
   
}
