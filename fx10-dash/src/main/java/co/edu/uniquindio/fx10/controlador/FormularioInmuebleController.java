package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.InmuebleFacade;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import co.edu.uniquindio.fx10.modelo.Inmueble;

public class FormularioInmuebleController {

    @FXML private ComboBox<String> cbTipo;
    @FXML private TextField txtCiudad;
    @FXML private TextField txtHabitaciones;
    @FXML private TextField txtPisos;
    @FXML private TextField txtPrecio;

    @FXML private TableView<Inmueble> tablaInmuebles;
    @FXML private TableColumn<Inmueble, String> colTipo;
    @FXML private TableColumn<Inmueble, String> colCiudad;
    @FXML private TableColumn<Inmueble, Integer> colHabitaciones;
    @FXML private TableColumn<Inmueble, Integer> colPisos;
    @FXML private TableColumn<Inmueble, Double> colPrecio;

    private final InmuebleFacade fachada = InmuebleFacade.getInstance();
    private final ObservableList<Inmueble> listaInmuebles = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        cbTipo.getItems().addAll("Casa", "Apartamento", "Finca", "Oficina");

        colTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colCiudad.setCellValueFactory(new PropertyValueFactory<>("ciudad"));
        colHabitaciones.setCellValueFactory(new PropertyValueFactory<>("habitaciones"));
        colPisos.setCellValueFactory(new PropertyValueFactory<>("pisos"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));

        tablaInmuebles.setItems(listaInmuebles);
    }

    @FXML
    public void agregarInmueble() {
        try {
            Inmueble inmueble = fachada.agregarInmueble(
                    cbTipo.getValue(),
                    txtCiudad.getText(),
                    Integer.parseInt(txtHabitaciones.getText()),
                    Integer.parseInt(txtPisos.getText()),
                    Double.parseDouble(txtPrecio.getText())
            );

            listaInmuebles.add(inmueble);
            limpiarCampos();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, "Datos inválidos o incompletos").show();
        }
    }

    @FXML
    public void eliminarInmueble() {
        Inmueble seleccionado = tablaInmuebles.getSelectionModel().getSelectedItem();
        if (seleccionado != null) {
            fachada.eliminarInmueble(seleccionado);
            listaInmuebles.remove(seleccionado);
        } else {
            new Alert(Alert.AlertType.WARNING, "Seleccione un inmueble para eliminar.").show();
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
