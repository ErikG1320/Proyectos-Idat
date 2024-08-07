import string
import secrets

def generar_contrasena(longitud):
    # Define el alfabeto de la contraseña (letras mayúsculas, minúsculas y dígitos)
    alfabeto = string.ascii_letters + string.digits

    # Utiliza el módulo secrets para generar una contraseña segura
    contrasena = ''.join(secrets.choice(alfabeto) for i in range(longitud))

    return contrasena

# Prueba la función con una longitud de 20
contrasena = generar_contrasena(20)
print("Tu nueva contraseña es: ", contrasena)
