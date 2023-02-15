public class Zoologico {
    public static void main(String[] args) {
        
        Zebra martin = new Zebra();

        martin.correr();

        martin.setNome("Toro a zebra");
        System.out.println("Nome da zebra:" + martin.getNome());
    }
}
