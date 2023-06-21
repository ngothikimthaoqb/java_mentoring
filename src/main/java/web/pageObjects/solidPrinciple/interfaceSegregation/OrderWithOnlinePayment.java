package web.pageObjects.solidPrinciple.interfaceSegregation;

public class OrderWithOnlinePayment extends Order implements IPaymentOnline {

    @Override
    public Boolean makePaymentByCC(double amount) {
        return true;
    }

    @Override
    public Boolean makePaymentByBank(double amount) {
        return true;
    }
}
