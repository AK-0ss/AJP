
//Palindrome.java
import java.rmi.*;
public interface Palindrome extends Remote {
    boolean isPalindrome(String input) throws RemoteException;
}

// PalindromeImpl.java
import java.rmi.*;
import java.rmi.server.*;

public class PalindromeImpl extends UnicastRemoteObject implements Palindrome {
    public PalindromeImpl() throws RemoteException {}

    public boolean isPalindrome(String input) {
        String clean = input.replaceAll("\\s", "").toLowerCase();
        return clean.equals(new StringBuilder(clean).reverse().toString());
    }

    public static void main(String args[]) throws Exception {
        PalindromeImpl obj = new PalindromeImpl();
        Naming.rebind("rmi://localhost:5000/pal", obj);
        System.out.println("Server ready...");
    }
}

//PalindromeClient.java
import java.rmi.*;

public class PalindromeClient {
    public static void main(String args[]) {
        try {
            Palindrome stub = (Palindrome) Naming.lookup("rmi://localhost:5000/pal");
            System.out.println("Is Palindrome? " + stub.isPalindrome("Madam"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

