package com.epamTasks.serialization;

import java.math.BigDecimal;
import java.util.Map;
import java.util.Objects;

public class Order {
    private Long id;
    private transient BigDecimal total;
    private Map<Item, Integer> items;

    public Order(Long id, Map<Item, Integer> items) {
        this.id = id;
        this.total = null;
        this.items = items;
    }

    public BigDecimal getTotal() {
        if (items == null) {
            return BigDecimal.ZERO;
        }
        if (total == null) {
            BigDecimal sum = BigDecimal.ZERO;
            for (Map.Entry<Item, Integer> entry : items.entrySet()) {
                Item item = entry.getKey();
                Integer quantity = entry.getValue();
                sum = sum.add(item.getPrice().multiply(BigDecimal.valueOf(quantity)));
            }
            total = sum;
        }
        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Map<Item, Integer> getItems() {
        return items;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return Objects.equals(id, order.id) && Objects.equals(items, order.items);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, items);
    }
}
