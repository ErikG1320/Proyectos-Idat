# Programa en Python para verificar si un número es par o impar

# Pedir al usuario un número entero
numero = int(input("Por favor, introduce un número entero: "))

# Verificar si el número es par o impar
if numero % 2 == 0:
    print("El número", numero, "es par.")
else:
    print("El número", numero, "es impar.")
