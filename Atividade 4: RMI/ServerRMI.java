import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class ServerRMI extends UnicastRemoteObject implements ServerInterface{
    private List<String> messageList;
    public ServerRMI() throws RemoteException {
        super();
        messageList = new ArrayList<>();
    }

    @Override
    public void storeMessage(String message) throws RemoteException {
        messageList.add(message);
    }

    @Override
    public List<String> getMessageList() throws RemoteException {
        return messageList;
    }

    @Override
    public String getServerIP() throws RemoteException {
        return "127.0.0.1";
    }

    @Override
    public String getServerDateTime() throws RemoteException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        return dateFormat.format(new Date());
    }

    public static void main(String[] args) {
        try {
            ServerRMI server = new ServerRMI();
            System.out.println("ServerRMI is running...");
            Naming.rebind("rmi://127.0.0.1:11099/RMIInterface", new ServerRMI());
        } catch (Exception e) {
            System.out.println("Trouble: " + e);
        }
    }
}