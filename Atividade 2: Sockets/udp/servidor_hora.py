import socket
import threading
from datetime import datetime

def conexao_cliente(data,address):  
    current_time = datetime.now().strftime('%H:%M:%S')
    sock.sendto(current_time.encode(), address)

sock = socket.socket(socket.AF_INET,  socket.SOCK_DGRAM)
    
sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

server_address = ('localhost', 20001)
print ("Iniciando servidor na porta %s %s" % server_address)
#Reservando porta
sock.bind(server_address)

#Iniciando protocolo
while True:
    data, address = sock.recvfrom(1024)
    conexao = threading.Thread(target=conexao_cliente,args=(data,address,))
    conexao.start()