package web.pageObjects.solidPrinciple.interfaceSegregation;

public class OrderWithOfflinePayment extends Order implements IPaymentOffline {
    
    @Override
    public Boolean MakePaymentByCash(double amount) {
        return true;
    }
}
