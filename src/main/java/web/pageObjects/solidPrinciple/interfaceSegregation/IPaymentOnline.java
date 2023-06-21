package web.pageObjects.solidPrinciple.interfaceSegregation;

public interface IPaymentOnline
{
    Boolean makePaymentByCC(double amount);
    Boolean makePaymentByBank(double amount);
}
