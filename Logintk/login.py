from tkinter import Tk, Label, Button, Entry, Frame, StringVar, OptionMenu, messagebox
from PIL import Image, ImageTk

class Login:
    def __init__(self):
        self.ventana = Tk()
        self.ventana.geometry("400x700")
        self.ventana.title("Inicio de sesión - MiMovistar")

        # Colores
        fondo = "#FFFFFF"
        color_titulo = "#0cb7f2"

        # Crear frames
        self.frame_superior = Frame(self.ventana, bg=color_titulo)
        self.frame_superior.pack(fill="both", expand=True)

        self.frame_inferior = Frame(self.ventana, bg=fondo)
        self.frame_inferior.pack(fill="both", expand=True)

        # Crear título
        self.titulo = Label(self.frame_superior, text="MiMovistar", font=("Arial", 36), bg=color_titulo, fg="white")
        self.titulo.pack(pady=20)

        # Crear campos de entrada
        self.label_tipo_documento = Label(self.frame_inferior, text="Selecciona tu tipo de documento", font=("Arial", 18), bg=fondo, fg="black")
        self.label_tipo_documento.pack(pady=10)

        self.tipo_documento = StringVar(self.ventana)  # Aquí estaba el error
        self.tipo_documento.set("DNI")  # Valor por defecto
        self.menu_tipo_documento = OptionMenu(self.frame_inferior, self.tipo_documento, "DNI", "Pasaporte", "Carnet de extranjería")
        self.menu_tipo_documento.pack(pady=10)

        self.label_numero_documento = Label(self.frame_inferior, text="Número de documento", font=("Arial", 18), bg=fondo, fg="black")
        self.label_numero_documento.pack(pady=10)
        self.entry_numero_documento = Entry(self.frame_inferior, bd=0, width=14, font=("Arial", 18), bg="#FFFFFF")
        self.entry_numero_documento.pack(pady=10)

        self.label_contraseña = Label(self.frame_inferior, text="Contraseña", font=("Arial", 18), bg=fondo, fg="black")
        self.label_contraseña.pack(pady=10)
        self.entry_contraseña = Entry(self.frame_inferior, bd=0, width=14, font=("Arial", 18), show="*",bg="#FFFFFF")
        self.entry_contraseña.pack(pady=10)

        # Crear botones
        self.boton_ingresar = Button(self.frame_inferior, text="Ingresar", font=("Arial", 18), bg="#FFFFFF", fg="black", command=self.ingresar)
        self.boton_ingresar.pack(pady=35)

        self.ventana.mainloop()

    def ingresar(self):  # Esta función debe estar dentro de la clase
        tipo_documento = self.tipo_documento.get()
        numero_documento = self.entry_numero_documento.get()
        contraseña = self.entry_contraseña.get()
        if tipo_documento == "DNI":
            if numero_documento == "60797472":              
                messagebox.showinfo("Registro", "Bienvenido a Movistar Atencion al cliente")
            else:
                messagebox.showerror("Error", "Usuario o contraseña incorrectos")
            if contraseña == "<109Inuyash@>":
                self.ventana.destroy()
        elif tipo_documento == "Pasaporte":
            if numero_documento == "60797472":
                messagebox.showinfo("Registro", "Bienvenido a Movistar Atencion al cliente")
            if contraseña == "<109Inuyash@>":
                messagebox.showinfo("Login", "Bienvenido a Movistar Atencion al cliente")
            else:
                messagebox.showerror("Error", "Usuario o contraseña incorrectos")
        elif tipo_documento == "Carnet de extranjería":
            if contraseña == "<PASSWORD>":
                messagebox.showinfo("Login", "Bienvenido a Movistar Atencion al cliente")
            else:
                messagebox.showerror("Error", "Usuario o contraseña incorrectos")
                self.ventana.destroy()


Login()
