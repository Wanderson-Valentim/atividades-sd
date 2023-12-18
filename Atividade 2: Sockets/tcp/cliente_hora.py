import socket

sock = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
server_address = ('localhost', 20001)
print ("Conectando %s porta %s" % server_address)
#Conectando ao servidor
sock.connect(server_address)
   
message = input("Aperte ENTER para solicitar o horário")
#Enviando mensagem ao servidor
sock.sendall(b'')
data = sock.recv(2048)
print(data.decode())
sock.close()