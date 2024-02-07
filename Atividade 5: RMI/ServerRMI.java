import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerRMI extends UnicastRemoteObject implements ConverterInterface{
    private static double EURO_TO_REAL_RATE = 5.35;
    private static double REAL_TO_EURO_RATE = 0.19;
    private static double DOLLAR_TO_REAL_RATE = 4.97;
    private static double REAL_TO_DOLLAR_RATE = 0.20;

    public ServerRMI() throws RemoteException {
        super();
    }

    @Override
    public double convertEuroToReal(double euroAmount) throws RemoteException {
        return euroAmount * EURO_TO_REAL_RATE;
    }

    @Override
    public double convertRealToEuro(double realAmount) throws RemoteException {
        return realAmount * REAL_TO_EURO_RATE;
    }

    @Override
    public double convertDollarToReal(double dollarAmount) throws RemoteException {
        return dollarAmount * DOLLAR_TO_REAL_RATE;
    }

    @Override
    public double convertRealToDollar(double realAmount) throws RemoteException {
        return realAmount * REAL_TO_DOLLAR_RATE;
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