package controlEstacionamiento;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Grafica extends JFrame implements ActionListener {

    private JLabel titulo;
    private ListaEnlazada vehiculos;

    public Grafica() {
        setLayout(null);
        getContentPane().setBackground(new Color(149, 77, 237));

        //label
        titulo = new JLabel("Vehiculos en estacionamiento");
        titulo.setBounds(100, 10, 250, 40);
        titulo.setFont(new Font("Arial", 1, 14));
        titulo.setForeground(new Color(0, 0, 0));
        add(titulo);

    }

    public void paint(Graphics g) {

        int autos = vehiculos.cantidadAutos();
        int motos = vehiculos.cantidadMotos();

        int total = autos + motos;

        int grados_auto = autos * 360 / total;
        int grados_moto = motos * 360 / total;

        //para auto
        g.setColor(new Color(255, 0, 0));
        //dibuja un arco circular
        //        (x, y, ancho, largo, grado inicial, grado final)
        g.fillArc(25, 80, 200, 200, 0, grados_auto);
        //         (x, y, ancho, largo)
        g.fillRect(250, 120, 20, 20);
        //           (texto, x, y)
        g.drawString("Autos", 275, 135);

        //para moto
        g.setColor(new Color(0, 130, 0));
        //dibuja un arco circular
        //        (x, y, ancho, largo, grado inicial, grado final)
        g.fillArc(25, 80, 200, 200, grados_auto, grados_moto);
        //         (x, y, ancho, largo)
        g.fillRect(250, 150, 20, 20);
        //           (texto, x, y)
        g.drawString("Motos", 275, 165);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        Grafica grafica = new Grafica();
        grafica.setBounds(0, 0, 400, 365);
        grafica.setVisible(true);
        grafica.setResizable(false);
        grafica.setLocationRelativeTo(null);
    }
}
