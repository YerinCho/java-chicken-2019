package controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();

    public boolean run() throws IllegalAccessException {
        try {
            MainType mainType = selectMain();
            return runPos(mainType);
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return true;
        }
    }

    private Boolean runPos(MainType mainType) throws IllegalAccessException {
        if (MainType.ORDER.equals(mainType)) {
            Table table = selectTable();
            order(table);
            return true;
        }
        if (MainType.PAYMENT.equals(mainType)) {
            Table table = selectTable();
            pay(table);
            return true;
        }
        if (MainType.EXIT.equals(mainType)) {
            OutputView.printExit();
            return false;
        }
        throw new IllegalAccessException("잘못된 포스기 접근입니다.");
    }

    private MainType selectMain() {
        OutputView.printMain();
        return MainType.of(InputView.inputMain());
    }

    private Table selectTable() {
        while (true) {
            try {
                OutputView.printTables(tables);
                return TableRepository.findTableByNumber(InputView.inputTableNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void order(Table table) {
        while (true) {
            try {
                Menu menu = selectMenu();
                Count count = inputCount();
                Order order = new Order(menu, count);
                table.order(order);
                return;
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private Count inputCount() {
        while (true) {
            try {
                return new Count(InputView.inputMenuCount());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private Menu selectMenu() {
        while (true) {
            try {
                OutputView.printMenus(menus);
                return MenuRepository.findMenuByNumber(InputView.inputMenuNumber());
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }

    private void pay(Table table) {
        OutputView.printOrderedMenus(table);
        PaymentType paymentType = selectPayment(table);
        OutputView.printTotalPrice(paymentType.calculate(table.getOrders()));
        table.resetOrder();
    }

    private PaymentType selectPayment(Table table) {
        while (true) {
            try {
                return PaymentType.of(InputView.inputPayment(table));
            } catch (IllegalArgumentException e) {
                OutputView.printError(e.getMessage());
            }
        }
    }
}
