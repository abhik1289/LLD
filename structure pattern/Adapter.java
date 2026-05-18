
class Paypal {
    public void makePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through PayPal.");
    }
}

class Stripe {

    public void executePayment(double amount) {
        System.out.println("Processing payment of $" + amount + " through Stripe.");
    }
}

class Razarpay {
    public void pay(double amount) {
        System.out.println("Processing payment of $" + amount + " through Razorpay.");
    }
}

interface PaymentGateway {
    void processPayment(double amount);
}

class PaypalAdapter implements PaymentGateway {
    private Paypal paypal;

    public PaypalAdapter() {
        this.paypal = new Paypal();
    }

    @Override
    public void processPayment(double amount) {
        paypal.makePayment(amount);
    }
}

class StripeAdapter implements PaymentGateway {
    private Stripe stripe;

    public StripeAdapter() {
        this.stripe = new Stripe();
    }

    @Override
    public void processPayment(double amount) {
        stripe.executePayment(amount);
    }
}

class RazarpayAdapter implements PaymentGateway {
    private Razarpay razorpay;

    public RazarpayAdapter() {
        this.razorpay = new Razarpay();
    }

    @Override
    public void processPayment(double amount) {
        razorpay.pay(amount);
    }
}

public class Adapter {
    public static void main(String[] args) {

        PaymentGateway paypalAdapter = new PaypalAdapter();
        PaymentGateway stripeAdapter = new StripeAdapter();
        PaymentGateway razorpayAdapter = new RazarpayAdapter();

        paypalAdapter.processPayment(100.0);
        stripeAdapter.processPayment(200.0);
        razorpayAdapter.processPayment(300.0);

    }
}
