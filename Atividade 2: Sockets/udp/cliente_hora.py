import socket

sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
server_address = ('localhost', 20001)
   
message = input("Aperte ENTER para solicitar o horário")
#Enviando mensagem ao servidor
sock.sendto(b'', server_address)
data = sock.recv(2048)
print(data.decode())
sock.close()