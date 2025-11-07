# subprocess se usa para ejecutar comando externos.
# ipaddress se usa para trabajar con redes y direcciones ip.
import subprocess, ipaddress

# ThreadPoolExecutor se usa para ejecutar tareas en paralelo.
# as_completed se usa para procesar resultados inmediatamente.
from concurrent.futures import ThreadPoolExecutor, as_completed

# Rango de IP (ajusta según tu red).
red = ipaddress.ip_network("192.168.1.0/24", strict=False)

def ping(ip):
    # Pasamos las ip a formato string.
    ip = str(ip)
    # Creamos el comando, -n 1 enviamos un paquete, -w 500 tinmeout de 500 milisegundos.
    cmd = ["ping", "-n", "1", "-w", "500", ip]

    # Ejecutamos el comando
    # stdout=subprocess.PIPE captura la salida del comando para poder ejecutarla
    # stderr=subprocess.DEVNULL descarta los errores
    # text=True hace que res.stdout sea un str.
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.DEVNULL, text=True)
    # Busca en la salida del ping el texto TTL= (Windows). Si aparece, normalmente significa que hubo respuesta.
    if "TTL=" in res.stdout or "ttl=" in res.stdout:
        return ip
    else:
        return None

# Lista donde vamos a guardas las ip del comando ping.
activos = []
# Crea un pool de hasta 100 hilos concurrentes, with asegura que el executor se cierre correctamente al terminar.
with ThreadPoolExecutor(max_workers=100) as ex:
    # Programa la ejecución de ping(ip).
    futuros = {ex.submit(ping, ip): ip for ip in red.hosts()}
    # Itera sobre los Future a medida que van finalizando, no en el orden en que fueron lanzados, esto permise la inmediatez.
    for fut in as_completed(futuros):
        # Devuelve lo que devolvió la función ping.
        ip_ok = fut.result()
        # Si ip_ok no es None, añadimos la IP a activos y la imprimimos.
        if ip_ok:
            activos.append(ip_ok)
            print(f"✅ Dispositivo activo: {ip_ok}")
