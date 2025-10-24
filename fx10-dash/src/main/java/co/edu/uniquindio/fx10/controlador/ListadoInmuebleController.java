package co.edu.uniquindio.fx10.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ListadoInmuebleController {

    @FXML
    private Button btnVolver;

    @FXML
    private void volverDashboard() {
        Stage stage = (Stage) btnVolver.getScene().getWindow();
        stage.close();
    }
}
