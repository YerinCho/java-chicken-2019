package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Orders {
    private final List<Order> orders = new ArrayList<>();

    public Orders() {
    }

    public void orderMenu(Order order) {
        if (isNotOrderedMenu(order)) {
            orders.add(order);
            return;
        }
        orders.stream()
                .filter(menu -> menu.isMenuSame(order))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("잘못된 주문입니다."))
                .orderMore(order);
    }

    private boolean isNotOrderedMenu(Order order) {
        return orders.stream()
                .noneMatch(menu -> menu.isMenuSame(order));
    }

    public boolean isOrderEmpty() {
        return orders.isEmpty();
    }

    //Todo 이름마음에안듬
    public int getOrderedMenuSize() {
        return orders.size();
    }

    List<Order> getOrders() {
        return Collections.unmodifiableList(orders);
    }
}
