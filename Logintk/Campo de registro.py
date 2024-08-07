from tkinter import *
from tkinter import messagebox

class Registro:
    def __init__(self):
        # Crear una ventana
        self.ventana = Tk()
        self.ventana.geometry("300x600")  # Configurar el tamaño de la ventana para un tamaño de pantalla móvil más pequeño
        self.ventana.title("Registro de Solicitud")  # Configurar el título de la ventana

        # Definir colores
        color = "#0cb7f2"
        color_boton = "#ff0000"  # Color rojo para los botones
        
        self.frame_superior = Frame(self.ventana, bg=color)
        self.frame_superior.pack(fill="both", expand=True)

        self.frame_inferior = Frame(self.ventana, bg=color)
        self.frame_inferior.pack(fill="both", expand=True)

        # Crear campos de entrada
        self.campos = ['Número de teléfono', 'Dni', 'Tipo de servicio en falla','Descripcion en falla']
        for i in range(len(self.campos)):
            # Crear una etiqueta para cada campo y agregarla al marco superior
            Label(self.frame_superior, text=self.campos[i], bg=color).grid(row=i*2, column=0, sticky=W, pady=10)
            # Crear un campo de entrada para cada campo y agregarlo al marco superior
            Entry(self.frame_superior).grid(row=i*2+1, column=0, sticky=E)

        # Crear botones de enviar y cancelar
        Button(self.frame_inferior, text="Siguiente", command=self.registrar).grid(row=0, column=0, sticky=W, padx=5)
        Button(self.frame_inferior, text="Cancelar", command=self.cancelar).grid(row=0, column=1, sticky=E, padx=5)

        # Crear botones adicionales
        Button(self.frame_inferior, text="Inicio", bg=color_boton).grid(row=3, column=0, sticky=W, padx=5)
        Button(self.frame_inferior, text="Panel de atención", bg=color_boton).grid(row=3, column=1, sticky=W, padx=5)
        Button(self.frame_inferior, text="Canales Movistar", bg=color_boton).grid(row=3, column=2, sticky=W, padx=5)
        Button(self.frame_inferior, text="Salir", bg=color_boton).grid(row=3, column=3, sticky=W, padx=5)
        
        self.ventana.mainloop()  # Iniciar el bucle principal de la ventana

    def registrar(self):
        # Mostrar un mensaje de información cuando se presiona el botón "Registrar"
        messagebox.showinfo("Registro", "Se ha registrado con éxito")

    def cancelar(self):
        # Mostrar un mensaje de información cuando se presiona el botón "Cancelar" y  se cierra la ventana
        messagebox.showinfo("Registro", "Se ha cancelado exitosamente")

Registro()  # Crear una instancia de la clase Registro
