package cleancode.missons.day4;

import java.util.Collections;
import java.util.List;

public class Order {
    private List<Item> items;
    private Customer customer;

    private Order(List<Item> items, Customer customer) {
        this.items = items == null ? Collections.emptyList() : items;
        this.customer = customer != null && customer.hasCustomerInfo() ? customer : Customer.of();

    }

    public static Order of(List<Item> items, Customer customer) {
        return new Order(items, customer);
    }

    public boolean validateOrder() throws OrderException {
        if (hasNoItems()) {
            throw new OrderException("주문 항목이 없습니다.");
        }
        if (isNotPriceValidate()) {
            throw new OrderException("올바르지 않은 총 가격입니다.");
        }
        if (hasNoCostumerInfo()) {
            throw new OrderException("사용자 정보가 없습니다.");
        }
        return true;
    }

    private boolean hasNoItems() {
        return !hasItems();
    }

    private boolean hasItems() {
        return getItemsCount() > 0;
    }

    private int getItemsCount() {
        return items.size();
    }

    private boolean hasCustomerInfo() {
        return customer != null && customer.hasCustomerInfo();
    }

    private boolean hasNoCostumerInfo() {
        return !hasCustomerInfo();
    }

    private boolean isPriceValidate() {
        return getTotalPrice() > 0;
    }

    private boolean isNotPriceValidate() {
        return !isPriceValidate();
    }

    private int getTotalPrice() {
        return items.stream().mapToInt(Item::getPrice)
                .sum();
    }
}
