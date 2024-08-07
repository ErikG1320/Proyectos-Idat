import tkinter as tk
from tkinter import *

class Panel:
    def __init__(self):
        # Crear la ventana principal
        self.ventana = tk.Tk()
        self.ventana.geometry("300x600") 
        self.ventana.title("Panel de Atención y Modificaciones")

        # Definir colores para el fondo del panel
        fondo_celeste = "#0cb7f2"

        self.frame_superior = Frame(self.ventana, bg=fondo_celeste)
        self.frame_superior.pack(fill="both", expand=True)

        self.frame_inferior = Frame(self.ventana, bg=fondo_celeste)
        self.frame_inferior.pack(fill="both", expand=True)

        # Crear los botones y añadirlos a la ventana
        Button(self.frame_superior, text="Modificacion de servicios", command=self.modificar_servicios).grid(row=0, column=0, sticky=W, padx=5)
        Button(self.frame_superior, text="Reconexion de servicios", command=self.reconectar_servicios).grid(row=0, column=1, sticky=E, padx=5)
        Button(self.frame_superior, text="Soporte de servicios", command=self.soporte_servicios).grid(row=1, column=0, sticky=W, padx=5)
        Button(self.frame_superior, text="Renovación de equipos", command=self.renovar_equipos).grid(row=1, column=1, sticky=E, padx=5)

        # Crear el menú
        self.menu = Menu(self.ventana)
        self.ventana.config(menu=self.menu)
        self.opciones_menu = Menu(self.menu)
        self.menu.add_cascade(label="Notificaciones", menu=self.opciones_menu)


        # Crear el botón de asistente de voz
        Button(self.ventana, text="Asistente de voz", bg="#00BFFF", command=self.asistente_voz).pack(side=BOTTOM)

    def modificar_servicios(self):
        print("Modificando servicios...")

    def reconectar_servicios(self):
        print("Reconectando servicios...")

    def soporte_servicios(self):
        print("Proporcionando soporte...")

    def renovar_equipos(self):
        print("Renovando equipos...")
    def asistente_voz(self):
        print("Activando asistente de voz...")

# Crear una instancia de la clase Panel y ejecutar la ventana
panel = Panel()
panel.ventana.mainloop()
