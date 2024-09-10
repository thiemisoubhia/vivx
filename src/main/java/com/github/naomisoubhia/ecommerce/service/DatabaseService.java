@Service
public class DatabaseService {
 
    @Retryable(value = { SQLException.class }, maxAttempts = 3)
    public void fetchData() throws SQLException {
        // Código para acessar o banco de dados principal
    }
 
    @Recover
    public void recover(SQLException e) {
        // Código para acessar o banco de dados replicado
    }
}
