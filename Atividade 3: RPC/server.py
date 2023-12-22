from xmlrpc.server import SimpleXMLRPCServer
from xmlrpc.server import SimpleXMLRPCRequestHandler

# Restrict to a particular path.
class RequestHandler(SimpleXMLRPCRequestHandler):
    rpc_paths = ('/RPC2',)

# Create server
with SimpleXMLRPCServer(('localhost', 21212), requestHandler=RequestHandler) as server:
    server.register_introspection_functions()

    # Global variables to keep track of call count
    call_count = 0

    # Function to get current date and time
    def get_date_time():
        import datetime
        return datetime.datetime.now().strftime("%Y-%m-%d %H:%M:%S")

    # Function to count the number of calls
    def get_call_count():
        global call_count
        call_count += 1
        return call_count

    # Register functions
    server.register_function(get_date_time, 'getDateTime')
    server.register_function(get_call_count, 'getCallCount')

    # Run the server's main loop
    print("Server running on localhost:21212")
    server.serve_forever()
