# dia = str(input("Ingrese un día: "))
# match dia:
#     case 'lunes':
#         print("Es un día laboral")
#     case 'martes':
#         print("Es un día laboral")
#     case 'miércoles':
#         print("Es un día laboral")
#     case 'jueves':
#         print("Es un día laboral")
#     case 'viernes':
#         print("Es un día laboral")
#     case 'sábado':
#         print("No es día laboral")  # Línea corregida
#     case 'domingo':
#         print("No es día laboral")


dia=str(input("Ingrese el dia en que trabaja"))
def switch_demo(dia):
    match dia:
        case 'lunes':
            return "Es un día laboral"
        case 'martes':
            return "Es un día laboral"
        case 'miércoles':
            return "Es un día laboral"
        case 'jueves':
            return "Es un día laboral"
        case 'viernes':
            return "Es un día laboral"
        case 'sábado':
            return "No es día laboral"
        case 'domingo':
            return "No es día laboral"
        case _:
            return "Día no reconocido"

# print(switch_demo('lunes'))  # Salida: Es un día laboral
