package domain.controller;

import domain.*;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Controller {

    private final List<Table> tables = TableRepository.tables();
    private final List<Menu> menus = MenuRepository.menus();

    public boolean run() throws IllegalAccessException {
        OutputView.printMain();
        MainType mainType = MainType.of(InputView.inputMain());
        if (MainType.ORDER.equals(mainType)) {
            Table table = selectTable();
            order();
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

    private void order() {
        OutputView.printMenus(menus);
    }

    private void pay() {

    }
}
