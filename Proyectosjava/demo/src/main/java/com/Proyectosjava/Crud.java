package com.Proyectosjava;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Crud {
    private JFrame frame;
    private JTextField idField;
    private JTextField userField;
    private JPasswordField passwordField;
    private JTextField yearCreatedField;
    private JTextField searchField; // Campo de texto para la búsqueda
    private JTextField verificationField; // Campo de texto para verificación de datos
    private JTable table;
    private Connection connection;

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Crud window = new Crud();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Crud() {
        initialize();
        connectToDatabase();
        showData(); // Mostrar los datos existentes en la base de datos al iniciar la aplicación
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(100, 100, 600, 400); // Aumentado el tamaño del marco
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout()); // Cambiado a BorderLayout para una mejor disposición de componentes

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2)); // Cambiado a GridLayout para organizar mejor los campos

        idField = new JTextField();
        idField.setColumns(10);
        panel.add(new JLabel("ID:"));
        panel.add(idField);

        userField = new JTextField();
        userField.setColumns(10);
        panel.add(new JLabel("Usuario:"));
        panel.add(userField);

        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        panel.add(new JLabel("Contraseña:"));
        panel.add(passwordField);

        yearCreatedField = new JTextField();
        yearCreatedField.setColumns(10);
        panel.add(new JLabel("Año Creado:"));
        panel.add(yearCreatedField);

        searchField = new JTextField();
        searchField.setColumns(10);
        panel.add(new JLabel("Buscar por Usuario:"));
        panel.add(searchField);

        verificationField = new JTextField();
        verificationField.setColumns(10);
        panel.add(new JLabel("Buscar por ID:"));
        panel.add(verificationField);

        frame.getContentPane().add(panel, BorderLayout.NORTH); // Agregado el panel al contenedor del marco

        table = new JTable();
        table.setModel(new DefaultTableModel(
                new Object[][]{},
                new String[]{"ID", "Usuario", "Contraseña", "Año Creado"}
        ));
        JScrollPane scrollPane = new JScrollPane(table);
        frame.getContentPane().add(scrollPane, BorderLayout.CENTER); // Agregado el scrollPane al contenedor del marco

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout()); // Cambiado a FlowLayout para organizar los botones en línea

        JButton btnGuardar = new JButton("Guardar");
        btnGuardar.addActionListener(e -> saveData());
        buttonPanel.add(btnGuardar);

        JButton btnModificar = new JButton("Modificar");
        btnModificar.addActionListener(e -> updateData());
        buttonPanel.add(btnModificar);

        JButton btnEliminar = new JButton("Eliminar");
        btnEliminar.addActionListener(e -> deleteData());
        buttonPanel.add(btnEliminar);

        JButton btnBuscarUsuario = new JButton("Buscar por Usuario");
        btnBuscarUsuario.addActionListener(e -> searchByUser());
        buttonPanel.add(btnBuscarUsuario);

        JButton btnBuscarId = new JButton("Buscar por ID");
        btnBuscarId.addActionListener(e -> searchById());
        buttonPanel.add(btnBuscarId);

        frame.getContentPane().add(buttonPanel, BorderLayout.SOUTH); // Agregado el panel de botones al contenedor del marco

        // Para Centralizar el formulario
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setLocation(dim.width / 2 - frame.getSize().width / 2, dim.height / 2 - frame.getSize().height / 2);
    }

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:3306/CrudJava"; // Asegúrate de que el puerto sea el correcto (3306 por defecto para MySQL)
        String user = "root";
        String password = "109Inuyash@";

        try {
            connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(frame, "Conexión exitosa con la base de datos");
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al conectar con la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void showData() {
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Crudlist");
             ResultSet resultSet = statement.executeQuery()) {

            DefaultTableModel model = (DefaultTableModel) table.getModel();
            model.setRowCount(0); // Limpiamos la tabla antes de cargar los nuevos datos

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String usuario = resultSet.getString("usuario");
                String contraseña = resultSet.getString("contraseña");
                String año = resultSet.getString("año_de_creacion");

                model.addRow(new Object[]{id, usuario, contraseña, año});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al cargar datos desde la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveData() {
        String usuario = userField.getText();
        String contraseña = new String(passwordField.getPassword());
        String año = yearCreatedField.getText();

        try (PreparedStatement statement = connection.prepareStatement("INSERT INTO Crudlist (usuario, contraseña, año_de_creacion) VALUES (?, ?, ?)")) {
            statement.setString(1, usuario);
            statement.setString(2, contraseña);
            statement.setString(3, año);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                showData();
                JOptionPane.showMessageDialog(frame, "Datos guardados correctamente");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al guardar datos en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void updateData() {
        int id = Integer.parseInt(idField.getText());
        String usuario = userField.getText();
        String contraseña = new String(passwordField.getPassword());
        String año = yearCreatedField.getText();

        try (PreparedStatement statement = connection.prepareStatement("UPDATE Crudlist SET usuario=?, contraseña=?, año_de_creacion=? WHERE id=?")) {
            statement.setString(1, usuario);
            statement.setString(2, contraseña);
            statement.setString(3, año);
            statement.setInt(4, id);

            int rowsUpdated = statement.executeUpdate();
            if (rowsUpdated > 0) {
                showData();
                JOptionPane.showMessageDialog(frame, "Datos actualizados correctamente");
            } else {
                JOptionPane.showMessageDialog(frame, "No se encontró ningún registro con el ID proporcionado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al actualizar datos en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void deleteData() {
        int id = Integer.parseInt(idField.getText());

        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM Crudlist WHERE id=?")) {
            statement.setInt(1, id);

            int rowsDeleted = statement.executeUpdate();
            if (rowsDeleted > 0) {
                showData();
                JOptionPane.showMessageDialog(frame, "Datos eliminados correctamente");
            } else {
                JOptionPane.showMessageDialog(frame, "No se encontró ningún registro con el ID proporcionado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al eliminar datos de la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void searchByUser() {
        String searchTerm = searchField.getText();
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Crudlist WHERE usuario LIKE ?")) {
            statement.setString(1, "%" + searchTerm + "%");
            try (ResultSet resultSet = statement.executeQuery()) {

                DefaultTableModel model = (DefaultTableModel) table.getModel();
                model.setRowCount(0); // Limpiar la tabla antes de cargar los nuevos datos

                while (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String usuario = resultSet.getString("usuario");
                    String contraseña = resultSet.getString("contraseña");
                    String año = resultSet.getString("año_de_creacion");

                    model.addRow(new Object[]{id, usuario, contraseña, año});
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al buscar usuario en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        searchField.setText(""); // Limpiar el campo de búsqueda
    }

    private void searchById() {
        int searchTerm = Integer.parseInt(verificationField.getText());
        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM Crudlist WHERE id=?")) {
            statement.setInt(1, searchTerm);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    int id = resultSet.getInt("id");
                    String usuario = resultSet.getString("usuario");
                    String contraseña = resultSet.getString("contraseña");
                    String año = resultSet.getString("año_de_creacion");

                    // Rellenar los campos con los datos encontrados
                    idField.setText(String.valueOf(id));
                    userField.setText(usuario);
                    passwordField.setText(contraseña);
                    yearCreatedField.setText(año);
                } else {
                    JOptionPane.showMessageDialog(frame, "No se encontró ningún registro con el ID proporcionado", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al buscar ID en la base de datos", "Error", JOptionPane.ERROR_MESSAGE);
        }
        verificationField.setText(""); // Limpiar el campo de verificación
    }
}
