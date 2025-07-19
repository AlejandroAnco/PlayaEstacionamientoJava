package controlEstacionamiento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Sistema extends JFrame implements ActionListener {

    private JLabel label1, label2, label3, label4;
    private JTextField text1, text2;
    private JButton boton1;
    private JComboBox tipoVehiculo;
    private Persona persona;
    private Vehiculo vehiculo;
    private static ListaEnlazada vehiculos;
    private String nombre, placa, tipo;

    public Sistema(ListaEnlazada vehiculos) {
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(158, 208, 228));
        setTitle("Registrar");
        this.vehiculos = vehiculos;

        label1 = new JLabel("SISTEMA DE ESTACIONAMIENTO");
        label1.setBounds(50, 10, 300, 50);
        label1.setFont(new Font("Calibri", 3, 20));
        label1.setForeground(new Color(241, 155, 1));
        add(label1);

        label2 = new JLabel("Ingrese su nombre:");
        label2.setBounds(10, 80, 150, 40);
        label2.setFont(new Font("Calibri", 2, 16));
        label2.setForeground(new Color(245, 105, 0));
        add(label2);

        text1 = new JTextField();
        text1.setBounds(10, 120, 250, 25);
        text1.setFont(new Font("Calibri", 0, 16));
        add(text1);

        label3 = new JLabel("Ingrese el numero de placa del vehiculo:");
        label3.setBounds(10, 150, 300, 40);
        label3.setFont(new Font("Calibri", 2, 16));
        label3.setForeground(new Color(245, 105, 0));
        add(label3);

        text2 = new JTextField();
        text2.setBounds(10, 190, 250, 25);
        text2.setFont(new Font("Calibri", 0, 16));
        add(text2);

        boton1 = new JButton("Registrar");
        boton1.setBounds(250, 400, 100, 40);
        boton1.setBackground(new Color(216, 86, 0));
        boton1.setForeground(Color.WHITE);
        boton1.addActionListener(this);
        add(boton1);

        label4 = new JLabel("Seleccione que tipo de vehiculo es:");
        label4.setBounds(10, 220, 300, 40);
        label4.setFont(new Font("Calibri", 2, 16));
        label4.setForeground(new Color(245, 105, 0));
        add(label4);

        tipoVehiculo = new JComboBox();
        tipoVehiculo.setBounds(10, 260, 100, 30);
        tipoVehiculo.setFont(new Font("Calibri", 2, 16));
        tipoVehiculo.setBackground(new Color(248, 94, 26));
        tipoVehiculo.setForeground(Color.WHITE);
        tipoVehiculo.addItem("-");
        tipoVehiculo.addItem("Auto");
        tipoVehiculo.addItem("Moto");
        add(tipoVehiculo);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            if (text1.getText().isEmpty() || text2.getText().isEmpty() || tipoVehiculo.getSelectedItem().equals("-")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todo.");
            }
            if (text2.getText().length() != 6) {
                JOptionPane.showMessageDialog(null, "Placa de vehiculo mal colocada.");
            } else {
                nombre = text1.getText();
                placa = text2.getText();
                tipo = (String) tipoVehiculo.getSelectedItem();
                persona = new Persona(nombre);

                if (tipo.equals("Auto")) {
                    vehiculo = new Auto(placa, persona);
                } else if (tipo.equals("Moto")) {
                    vehiculo = new Moto(placa, persona);
                }

                vehiculos.agregar(vehiculo);

                EstacionamientoVehiculo estacionamiento = new EstacionamientoVehiculo(vehiculos);
                estacionamiento.setBounds(0, 0, 500, 600);
                estacionamiento.setVisible(true);
                estacionamiento.setResizable(false);
                estacionamiento.setLocationRelativeTo(null);

                this.dispose();
            }
        }
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Sistema sistema = new Sistema(lista);
        sistema.setBounds(0, 0, 400, 500);
        sistema.setVisible(true);
        sistema.setResizable(false);
        sistema.setLocationRelativeTo(null);
    }
}
