
interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {

    private String cardNumber;
    private String cardHolderName;

    public CreditCardPayment(String cardNumber, String cardHolderName) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
    }

    @Override
    public void pay() {
        System.out.println(
                "Paying with credit card for card number: " + cardNumber + " and card holder name: " + cardHolderName);
    }
}

class UpiPayment implements PaymentStrategy {

    private String upiId;

    public UpiPayment(String upiId) {
        this.upiId = upiId;
    }

    @Override
    public void pay() {
        System.out.println("Paying with UPI for UPI ID: " + upiId);
    }
}

class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout() {
        if (paymentStrategy != null) {
            paymentStrategy.pay();
        } else {
            System.out.println("No payment strategy selected.");
        }
    }
}

public class StrategyPattern {
    public static void main(String[] args) {
        ShoppingCart creditCard = new ShoppingCart();
        creditCard.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        creditCard.checkout();
    }
}
