package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.InmuebleFacade;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class FormularioInmuebleController {

    @FXML private ComboBox<String> cbTipo;
    @FXML private TextField txtCiudad, txtHabitaciones, txtPisos, txtPrecio;
    private final InmuebleFacade fachada = new InmuebleFacade();

    @FXML
    public void initialize() {
        cbTipo.getItems().addAll("Casa", "Apartamento", "Finca", "Local");
    }

    @FXML
    public void agregarInmueble() {
        try {
            fachada.agregarInmueble(
                    cbTipo.getValue(),
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

    private void limpiarCampos() {
        cbTipo.setValue(null);
        txtCiudad.clear();
        txtHabitaciones.clear();
        txtPisos.clear();
        txtPrecio.clear();
    }
}

