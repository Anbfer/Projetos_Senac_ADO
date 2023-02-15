public class Zebra {
    
    private String nome;
    private String correndo = "Estou correndo";

    public Zebra() {
        
    }

    public String getNome() {
        return this.nome;
    }

    public String setNome(String novoNome){
        return this.nome = novoNome;
    }

    public void correr(){
        System.out.println(correndo);
    }

}
