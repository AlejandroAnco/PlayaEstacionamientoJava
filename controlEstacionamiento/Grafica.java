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
    private JMenuItem barras, pastel;

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
        tipo_grafica = new 
        
        //se crean los items
        barras = new JMenuItem("Grafica de barras");
        
    }

    String grafica = "Grafica Pastel";

    public Grafica(ListaEnlazada vehiculos) {
        this();
        this.vehiculos = vehiculos;
    }

    public void paint(Graphics g) {
        super.paint(g);

        if (grafica == "Grafica Circular") {
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

            int grados_auto = autos * 360 / total;
            int grados_moto = motos * 360 / total;

            //para auto
            g.setColor(new Color(210, 121, 80));
            //dibuja un arco circular
            //        (x, y, ancho, largo, grado inicial, grado final)
            g.fillArc(25, 80, 200, 200, 0, grados_auto);
            //         (x, y, ancho, largo)
            g.fillRect(250, 120, 20, 20);
            //           (texto, x, y)
            g.drawString("Autos", 275, 135);

            //para moto
            g.setColor(new Color(168, 148, 91));
            //dibuja un arco circular
            //        (x, y, ancho, largo, grado inicial, grado final)
            g.fillArc(25, 80, 200, 200, grados_auto, grados_moto);
            //         (x, y, ancho, largo)
            g.fillRect(250, 150, 20, 20);
            //           (texto, x, y)
            g.drawString("Motos", 275, 165);
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        ListaEnlazada lista = new ListaEnlazada();
        Grafica grafica = new Grafica(lista);
        grafica.setBounds(0, 0, 400, 365);
        grafica.setVisible(true);
        grafica.setResizable(false);
        grafica.setLocationRelativeTo(null);
    }

}
