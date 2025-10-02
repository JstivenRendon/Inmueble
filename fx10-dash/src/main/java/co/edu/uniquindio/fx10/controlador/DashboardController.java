package co.edu.uniquindio.fx10.controlador;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class DashboardController {

    @FXML
    private VBox contenedorPrincipal;

    // Si otro controlador llama a getContenedorPrincipal(), esto evita el "cannot find symbol"
    public VBox getContenedorPrincipal() {
        return contenedorPrincipal;
    }

    @FXML
    private void mostrarListado(ActionEvent event) {
        cambiarEscena("/co/edu/uniquindio/fx10/vista/ListadoProducto.fxml", event);
    }

    @FXML
    private void mostrarFormulario(ActionEvent event) {
        cambiarEscena("/co/edu/uniquindio/fx10/vista/FormularioProducto.fxml", event);
    }

    // Método reutilizable para cambiar la escena actual (no abre ventanas nuevas)
    private void cambiarEscena(String rutaFXML, ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(rutaFXML));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
