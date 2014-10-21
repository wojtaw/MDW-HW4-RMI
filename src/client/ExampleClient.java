package client;

import rmi.Currency;
import rmi.CurrencyInterface;

import java.rmi.Naming;
/**
 * Created by WojtawDesktop on 21.10.14.
 */
public class ExampleClient {

    public static void main(String[] args) throws Exception{
        CurrencyInterface currencyConverter = (CurrencyInterface)Naming.lookup("//localhost/CurrencyConverter");
        System.out.println("10 EUR is "+currencyConverter.convert(Currency.EUR,Currency.GBP,10)+" GBP");
        System.out.println("10 EUR is "+currencyConverter.convert(Currency.EUR,Currency.USD,10)+" USD");
        System.out.println("10 USD is "+currencyConverter.convert(Currency.USD,Currency.GBP,10)+" GBP");
        System.out.println("10 GBP is "+currencyConverter.convert(Currency.GBP,Currency.EUR,10)+" EUR");
    }
}
