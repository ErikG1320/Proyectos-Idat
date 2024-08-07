// login.js
document.getElementById('login-form').addEventListener('submit', async (e) => {
    e.preventDefault();
    const username = document.getElementById('username').value;
    const password = document.getElementById('password').value;

    // Aquí puedes realizar una solicitud al servidor para verificar las credenciales
    // y redirigir al usuario si son válidas.
    
    // Por ahora, simplemente muestra un mensaje en la consola.
    console.log(`Usuario: ${username}, Contraseña: ${password}`);
});
