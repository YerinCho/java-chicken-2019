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
            OutputView.printTables(tables);
            final int tableNumber = InputView.inputTableNumber();
            OutputView.printMenus(menus);
            order();
            return true;
        }

        if(MainType.PAYMENT.equals(mainType)) {
            pay();
            return true;
        }

        if(MainType.EXIT.equals(mainType)) {
            OutputView.printExit();
            return false;
        }

        throw new IllegalAccessException("잘못된 포스기 접근입니다.");
    }

    private void order() {

    }

    private void pay() {

    }
}
