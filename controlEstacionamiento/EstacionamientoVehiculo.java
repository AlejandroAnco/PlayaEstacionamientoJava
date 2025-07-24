package controlEstacionamiento;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EstacionamientoVehiculo extends JFrame implements ActionListener {

    private JLabel label1, listaVehiculos;
    private JButton agregar, retirar;
    private JButton actualizar;
    private JTextArea vehiculosEstacionados;
    private JScrollPane pane1;
    private ListaEnlazada vehiculos;

    public EstacionamientoVehiculo(ListaEnlazada vehiculos) {
        this.vehiculos = vehiculos;

        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Parque de Estacionamiento");
        getContentPane().setBackground(new Color(122, 213, 222));

        label1 = new JLabel("Parque de Estacionamiento");
        label1.setBounds(100, 10, 300, 40);
        label1.setFont(new Font("Andale Mono", 3, 20));
        label1.setForeground(new Color(243, 146, 74));
        add(label1);

        listaVehiculos = new JLabel("Vehiculos estacionados:");
        listaVehiculos.setBounds(10, 60, 200, 40);
        listaVehiculos.setFont(new Font("Andale Mono", 1, 16));
        listaVehiculos.setForeground(new Color(212, 86, 38));
        add(listaVehiculos);

        vehiculosEstacionados = new JTextArea();
        vehiculosEstacionados.setFont(new Font("Andale Mono", 0, 16));
        vehiculosEstacionados.setForeground(Color.WHITE);
        vehiculosEstacionados.setBackground(new Color(237, 82, 48));
        vehiculosEstacionados.setEditable(false);
        vehiculosEstacionados.setText(vehiculos.obtenerElementos());

        pane1 = new JScrollPane(vehiculosEstacionados);
        pane1.setBounds(10, 100, 450, 350);
        add(pane1);

        agregar = new JButton("Agregar Vehiculo");
        agregar.setBounds(10, 460, 150, 40);
        agregar.setFont(new Font("Calibri", 1, 14));
        agregar.setBackground(new Color(138, 198, 101));
        agregar.setForeground(Color.WHITE);
        agregar.addActionListener(this);
        add(agregar);

        retirar = new JButton("Retirar Vehiculo");
        retirar.setBounds(310, 460, 150, 40);
        retirar.setFont(new Font("Calibri", 1, 14));
        retirar.setBackground(new Color(246, 60, 18));
        retirar.setForeground(Color.WHITE);
        retirar.addActionListener(this);
        add(retirar);

        actualizar = new JButton("Actualizar");
        actualizar.setBounds(170, 460, 130, 40);
        actualizar.setFont(new Font("Calibri", 1, 14));
        actualizar.setBackground(new Color(70, 130, 180));
        actualizar.setForeground(Color.WHITE);
        actualizar.addActionListener(this);
        add(actualizar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == agregar) {
            Sistema sistema = new Sistema(vehiculos);
            sistema.setBounds(0, 0, 400, 500);
            sistema.setVisible(true);
            sistema.setResizable(false);
            sistema.setLocationRelativeTo(null);
            this.dispose();
        } else if (e.getSource() == retirar) {
            if (vehiculosEstacionados.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Error! no hay vehiculos estacionados");
            } else {
                String placa = JOptionPane.showInputDialog(this, "Ingrese la placa del vehiculo a retirar:");
                if (placa != null && !placa.trim().isEmpty()) {
                    Vehiculo vehiculoARetirar = vehiculos.buscarPorPlaca(placa.trim());
                    if (vehiculoARetirar != null) {
                        vehiculos.eliminar(vehiculoARetirar);
                        JOptionPane.showMessageDialog(this, "Vehiculo retirado correctamente.");
                        actualizarListaVehiculos();
                    } else {
                        JOptionPane.showMessageDialog(this, "Vehiculo no encontrado.");
                    }
                }
            }

        } else if (e.getSource() == actualizar) {
            actualizarListaVehiculos();
        }
    }

    private void actualizarListaVehiculos() {
        vehiculosEstacionados.setText(vehiculos.obtenerElementos());
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        EstacionamientoVehiculo estacionamiento = new EstacionamientoVehiculo(lista);
        estacionamiento.setBounds(0, 0, 500, 600);
        estacionamiento.setVisible(true);
        estacionamiento.setResizable(false);
        estacionamiento.setLocationRelativeTo(null);
    }
}
