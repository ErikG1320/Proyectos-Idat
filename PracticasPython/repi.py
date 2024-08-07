#Escribir un programa que muestre el eco de todo lo que el usuario introduzca hasta que el usuario escriba “salir” que terminará.

while True:
    entrada = input("Introduce algo: ")
    if entrada.lower() == "salir":
        break
    else:
        print(entrada)