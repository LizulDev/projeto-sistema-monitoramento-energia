import java.util.ArrayList;

public abstract class Login {
    
    //verificador de Morador;
    public Morador autenticarMorador(String nomeMorador, ArrayList<Morador> moradores){
        if (moradores == null){
            return null;
        }
    	for (Morador morador2 : moradores){
                if (morador2.getNome().equalsIgnoreCase(nomeMorador)) 
                    return morador2;
            }
        
        return null;
    }
}
