package homework;

import java.util.LinkedList;

@SuppressWarnings("java:S1319")
public class CustomerReverseOrder {

    public final LinkedList<Customer> customers = new LinkedList<>();

    public void add(Customer customer) {
        customers.add(customer);
    }

    public Customer take() {
        final Customer last = customers.pollLast();
        return new Customer(last.getId(), last.getName(), last.getScores());
    }
}
