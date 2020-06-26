package domain.controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();

    public boolean run() throws IllegalAccessException {
        try {
            OutputView.printMain();
            MainType mainType = MainType.of(InputView.inputMain());
            if (MainType.ORDER.equals(mainType)) {
                Table table = selectTable();
                order(table);
                return true;
            }

            if (MainType.PAYMENT.equals(mainType)) {
                Table table = selectTable();
                pay();
                return true;
            }

            if (MainType.EXIT.equals(mainType)) {
                OutputView.printExit();
                return false;
            }
        } catch (IllegalArgumentException e) {
            OutputView.printError(e.getMessage());
            return true;
        }

        throw new IllegalAccessException("잘못된 포스기 접근입니다.");
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
        Menu menu = selectMenu();
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

    private void pay() {

    }
}
