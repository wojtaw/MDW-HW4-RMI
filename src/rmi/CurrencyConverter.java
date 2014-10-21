package rmi;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;

public class CurrencyConverter extends UnicastRemoteObject implements CurrencyInterface {

    private static final long serialVersionUID = 1L;

    protected CurrencyConverter() throws RemoteException {
        super();
    }

    @Override
    public double convert(Currency from, Currency to, double amount) throws RemoteException {
        double exchangeRate = 1;
        if(from == Currency.EUR && to == Currency.GBP) exchangeRate = 0.791;
        else if(from == Currency.EUR && to == Currency.USD) exchangeRate = 1.27;
        else if(from == Currency.GBP && to == Currency.USD) exchangeRate = 1.61;
        else if(from == Currency.GBP && to == Currency.EUR) exchangeRate = 1.27;
        else if(from == Currency.USD && to == Currency.EUR) exchangeRate = 0.79;
        else if(from == Currency.USD && to == Currency.GBP) exchangeRate = 0.62;
        else exchangeRate = 1;
        return amount * exchangeRate;
    }

    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);

            CurrencyConverter server = new CurrencyConverter();
            Naming.rebind("//0.0.0.0/CurrencyConverter", server);
            System.out.println("Currency Converter Server started...");

        } catch (Exception e) {
            System.out.println("Error: " + e.getLocalizedMessage());
        }

    }

}