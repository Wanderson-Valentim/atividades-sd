import java.rmi.Naming;
import java.util.Scanner;

public class Client {
  public static void main(String[] args) {
    
    try {
      ConverterInterface server = (ConverterInterface) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");
      Scanner scanner = new Scanner(System.in);
      
      System.out.print("Euro to Real - Enter the amount in Euro: ");
      double euroAmount = scanner.nextDouble();
      System.out.println("Converted to Real: " + server.convertEuroToReal(euroAmount));
      
      System.out.print("Real to Euro - Enter the amount in Real: ");
      double realAmount = scanner.nextDouble();
      System.out.println("Converted to Euro: " + server.convertRealToEuro(realAmount));
      
      System.out.print("Dollar to Real - Enter the amount in Dollar: ");
      double dollarAmount = scanner.nextDouble();
      System.out.println("Converted to Real: " + server.convertDollarToReal(dollarAmount));
      
      System.out.print("Real to Dollar - Enter the amount in Real: ");
      realAmount = scanner.nextDouble();
      System.out.println("Converted to Dollar: " + server.convertRealToDollar(realAmount));
    }
    catch (Exception e) {
      System.out.println("Trouble: " + e);
    }
  }
}