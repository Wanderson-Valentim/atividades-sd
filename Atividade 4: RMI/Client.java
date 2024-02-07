import java.rmi.Naming;
import java.util.List;

public class Client {
  public static void main(String[] args) {
    try {
      ServerInterface server = (ServerInterface) Naming.lookup("rmi://127.0.0.1:11099/RMIInterface");

      //Armazenar uma string na lista
      server.storeMessage("String 1");
      server.storeMessage("String 2");

      //Recuperar lista de mensagens
      List<String> messages = server.getMessageList();
      for (String message : messages) {
          System.out.println("Message: " + message);
      }

      //Recuperar lista de mensagens
      System.out.println("Server IP: " + server.getServerIP());

      //Retornar data e hora do servidor no formato: YYYY-MM-DD HH:MM
      System.out.println("Server Date and Time: " + server.getServerDateTime());
    }
    catch (Exception e) {
      System.out.println("Trouble: " + e);
    }
  }
}