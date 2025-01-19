package homework;

import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class CustomerService {

    public final SortedMap<Customer, String> customers = new TreeMap<>();

    public Map.Entry<Customer, String> getSmallest() {
        final Map.Entry<Customer, String> entry = customers.firstEntry();
        return Map.entry(
                new Customer(
                        entry.getKey().getId(),
                        entry.getKey().getName(),
                        entry.getKey().getScores()),
                entry.getValue());
    }

    /**
     * не понял как нужно было "правильно" это выполнить
     */
    public Map.Entry<Customer, String> getNext(Customer customer) {
        final Map.Entry<Customer, String> entry = customers.entrySet().stream()
                .filter(it -> it.getKey().getScores() > customer.getScores())
                .findFirst()
                .orElse(null);
        if (entry == null) {
            return null;
        }
        return Map.entry(
                new Customer(
                        entry.getKey().getId(),
                        entry.getKey().getName(),
                        entry.getKey().getScores()),
                entry.getValue());
    }

    public void add(Customer customer, String data) {
        customers.put(customer, data);
    }
}
