import java.sql.*;

public class DatabaseHelper {
    private static Connection conexao = null;
    private String fonte = "Carros?useTimezone=true&serverTimezone=UTC";
    private String jdbcDriver = "com.mysql.cj.jdbc.Driver";

    private DatabaseHelper() throws ClassNotFoundException {
        try {
            Class.forName(jdbcDriver);
            conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + fonte, "root", "Laranjeira01");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Ocorreu um erro ao conectar o banco de dados");
        }
    }

    public static Connection getInstance() throws ClassNotFoundException {
        if (conexao == null) {
            try {
                new DatabaseHelper();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                throw e;
            }
        }
        return conexao;
     }
    public static void inserirPessoa(Pessoa pessoa) {
        try {
            Connection conexao = getInstance();
            String sql = "INSERT INTO pessoa (idPessoa, nome, email, peso) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setInt(1, pessoa.getIdPessoa());
            statement.setString(2, pessoa.getNome());
            statement.setString(3, pessoa.getEmail());
            statement.setDouble(4, pessoa.getPeso());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void inserirCarro(Carro carro) {
        try {
            Connection conexao = getInstance();
            String sql = "INSERT INTO carro (combustivel, peso, marca, anoFabricacao, tipo, cor, placa, numPortas) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conexao.prepareStatement(sql);
            statement.setString(1, carro.getCombustivel());
            statement.setDouble(2, carro.getPeso());
            statement.setString(3, carro.getMarca());
            statement.setInt(4, carro.getAnoFabricacao());
            statement.setString(5, carro.getTipo());
            statement.setString(6, carro.getCor());
            statement.setString(7, carro.getPlaca());
            statement.setInt(8, carro.getNumPortas());
            statement.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}