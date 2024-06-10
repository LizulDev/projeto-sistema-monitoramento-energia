import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SistemaDeMonitoramento sistema = new SistemaDeMonitoramento();
        Scanner reader = new Scanner(System.in);

        String continuar = "s";
        
        Morador morador1 = new Morador("Julio", 123);
        Morador morador2 = new Morador("Kesia", 568);

        System.out.println(sistema.cadastrarMorador(morador1));
        System.out.println(sistema.cadastrarMorador(morador2));
        
        System.out.println("\n");

        Dispositivos celular = new Dispositivos("Rog Phone", "Asus", "N3 Ultra", "celular", 1000);
        Dispositivos geladeira = new Dispositivos("Black Bone","Consule", "Master 12", "geladeira", 5000);

        System.out.println(sistema.cadastrarDispositivo(geladeira, "Julio"));
        System.out.println(sistema.cadastrarDispositivo(celular, "Kesia"));
        
        System.out.println("\n");

        System.out.println("Consumo Total " + morador1.getNome() + " " +  sistema.verificarConsumoDeEnergia(morador1.getNome()) + "W/h (mês)");
        
        System.out.println("Consumo Total " + morador2.getNome() + " " + sistema.verificarConsumoDeEnergia(morador2.getNome()) + "W/h (mês)");
        
        System.out.println("\n");

        System.out.println(sistema.definirAlerta("Julio", 50000));
        System.out.println(sistema.verificarSeExcedeuLimite(sistema.verificarConsumoDeEnergia("Julio"), "Julio"));
        
        System.out.println("\n");

        System.out.println(sistema.definirAlerta("Kesia", 60000));
        System.out.println(sistema.verificarSeExcedeuLimite(sistema.verificarConsumoDeEnergia("Kesia"), "Kesia"));
        
        System.out.println("\n");

        System.out.println("Digite qualquer tecla para continuar");
        continuar = reader.next();

        sistema.verificarHistoricoDeConsumo("Julio");
        sistema.verificarHistoricoDeConsumo("Julio");

        Dispositivos chuveiro = new Dispositivos("Chivs", "Lorenzeurt", "Ducha Premium", "chuveiro", 20000); 
        Dispositivos chuveiro2 = new Dispositivos("Chaveg", "Voltec", "Delta Velox", "chuveiro", 30000);

        System.out.println(sistema.cadastrarDispositivo(chuveiro, "Julio"));
        System.out.println(sistema.cadastrarDispositivo(chuveiro2, "Kesia"));

        System.out.println("\n");

        System.out.println("Consumo Total " + morador1.getNome() + " " + sistema.verificarConsumoDeEnergia(morador1.getNome()) + "W/h (mês)");
        System.out.println(sistema.verificarSeExcedeuLimite(sistema.verificarConsumoDeEnergia("Julio"), "Julio"));

        System.out.println("\n");

        System.out.println("Consumo Total " + morador2.getNome() + " " + sistema.verificarConsumoDeEnergia(morador2.getNome()) + "W/h (mês)");
        System.out.println(sistema.verificarSeExcedeuLimite(sistema.verificarConsumoDeEnergia("Kesia"), "Kesia"));
        
        System.out.println("\n");

        System.out.println("Historico de consumo " + morador1.getNome());
        System.out.println(sistema.verificarHistoricoDeConsumo("Julio"));
        
        System.out.println("\n");

        System.out.println("Historico de consumo " + morador2.getNome());
        System.out.println(sistema.verificarHistoricoDeConsumo("Kesia"));
        
        System.out.println("\n");

        reader.close();
    }

}
