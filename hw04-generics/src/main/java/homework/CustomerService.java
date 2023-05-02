package homework;


import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.TreeMap;

public class CustomerService {

	private final NavigableMap<Customer, String> customerMap = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

	public Map.Entry<Customer, String> getSmallest() {
		return deepCopyEntry(customerMap.firstEntry());
	}

	public Map.Entry<Customer, String> getNext(Customer customer) {
		return deepCopyEntry(customerMap.higherEntry(customer));
	}

	public void add(Customer customer, String data) {
		customerMap.put(customer, data);
	}

	private Map.Entry<Customer, String> deepCopyEntry(Map.Entry<Customer, String> entry) {
		if (entry != null) {
			return new Map.Entry<>() {
				@Override
				public Customer getKey() {
					return entry.getKey().clone();
				}

				@Override
				public String getValue() {
					return entry.getValue();
				}

				@Override
				public String setValue(String s) {
					throw new UnsupportedOperationException();
				}
			};
		} else {
			return null;
		}
	}
}
