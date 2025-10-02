package co.edu.uniquindio.fx10.controlador;

import co.edu.uniquindio.fx10.modelo.Producto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ListadoProductoController {

    @FXML private TableView<Producto> tablaProductos;
    @FXML private TableColumn<Producto, String> colCodigo;
    @FXML private TableColumn<Producto, String> colNombre;
    @FXML private TableColumn<Producto, String> colDescripcion;
    @FXML private TableColumn<Producto, Double> colPrecio;
    @FXML private TableColumn<Producto, Integer> colStock;

    // Lista interna de ejemplo (puedes reemplazar por tu repositorio luego)
    private final ObservableList<Producto> productos = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Conectar columnas con propiedades del modelo Producto (getters)
        colCodigo.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        colDescripcion.setCellValueFactory(new PropertyValueFactory<>("descripcion"));
        colPrecio.setCellValueFactory(new PropertyValueFactory<>("precio"));
        colStock.setCellValueFactory(new PropertyValueFactory<>("stock"));

        // Datos de prueba (para que no salga vacía)
        productos.addAll(
                new Producto("P001", "Laptop Dell", "Laptop Dell Inspiron 15", 1200.00, 10),
                new Producto("P002", "Mouse Logitech", "Mouse inalámbrico Logitech MX Master", 89.99, 25),
                new Producto("P003", "Teclado Mecánico", "Teclado mecánico RGB", 150.00, 15)
        );

        tablaProductos.setItems(productos);
    }

    @FXML
    private void eliminarProducto(ActionEvent event) {
        Producto sel = tablaProductos.getSelectionModel().getSelectedItem();
        if (sel != null) {
            productos.remove(sel);
        } else {
            Alert a = new Alert(Alert.AlertType.WARNING, "Selecciona un producto para eliminar", ButtonType.OK);
            a.showAndWait();
        }
    }

    @FXML
    private void volverDashboard(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("/co/edu/uniquindio/fx10/vista/Dashboard.fxml"));
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
