/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Adm
 */
import java.sql.PreparedStatement;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.sql.SQLException;

public class ProdutosDAO {

    Connection conn;
    PreparedStatement prep;
    ResultSet resultset;
    ArrayList<ProdutosDTO> listagem = new ArrayList<>();

    public void cadastrarProduto(ProdutosDTO produto) {
        String sql = "INSERT INTO produtos(nome, valor, status) value(?,?,?)";

        conn = new conectaDAO().connectDB();

        try {
            prep = conn.prepareStatement(sql);

            prep.setString(1, produto.getNome());
            prep.setInt(2, produto.getValor());
            prep.setString(3, produto.getStatus());
            
            prep.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso");
            
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar o produto no banco de dados" + e.getMessage());
        }

    }

    public ArrayList<ProdutosDTO> listarProdutos() {
        String sql = "SELECT * FROM Produtos";
        try {
            conn = new conectaDAO().connectDB();
            
            prep = conn.prepareStatement(sql);
            
            resultset = prep.executeQuery();
            
            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                
                listagem.add(produto);
            }
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao listar os produtos do banco de dados" + e.getMessage());
        }

        return listagem;
    }
    
    public ArrayList<ProdutosDTO> listarProdutosVendidos() {
        String sql = "SELECT * FROM Produtos where status = 'Vendido'";
        try {
            conn = new conectaDAO().connectDB();
            
            prep = conn.prepareStatement(sql);
            
            
            resultset = prep.executeQuery();
            
            while (resultset.next()) {
                ProdutosDTO produto = new ProdutosDTO();
                produto.setId(resultset.getInt("id"));
                produto.setNome(resultset.getString("nome"));
                produto.setValor(resultset.getInt("valor"));
                produto.setStatus(resultset.getString("status"));
                
                listagem.add(produto);
            }
            
            
        } catch (Exception e) {
             JOptionPane.showMessageDialog(null, "Erro ao listar os produtos do banco de dados" + e.getMessage());
        }

        return listagem;
    }
    
    

}
