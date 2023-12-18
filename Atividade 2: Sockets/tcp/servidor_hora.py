import socket
import threading
from datetime import datetime

def conexao_cliente(client,address):  
    current_time = datetime.now().strftime('%H:%M:%S')
    client.sendall(current_time.encode())
    client.close()

sock = socket.socket(socket.AF_INET,  socket.SOCK_STREAM)
    
sock.setsockopt(socket.SOL_SOCKET, socket.SO_REUSEADDR, 1)

server_address = ('localhost', 20001)
print ("Iniciando servidor na porta %s %s" % server_address)
#Reservando porta
sock.bind(server_address)
#Escutando na porta reservada
sock.listen(1)

#Iniciando protocolo

while True:
    client, address = sock.accept()
    conexao = threading.Thread(target=conexao_cliente,args=(client,address,))
    conexao.start()