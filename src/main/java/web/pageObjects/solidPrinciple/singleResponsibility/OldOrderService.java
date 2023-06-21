package web.pageObjects.solidPrinciple.singleResponsibility;

public class OldOrderService {
    public String createOrder(String OrderDetails)
    {
        String OrderId = "";
        //Code to Create Order
        return OrderId;
    }

    public Boolean makePayment(String OrderId)
    {
        //Code to Make Payment
        return true;
    }

    public Boolean generateInvoice(String OrderId)
    {
        //Code to Generate Invoice
        return true;
    }

    public Boolean emailInvoice(String OrderId)
    {
        //Code to Email Invoice
        return true;
    }
}
