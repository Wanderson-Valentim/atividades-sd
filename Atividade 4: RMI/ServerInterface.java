import java.rmi.*;
import java.util.List;

public interface ServerInterface extends Remote {
  public void storeMessage(String message) throws RemoteException;
  public List<String> getMessageList() throws RemoteException;
  public String getServerIP() throws RemoteException;
  public String getServerDateTime() throws RemoteException;
}