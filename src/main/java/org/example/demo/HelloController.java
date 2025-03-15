package org.example.demo;



import org.example.demo.dao.VinhoDAO;
import org.example.demo.model.Vinho;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class HelloController {

    @FXML
    private TextField tf_nome;

    @FXML
    private TextField tf_preco;

    @FXML
    private TextField tf_safra;

    @FXML
    private TextField tf_tipo;

    @FXML
    void btn_limpar(ActionEvent event) {
        tf_nome.setText("");
        tf_preco.setText("");
        tf_safra.setText("");
        tf_tipo.setText("");
    }
    void limparCampos() {
        tf_nome.setText("");
        tf_preco.setText("");
        tf_safra.setText("");
        tf_tipo.setText("");
    }

    @FXML
    void btn_cadastrar(ActionEvent event) {
        String nome = tf_nome.getText();
        String preco = tf_preco.getText();
        String safra = tf_safra.getText();
        String tipo = tf_tipo.getText();
        if (nome.isEmpty() || preco.isEmpty() || safra.isEmpty() || tipo.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Campos vazios");
            alert.show();
            System.err.println("Campos vazios");
        }else{
            VinhoDAO vinhoDAO = new VinhoDAO();
            Vinho vinho = new Vinho();
            vinho.setNome(nome);
            vinho.setTipo(tipo);
            vinho.setSafra(Integer.parseInt(safra));
            vinho.setPreco(Double.parseDouble((preco)));
            vinhoDAO.create(vinho);
            Alert alert = new Alert(Alert.AlertType.INFORMATION );
            alert.setTitle("sucesso");
            alert.setHeaderText("Dados cadastrados com sucesso!");
            limparCampos();
            alert.show();

        }

    }

    @FXML
    void btn_sair(ActionEvent event) {
        Platform.exit(); // Fecha corretamente a aplicação JavaFX
        System.exit(0);  // Garante que o processo seja encerrado
    }

}
