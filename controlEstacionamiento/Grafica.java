package controlEstacionamiento;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Grafica extends JFrame implements ActionListener {

    private JLabel titulo;
    private ListaEnlazada vehiculos;
    private JMenuBar menu;
    private JMenu tipo_grafica;
    private JMenuItem barras, porcentual, pastel;

    public Grafica() {
        setLayout(null);
        getContentPane().setBackground(new Color(206, 181, 235));

        //label
        titulo = new JLabel("Vehiculos en estacionamiento");
        titulo.setBounds(100, 10, 250, 40);
        titulo.setFont(new Font("Arial", 1, 14));
        titulo.setForeground(new Color(0, 0, 0));
        add(titulo);

        //se crea la barra de menu
        menu = new JMenuBar();
        tipo_grafica = new JMenu("Tipo de Graficas");

        //se crean los items
        porcentual = new JMenuItem("Grafica de Barras Porcentual");
        pastel = new JMenuItem("Grafica Pastel");
        barras = new JMenuItem("Grafica de Barras");

        //se agregan los items al menu
        tipo_grafica.add(barras);
        tipo_grafica.add(pastel);
        tipo_grafica.add(porcentual);

        //se agrega el menu a la barra
        menu.add(tipo_grafica);

        //se agrega la barra al frame
        setJMenuBar(menu);

        //se agregan los listeners
        barras.addActionListener(this);
        pastel.addActionListener(this);
        porcentual.addActionListener(this);
    }

    String grafica = "Grafica Pastel";

    public Grafica(ListaEnlazada vehiculos) {
        this();
        this.vehiculos = vehiculos;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == barras) {
            grafica = "Grafica de Barras";
        } else if (e.getSource() == pastel) {
            grafica = "Grafica Pastel";
        } else if (e.getSource() == porcentual) {
            grafica = "Grafica de Barras Porcentual";
        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (vehiculos == null) {
            return;
        }

        int autos = vehiculos.cantidadAutos();
        int motos = vehiculos.cantidadMotos();

        int total = autos + motos;

        if (total == 0) {
            g.drawString("No hay vehiculos estacionados", 100, 150);
            return;
        }

        if (grafica.equals("Grafica Pastel")) {

            int grados_auto = autos * 360 / total;
            int grados_moto = motos * 360 / total;

            //para auto
            g.setColor(new Color(210, 121, 80));
            //dibuja un arco circular
            //        (x, y, ancho, largo, grado inicial, grado final)
            g.fillArc(25, 100, 200, 200, 0, grados_auto);
            //         (x, y, ancho, largo)
            g.fillRect(250, 140, 20, 20);
            //           (texto, x, y)
            g.drawString("Autos", 275, 155);

            //para moto
            g.setColor(new Color(168, 148, 91));
            //dibuja un arco circular
            //        (x, y, ancho, largo, grado inicial, grado final)
            g.fillArc(25, 100, 200, 200, grados_auto, grados_moto);
            //         (x, y, ancho, largo)
            g.fillRect(250, 170, 20, 20);
            //           (texto, x, y)
            g.drawString("Motos", 275, 185);

        } else if (grafica.equals("Grafica de Barras")) {

            int largo_auto = autos * 400 / valorMayor(autos, motos);
            int largo_moto = motos * 400 / valorMayor(autos, motos);

            //graficamos
            //para auto
            g.setColor(new Color(210, 121, 80));
            g.fillRect(50, 100, largo_auto, 50);
            g.drawString("Autos", 10, 125);

            //para moto
            g.setColor(new Color(168, 148, 91));
            g.fillRect(50, 160, largo_moto, 50);
            g.drawString("Motos", 10, 185);

        } else if (grafica.equals("Grafica de Barras Porcentual")) {

            int largo_auto = autos * 380 / total;
            int largo_moto = motos * 380 / total;

            double porcentaje_auto = autos * 100 / total;
            double porcentaje_moto = motos * 100 / total;

            g.setColor(new Color(210, 121, 80));
            g.fillRect(10, 120, largo_auto, 50);
            g.setColor(new Color(255, 255, 255));
            g.drawString(porcentaje_auto + "%", 10, 170);

            g.setColor(new Color(168, 148, 91));
            g.fillRect(10 + largo_auto, 120, largo_moto, 50);
            g.setColor(new Color(255, 255, 255));
            g.drawString(porcentaje_moto + "%", 10 + largo_auto, 170);
        }

    }

    public int valorMayor(int autos, int motos) {
        if (autos > motos) {
            return autos;
        } else {
            return motos;
        }
    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Grafica grafica = new Grafica(lista);
        grafica.setBounds(0, 0, 500, 365);
        grafica.setVisible(true);
        grafica.setResizable(false);
        grafica.setLocationRelativeTo(null);
    }

}
