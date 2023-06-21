package web.pageObjects.solidPrinciple.interfaceSegregation;

public abstract class Order {
    private int orderId;

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public int CreateOrder(int orderId)
    {
        return orderId;
    }
}
