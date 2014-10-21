package rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CurrencyInterface extends Remote{
    public double convert(Currency from, Currency to, double amount) throws RemoteException;
}