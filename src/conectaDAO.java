import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class conectaDAO {
    
    public Connection connectDB(){
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/uc11?useSSL=true&user=root&password=Luizinho1604@");
            
        } catch ( ClassNotFoundException | SQLException erro){
            System.out.println(erro);
            JOptionPane.showMessageDialog(null, "Erro ConectaDAO" + erro.getMessage());
        } 
        return conn;
    }
    
}
