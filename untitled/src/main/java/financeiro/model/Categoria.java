package financeiro.model;

public class Categoria {
    private UUID id;
    private String nome;

    private Categoria(UUID id, String nome) {
        this.id = id;
        this.nome = nome;
    }
}
