package gymGest;

import java.time.LocalDateTime;

public class Entrada {

    private LocalDateTime entrada;
    
    public Entrada(LocalDateTime entrada){
        this.entrada=entrada;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }
}
