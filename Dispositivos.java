
public class Dispositivos {
    private String nome;
    private String marca;
    private String modelo;
    private String tipo;
    private double consumo;

    public Dispositivos(String nome, String marca, String modelo, String tipo, double consumo) {
        this.nome = nome;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
        this.consumo = consumo;
    }

    public String getNome() {
        return nome;
    }

    public String getMarca() {
        return marca;
    }

    public String getModelo() {
        return modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public double getConsumo() {
        return consumo;
    }
    
    
}
