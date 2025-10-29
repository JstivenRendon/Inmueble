package co.edu.uniquindio.fx10.controlador;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import co.edu.uniquindio.fx10.modelo.InmuebleFacade;
import javafx.scene.control.Alert;

public class DashboardController {

    @FXML private ComboBox<String> cmbTipo;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtHabitaciones;
    @FXML private TextField txtPisos;
    @FXML private TextField txtPrecio;

    @FXML private TableView<?> tablaInmuebles;
    @FXML private TableColumn<?, ?> colTipo;
    @FXML private TableColumn<?, ?> colCiudad;
    @FXML private TableColumn<?, ?> colHabitaciones;
    @FXML private TableColumn<?, ?> colPisos;
    @FXML private TableColumn<?, ?> colPrecio;

    private final InmuebleFacade fachada = InmuebleFacade.getInstance();

    @FXML
    private void agregarInmueble() {
        try {
            fachada.agregarInmueble(
                    cmbTipo.getValue(),
                    txtCiudad.getText(),
                    Integer.parseInt(txtHabitaciones.getText()),
                    Integer.parseInt(txtPisos.getText()),
                    Double.parseDouble(txtPrecio.getText())
            );

            limpiarCampos();
        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Datos inválidos").show();
        }
    }

    @FXML
    private void eliminarInmueble() {

        new Alert(Alert.AlertType.INFORMATION, "Funcionalidad no implementada todavía").show();
    }

    private void limpiarCampos() {
        cmbTipo.setValue(null);
        txtCiudad.clear();
        txtHabitaciones.clear();
        txtPisos.clear();
        txtPrecio.clear();
    }
}
