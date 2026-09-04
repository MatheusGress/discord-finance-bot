package financeiro.model;

public class Usuario {
    private UUID discordID;
    private String nome;

    private Usuario(UUIS discordID, String nome){
        this.discordID = discordID;
        this.nome = nome;
    }
}
