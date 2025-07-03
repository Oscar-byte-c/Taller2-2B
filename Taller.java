package Grafica;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

public class Taller extends JFrame {
    private JPanel Panel4;
    private JTextField emailField;
    private JTextField nombresField;
    private JTextField apellidoField;
    private JTextField telefonoField;
    private JComboBox hobbiesCombo;
    private JRadioButton btnGenero;
    private JRadioButton btnGenero1;
    private JRadioButton btnGenero2;
    private JComboBox nivelCombo;
    private JButton btnGuardar;
    private JButton btnLimpiar;
    private JButton btnSalir;
    private JTextArea experienciaArea;
    private JTextArea FormacionArea;
    private JTextField generoOtroField;
    private JTextField hobbiesOtroField;
    private JTextField nivelOtroField;
    private JLabel Nombre;
    private JLabel Apellido;
    private JLabel Email;
    private JLabel Telefono;
    private JLabel Genero;
    private JLabel Hobbies;
    private JLabel Experiencia;
    private JLabel Nivel;
    private JLabel Formacion;


    public Taller() {
        setTitle("Taller");
        setSize(750, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(Panel4);
        setLocationRelativeTo(null);
        Panel4 = new JPanel();
        //1.1Grupo de botones para escoger solo una opcion
        ButtonGroup group = new ButtonGroup();
        group.add(btnGenero);
        group.add(btnGenero1);
        group.add(btnGenero2);


        // Boton Guardar
        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String datos = "Nombres: " + nombresField.getText() + "\n" +
                        "Apellidos: " + apellidoField.getText() + "\n" +
                        "Email: " + emailField.getText() + "\n" +
                        "Teléfono: " + telefonoField.getText() + "\n" +
                        "Genero: " + (btnGenero.isSelected() ? "Masculino" :
                        btnGenero1.isSelected() ? "Femenino" :
                                btnGenero2.isSelected() ? generoOtroField.getText() : "") + "\n" +
                        "Hobbies: " + hobbiesCombo.getSelectedItem() +  hobbiesOtroField.getText() + "\n" +
                        "Experiencia: " + experienciaArea.getText() + "\n" +
                        "Nivel: " + nivelCombo.getSelectedItem() +  nivelOtroField.getText() + "\n" +
                        "Formación: " + FormacionArea.getText();
                try (FileWriter writer = new FileWriter("C:/Users/Oscar/Documents/POO/datos_formulario.txt")) {
                    writer.write(datos);
                    JOptionPane.showMessageDialog(null, "Datos guardados");
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
                }
            }
        });
        // Boton Limpiar
        btnLimpiar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nombresField.setText("");
                apellidoField.setText("");
                emailField.setText("");
                telefonoField.setText("");
                generoOtroField.setText("");
                hobbiesOtroField.setText("");
                nivelOtroField.setText("");
                btnGenero.setSelected(false);
                btnGenero1.setSelected(false);
                btnGenero2.setSelected(false);
                hobbiesCombo.setSelectedIndex(0);
                experienciaArea.setText("");
                nivelCombo.setSelectedIndex(0);
                FormacionArea.setText("");
            }
        });
        //Boton Salir
        btnSalir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "¿Seguro que desea salir?", "Confirmar salida",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            }
        });


    }








        public static void main (String[]args){
            SwingUtilities.invokeLater(() -> {
                Taller tall = new Taller();
                tall.setVisible(true);
            });
        }


}