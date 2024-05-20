package com.example.tap2024.Componentes;
import Vistas.EmpleadosForm;
import javafx.scene.control.*;
import com.example.tap2024.modelos.EmpleadosDAO;
import javafx.scene.control.Button;

import java.awt.*;
import java.util.Optional;

public class ButtonCell extends TableCell<EmpleadosDAO,String> {
    Button btnCelda;

    int opc;
    EmpleadosDAO objEmp;

    public ButtonCell(int opc){
        this.opc=opc;
        String txtButton=(opc==1)?"editar":"eliminar";
        btnCelda=new Button(txtButton);
        btnCelda.setOnAction(event ->AccionBoton(opc));

    }

    private void AccionBoton(int opc) {
       TableView<EmpleadosDAO> tbvEmpleados= ButtonCell.this.getTableView();
      objEmp= tbvEmpleados.getItems().get(ButtonCell.this.getIndex());
        if (opc==1){
            //cogigo editar
           // new EmpleadosForm(tbvEmpleados,objEmp);
        }else{
            //codigo de eliminar
            Alert alert =new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("mensaje de sistema");
            alert.setHeaderText("Confirmacion de accion");
            alert.setHeaderText("deseas borrar al empleado"+objEmp.getIdEmpleado()+"?");

           Optional<ButtonType>result= alert.showAndWait();
           if (result.get()==ButtonType.OK){
               objEmp.ELIMINAR();
               tbvEmpleados.setItems(objEmp.CONSULTAR());
               tbvEmpleados.refresh();

           }

        }

    }


    @Override
    protected void updateItem(String item,  boolean empty){
        super.updateItem(item, empty);
        if (!empty)
            this.setGraphic (btnCelda);
    }
}
