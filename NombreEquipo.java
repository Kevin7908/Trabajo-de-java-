
//Como nos damos cuenta una clase enum con sus respectivos enumeradores
//Pero esta como nos damos cuenta tiene un constructor con su nombre sin estar todo en mayuscula
public enum NombreEquipo {

    REAL_MADRID("Real Madrid"),
    BARCELONA("Barcelona"),
    JUVENTUS("Juventus"),
    COLOMBIA("Colombia"),
    BRASIL("Brasil");

    private String nom;

    private NombreEquipo(String nom) {
        this.nom = nom;
    }

    public String getnom() {
        return nom;
    }

}
