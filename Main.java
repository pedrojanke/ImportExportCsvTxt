import src.db.Conexao;

public class Main {
    public static void main(String[] args) {
        Conexao conexao = new Conexao();
        
        conexao.connectToDatabase();
    }
}
