import xmlrpc.client

# Local server
local_server = xmlrpc.client.ServerProxy('http://localhost:21212')

# Accessing functions of the local server
print("Local Server:")
print("Current Date and Time:", local_server.getDateTime())
print("Call Count:", local_server.getCallCount())
