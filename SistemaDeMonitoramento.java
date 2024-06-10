import java.util.ArrayList;
    
public class SistemaDeMonitoramento extends Login {
    private ArrayList<Morador> moradores = new ArrayList<>();

    public ArrayList<Morador> getMoradores() {
        return moradores;
    }
    public void setMorador(Morador morador){
        this.moradores.add(morador);
    }

    
    public String cadastrarMorador(Morador morador){
        String mensagem = "Mensagem padrao";
        boolean moradorJaCadastrado = false;

        for (Morador moradorEscolhido : moradores) {
            if (morador.getNumeroApart() == moradorEscolhido.getNumeroApart()){
                moradorJaCadastrado = true;
                break;
            }  
        }
        if (!(moradorJaCadastrado)){
            this.setMorador(morador);
            mensagem = "Morador inserido com sucesso";
        } 
        else {
            mensagem = "## ERRO AO INSERIR: MORADOR JÁ CADASTRADO";
        }
        return mensagem;
    }   
    public double verificarConsumoDeEnergia(String nome){
        double consumoTotal = 0;
        Morador moradorProcurado = autenticarMorador(nome, this.moradores);
        if (moradorProcurado != null){
            if (moradorProcurado.getListaDispositivos() != null){
                for (Dispositivos dispositivos : moradorProcurado.getListaDispositivos()) {
                    consumoTotal += dispositivos.getConsumo();
                }
            }
        }
        else {
            return -1;
        }
        
        moradorProcurado.setHistoricoDeConsumo(consumoTotal);
        
        return consumoTotal;
    }
    //verificar Historico Consumo;
    public ArrayList<Double> verificarHistoricoDeConsumo(String nomeMorador){
        Morador moradorProcurado = autenticarMorador(nomeMorador, this.moradores);
        if (moradorProcurado == null){
            return null;
        }
        return moradorProcurado.getHistoricoDeConsumo();

    }
    //definir Alerta
    public String definirAlerta(String morador, double gastoDeEnergia){
        Morador moradorProcurado = autenticarMorador(morador, this.moradores);
        moradorProcurado.setLimiteGastoDeEnergia(gastoDeEnergia);
        return "Alerta definido!";
    }
    //cadastrar dispositivo
    public String cadastrarDispositivo(Dispositivos d, String nome){
        Morador moradorProcurado = autenticarMorador(nome, this.moradores);
        String mensagem = "Mensagem Padrao";
        boolean dispositivoJaCadastrado = false;

        if (moradorProcurado.getListaDispositivos() == null){
            moradorProcurado.setListaDispositivos(d); 
            mensagem = "Dispositivo (" + d.getTipo() + " " +  d.getNome() + ") inserido no nome de " + moradorProcurado.getNome();
        }
        for (Dispositivos dispositivo : moradorProcurado.getListaDispositivos()) {
            if ((dispositivo.getNome().equals(d.getNome())) && (dispositivo.getModelo().equals(d.getModelo()))){
                dispositivoJaCadastrado = true;   
                break;
            }
        }
        
        if(!(dispositivoJaCadastrado)){
            moradorProcurado.setListaDispositivos(d);
            mensagem = "Dispositivo (" + d.getTipo() + " " +  d.getNome() + ") inserido no nome de " + moradorProcurado.getNome();
        } 
        else{
            mensagem = "ERRO AO INSERIR: DISPOSITIVO JA EXISTENTE!";
        }
        return mensagem;
    }
    public String verificarSeExcedeuLimite(double consumo, String nomeMorador){
        boolean excedeuLimiteEnergia = false;
        Morador moradorProcurado = autenticarMorador(nomeMorador, this.moradores);
        String mensagem = "s";
        if (consumo > moradorProcurado.getLimiteGastoDeEnergia()){
            excedeuLimiteEnergia = true;
        }
        if ((excedeuLimiteEnergia)){
            mensagem = "## " + moradorProcurado.getNome() + " EXCEDEU LIMITE DE GASTO DE ENERGIA! ##";
        }
        else{
            mensagem = "Gasto de " + moradorProcurado.getNome() + " esta normal!";
        }
        return mensagem;

    }
    
}
