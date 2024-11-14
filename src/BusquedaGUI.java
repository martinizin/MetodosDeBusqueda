import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class BusquedaGUI {
    private JTextField textField1;
    private JButton AGREGARButton;
    private JButton BUSCARButton;
    private JPanel pGeneral;
    private JTextArea textArea1;
    private ArrayList<Integer> valores = new ArrayList<>();

    private void actualizarTextArea() {
        StringBuilder listaValores = new StringBuilder();
        for (Integer valor : valores) {
            listaValores.append(valor).append("\n");
        }
        textArea1.setText(listaValores.toString());
    }
    public BusquedaGUI() {
        AGREGARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(textField1.getText());
                    if (valores.contains(valor)) { // Verifica si el valor ya está en la lista
                        JOptionPane.showMessageDialog(null, "El valor ya ha sido ingresado.");
                    } else {
                        valores.add(valor);
                        textField1.setText(""); // Limpiar el campo después de agregar
                        actualizarTextArea(); // Actualizar el TextArea con los valores actuales
                        JOptionPane.showMessageDialog(null, "Valor agregado: " + valor);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }
            }
        });
        BUSCARButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int valor = Integer.parseInt(textField1.getText());
                    int[] array = valores.stream().mapToInt(i -> i).sorted().toArray(); // Convertir y ordenar el ArrayList a array
                    int resultado = BusquedaBinaria.buscar(array, valor);

                    if (resultado != -1) {
                        JOptionPane.showMessageDialog(null, "El valor " + valor + " se encuentra en la posición: " + resultado);
                    } else {
                        JOptionPane.showMessageDialog(null, "El valor " + valor + " no se encuentra en el array.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Ingrese un número válido.");
                }
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("BusquedaGUI");
        frame.setContentPane(new BusquedaGUI().pGeneral);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
