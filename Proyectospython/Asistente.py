import webbrowser
import os
import speech_recognition as sr
import pyttsx3
import datetime
import pywhatkit

# Inicialización del motor de voz
engine = pyttsx3.init()
voices = engine.getProperty('voices')
engine.setProperty('voice', voices[0].id)

def talk(text):
    engine.setProperty('rate', 130)  # Ajusta la velocidad de la voz
    engine.setProperty('volume', 1.2)  # Ajusta el volumen de la voz
    engine.say(text)
    engine.runAndWait()

def get_command():
    r = sr.Recognizer()
    with sr.Microphone() as source:
        print("Estoy escuchando...")
        r.pause_threshold = 1  # Espera un segundo antes de escuchar el comando del usuario
        audio = r.listen(source)
        try:
            command = r.recognize_google(audio, language='es-ES')
            print(f"Has dicho: {command}\n")
        except sr.UnknownValueError:
            talk("Lo siento, no pude entender eso. Por favor, repite el comando.")
            return ""
        except sr.RequestError as e:
            talk("Lo siento, hay un problema con el servicio de reconocimiento de voz. Por favor, inténtalo de nuevo más tarde.")
            print(f"Se produjo un error: {e}")
            return ""
        return command.lower()

def open_website():
    command = get_command()
    if 'abre' in command:
        website = command.replace('abre', '')
        webbrowser.open_new_tab(f"https://{website}.com")
        talk(f"Abriendo {website}")

def weather_forecast():
    command = get_command()
    if 'pronostico del tiempo' in command:
        talk(f"Pronóstico del tiempo para la ciudad de {command.replace('pronostico', '')}")
        webbrowser.open_new_tab(f"")

def system_info():
    talk(f"Sistema operativo: {os.name}")
    talk(f"Versión del sistema operativo: {os.uname().release}")
    talk(f"Directorio actual: {os.getcwd()}")
    talk(f"Directorio de usuario: {os.path.expanduser('~')}")

def run_alexa():
    command = get_command()
    if 'hola' in command:
        talk("Hola, ¿cómo puedo ayudarte hoy?")
    elif 'salir del asistente' in command:
        talk("Salir del asistente ")
        exit()
    elif 'qué hora es' in command:
        talk(datetime.datetime.now().strftime("%H:%M:%S"))
    elif 'qué día es' in command:
        talk(datetime.datetime.now().strftime("%A"))
    elif 'qué fecha es hoy' in command:
        talk(datetime.datetime.now().strftime("%d/%m/%Y"))
    elif 'busca en google' in command:
        search=command.replace('buscar en google','')
        talk('buscando' + search)
        pywhatkit.search(search)
    elif 'busca en youtube' in command:
        search=command.replace('buscar en youtube','')
        talk('buscando' + search)
        pywhatkit.search(search)
    elif 'busca en wikipedia' in command:
        search=command.replace('buscar en wikipedia','')
        talk('buscando' + search)
        pywhatkit.search(search)
    elif 'busca en facebook' in command:
        search=command.replace('buscar en facebook','')
        talk('buscando' + search)
        pywhatkit.search(search)
    elif 'busca en spotify' in command:
        search=command.replace('buscar en spotify','')
        talk('buscando' + search)
        pywhatkit.search(search)
    elif 'abre' in command:
        open_website()
    elif 'pronóstico del tiempo' in command:
        weather_forecast()
    elif 'información del sistema' in command:
        system_info()
    else:
        talk("Lo siento, no reconozco ese comando. Por favor, inténtalo de nuevo.")

while True:
    run_alexa()
