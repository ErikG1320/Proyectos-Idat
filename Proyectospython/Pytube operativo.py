from pytube import YouTube
import os
from tkinter import *
from tkinter import messagebox as MessageBox
#Sirve para crear la ventana
root=Tk()
#Sirve para crear un borde de 15 px
root.config(bd=15)
#Le asignamos el titulo al programa
root.title("Programa diseñado para descargar videos")

def accion():
    enlace=videos.get()
    video=YouTube(enlace)
    descarga=video.streams.get_highest_resolution()
    descarga.download()
def popup():
    MessageBox.showinfo("Informacion del autor","Erik")

#le una imagen y que este en el mismo directorio
Imagen=PhotoImage(file="Trabajos/YouTube.png")
#creamos una variable llamada foto y le asgnamos un widget de tipo label y estara en root que va reciger la imagen antes cargada
foto=Label(root,image=Imagen,bd=0)
#Etablecemos la posicion en la variable foto donde esta el widget de tipo label y la ubicacion que sirve para asignar la posicion en la fila 0 y el columna 0
foto.grid(row=0,column=0)
#Creamos un widget de tipo menu
menubar=Menu(root)
root.config(menu=menubar)
helpmenu = Menu(menubar,tearoff=0)

#Creamos un menúbar de tipo cascada ,luego colocamos el widget para mas informacion
menubar.add_cascade(label="Para mas informacion",menu=help)
helpmenu.add_cascade(label="Informacion del autor",command=popup)
menubar.add_command(label="Salir",command=root.destroy)

instrucciones=Label(root,text="Programa creado para descargar videos de youtube\n")
instrucciones.grid(row=0,column=1)


#Creamos una variable videos que no permitira ingresar el linkpara descaragar
videos =Entry(root)
#Indicamos la fila y la columna
videos.grid(row=1,column=1)
#Creamos un widget de tipo button y llmaremos a una funcion de de tipo accion
boton=Button(root,text="Descargar",command=accion)
boton.grid(row=2,column=1)

root.mainloop()
