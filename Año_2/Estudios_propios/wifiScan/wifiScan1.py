import os
import ipaddress

# Rango de IP (ajusta según tu red).
red = ipaddress.ip_network("192.168.1.0/24", strict=False)

# Creamos un bucle para ir recorriendo todas las ip encontradas.
for ip in red.hosts():
    # Pasamos las ip a formato string.
    ip = str(ip)
    respuesta = os.popen(f"ping -n 1 -w 200 {ip}").read()
    
    if "TTL=" in respuesta:
        print(f"✅ Dispositivo activo: {ip}")
