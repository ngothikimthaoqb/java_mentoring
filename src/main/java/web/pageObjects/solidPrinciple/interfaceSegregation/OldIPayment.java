package web.pageObjects.solidPrinciple.interfaceSegregation;

public interface OldIPayment {
    //Online
    Boolean makePaymentByCC(double amount);
    Boolean makePaymentByBank(double amount);

    // Offline
    Boolean makePaymentByCash(double amount);
}
