import tkinter as tk
import random

# Generar un número aleatorio entre 1 y 100
resultado = random.randint(1, 100)
intentos = 0

def verificar_suposicion():
    global intentos
    try:
        suposicion = int(entry.get())
        intentos += 1
        if suposicion == resultado:
            label.config(text=f"¡Correcto! Adivinaste en {intentos} intentos.")
        elif suposicion < resultado:
            label.config(text="Demasiado bajo. Inténtalo de nuevo.")
        else:
            label.config(text="Demasiado alto. Inténtalo de nuevo.")
    except ValueError:
        label.config(text="Ingresa un número válido.")

# Crear la ventana
root = tk.Tk()
root.title("Adivina el Número")

# Etiqueta
label = tk.Label(root, text="Adivina el número (entre 1 y 100):")
label.pack()

# Campo de entrada
entry = tk.Entry(root)
entry.pack()

# Botón
button = tk.Button(root, text="Verificar", command=verificar_suposicion)
button.pack()

root.mainloop()
