package com.Proyectosjava;

import java.awt.Color;
import java.awt.Dimension; // Asegúrate de importar esto
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import org.mindrot.jbcrypt.BCrypt;

public class Proyecto {

    private JFrame frame;
    private JTextField userField;
    private JPasswordField passwordField;
    private Connection connection;
    // private boolean isFullScreen = false; // Estado de pantalla completa

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                Proyecto window = new Proyecto();
                window.frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public Proyecto() {
        initialize();
        connectToDatabase();
    }

    private void initialize() {
        frame = new JFrame("Login");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255)); // Fondo blanco para contraste
        frame.getContentPane().add(panel);

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        JLabel titleLabel = new JLabel("Bienvenido al sistema");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 24));
        titleLabel.setForeground(new Color(0, 51, 102));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 1;

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(lblUsuario, constraints);

        constraints.gridx = 1;
        userField = new JTextField(20);
        panel.add(userField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;

        JLabel lblContraseña = new JLabel("Contraseña:");
        lblContraseña.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        panel.add(lblContraseña, constraints);

        constraints.gridx = 1;
        passwordField = new JPasswordField(20);
        panel.add(passwordField, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        constraints.gridwidth = 2;
        constraints.anchor = GridBagConstraints.CENTER;

        JButton btnLogin = new JButton("Iniciar sesión");
        btnLogin.setPreferredSize(new Dimension(200, 40));
        btnLogin.setBackground(new Color(0, 123, 255));
        btnLogin.setForeground(Color.WHITE);
        btnLogin.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnLogin.setFocusPainted(false);
        btnLogin.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passwordField.getPassword());
            verificarCredenciales(username, password);
        });
        panel.add(btnLogin, constraints);

        constraints.gridy = 4;

        JButton btnForgotPassword = new JButton("¿Olvidaste tu contraseña?");
        btnForgotPassword.setPreferredSize(new Dimension(250, 30));
        btnForgotPassword.setBackground(new Color(240, 240, 240));
        btnForgotPassword.setForeground(new Color(0, 123, 255));
        btnForgotPassword.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        panel.add(btnForgotPassword, constraints);

        btnForgotPassword.addActionListener(e -> abrirNuevoFormularioRecuperarContraseña());

        constraints.gridy = 5;

        JLabel lblNoAccount = new JLabel("¿No tienes una cuenta?");
        lblNoAccount.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        lblNoAccount.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(lblNoAccount, constraints);

        constraints.gridx = 0;
        constraints.gridy = 6;

        JButton btnRegister = new JButton("Regístrate");
        btnRegister.setPreferredSize(new Dimension(200, 40));
        btnRegister.setBackground(new Color(0, 123, 255));
        btnRegister.setForeground(Color.WHITE);
        btnRegister.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btnRegister.setFocusPainted(false);
        panel.add(btnRegister, constraints);

        btnRegister.addActionListener(e -> abrirNuevoFormularioRegistro());
    }

    // private void toggleFullScreen() {
    //     if (isFullScreen) {
    //         frame.dispose(); // Cierra la ventana actual
    //         frame.setUndecorated(false); // Muestra la barra de título
    //         frame.setExtendedState(JFrame.NORMAL); // Regresa a estado normal
    //         frame.setSize(600, 400); // Establece el tamaño normal
    //         frame.setVisible(true); // Muestra la ventana
    //     } else {
    //         frame.dispose(); // Cierra la ventana actual
    //         frame.setUndecorated(true); // Oculta la barra de título
    //         frame.setExtendedState(JFrame.MAXIMIZED_BOTH); // Establece el modo pantalla completa
    //         frame.setVisible(true); // Muestra la ventana
    //     }
    //     isFullScreen = !isFullScreen; // Cambia el estado
    // }

    private void registrarUsuario(String nombre, String apellidos, String email, String usuario, String contrasena, String direccion) {
        String query = "INSERT INTO Usuarios (nombre, apellidos, usuario, contrasena, correo, direccion) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, nombre);
            statement.setString(2, apellidos);
            statement.setString(3, usuario);
            //Bcrypt para encriptacion de datos para contraseñas y no se almacenan en la base de datos como texto plano
            String hash = BCrypt.hashpw(contrasena, BCrypt.gensalt());
            statement.setString(4, hash);
            statement.setString(5, email);
            statement.setString(6, direccion);
            statement.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Registro exitoso!", "Mensaje", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al registrar usuario: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void abrirNuevoFormularioRegistro() {
        JFrame registroFrame = new JFrame("Registro");
        registroFrame.setSize(400, 500);
        registroFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        registroFrame.setLocationRelativeTo(frame);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255)); // Fondo blanco
        registroFrame.add(panel);

        placeComponentsRegistro(panel, registroFrame);
        registroFrame.setVisible(true);
    }

    private void abrirNuevoFormularioRecuperarContraseña() {
        JFrame forgotPasswordFrame = new JFrame("Recuperar contraseña");
        forgotPasswordFrame.setSize(400, 400);
        forgotPasswordFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        forgotPasswordFrame.setLocationRelativeTo(frame);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(new Color(255, 255, 255)); // Fondo blanco
        forgotPasswordFrame.add(panel);

        placeComponentsRecuperarContraseña(panel, forgotPasswordFrame);
        forgotPasswordFrame.setVisible(true);
    }

    private void placeComponentsRegistro(JPanel panel, JFrame registroFrame) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        JLabel titleLabel = new JLabel("Registro de Usuario");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 51, 102));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, constraints);

        constraints.gridwidth = 1;

        JLabel nombreLabel = new JLabel("Nombre:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(nombreLabel, constraints);

        JTextField nombreField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(nombreField, constraints);

        JLabel apellidoLabel = new JLabel("Apellidos:");
        constraints.gridx = 0;
        constraints.gridy = 2;
        panel.add(apellidoLabel, constraints);

        JTextField apellidoField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(apellidoField, constraints);

        JLabel userLabel = new JLabel("Usuario:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(userLabel, constraints);

        JTextField userField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(userField, constraints);

        JLabel direccionLabel = new JLabel("Dirección:");
        constraints.gridx = 0;
        constraints.gridy = 4;
        panel.add(direccionLabel, constraints);

        JTextField direccionField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(direccionField, constraints);

        JLabel emailLabel = new JLabel("Correo:");
        constraints.gridx = 0;
        constraints.gridy = 5;
        panel.add(emailLabel, constraints);

        JTextField emailField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(emailField, constraints);

        JLabel passwordLabel = new JLabel("Contraseña:");
        constraints.gridx = 0;
        constraints.gridy = 6;
        panel.add(passwordLabel, constraints);

        JPasswordField passwordField = new JPasswordField(20);
        constraints.gridx = 1;
        panel.add(passwordField, constraints);

        JButton btnRegistrar = new JButton("Registrar");
        constraints.gridx = 0;
        constraints.gridy = 7;
        constraints.gridwidth = 2;
        btnRegistrar.addActionListener(e -> {
            String nombre = nombreField.getText();
            String apellidos = apellidoField.getText();
            String email = emailField.getText();
            String usuario = userField.getText();
            String direccion = direccionField.getText();
            String contrasena = new String(passwordField.getPassword());
            registrarUsuario(nombre, apellidos, email, usuario, contrasena, direccion);
            registroFrame.dispose();
        });
        panel.add(btnRegistrar, constraints);
    }

    private void placeComponentsRecuperarContraseña(JPanel panel, JFrame forgotPasswordFrame) {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.HORIZONTAL;
        constraints.insets = new Insets(10, 10, 10, 10);

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;

        JLabel titleLabel = new JLabel("Recuperar Contraseña");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 20));
        titleLabel.setForeground(new Color(0, 51, 102));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(titleLabel, constraints);

        constraints.gridwidth = 1;

        JLabel methodLabel = new JLabel("Selecciona el método:");
        constraints.gridx = 0;
        constraints.gridy = 1;
        panel.add(methodLabel, constraints);

        JRadioButton radioEmail = new JRadioButton("Correo Electrónico");
        JRadioButton radioPhone = new JRadioButton("Número de Teléfono");
        ButtonGroup group = new ButtonGroup();
        group.add(radioEmail);
        group.add(radioPhone);

        constraints.gridx = 1;
        panel.add(radioEmail, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        panel.add(radioPhone, constraints);

        JLabel identifierLabel = new JLabel("Introduce tu correo o número:");
        constraints.gridx = 0;
        constraints.gridy = 3;
        panel.add(identifierLabel, constraints);

        JTextField identifierField = new JTextField(20);
        constraints.gridx = 1;
        panel.add(identifierField, constraints);

        JButton btnRecuperar = new JButton("Recuperar");
        constraints.gridx = 0;
        constraints.gridy = 4;
        constraints.gridwidth = 2;
        btnRecuperar.addActionListener(e -> {
            String identifier = identifierField.getText();
            // Aquí puedes agregar la lógica para manejar la recuperación de contraseña
            if (radioEmail.isSelected()) {
                JOptionPane.showMessageDialog(forgotPasswordFrame, "Se ha enviado un correo para recuperar la contraseña a " + identifier + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else if (radioPhone.isSelected()) {
                JOptionPane.showMessageDialog(forgotPasswordFrame, "Se ha enviado un mensaje para recuperar la contraseña al número " + identifier + ".", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(forgotPasswordFrame, "Por favor, selecciona un método de recuperación.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
            forgotPasswordFrame.dispose();
        });
        panel.add(btnRecuperar, constraints);
    }

    private void connectToDatabase() {
        String url = "jdbc:mysql://localhost:2413/Proyecto_Escritorio_Java"; // Asegúrate de usar el puerto correcto
        String user = "root";
        String password = "109Inuyash@";
        try {
            connection = DriverManager.getConnection(url, user, password);
            JOptionPane.showMessageDialog(frame, "Conexión exitosa a la base de datos", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al conectar a la base de datos: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void verificarCredenciales(String username, String password) {
        String query = "SELECT contrasena FROM Usuarios WHERE usuario = ?";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String hashedPassword = resultSet.getString("contrasena");
                if (BCrypt.checkpw(password, hashedPassword)) {
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso!", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                    // Aquí puedes agregar la lógica para dirigir al usuario a la siguiente pantalla
                } else {
                    JOptionPane.showMessageDialog(frame, "Contraseña incorrecta.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(frame, "Usuario no encontrado.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Error al verificar las credenciales: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
