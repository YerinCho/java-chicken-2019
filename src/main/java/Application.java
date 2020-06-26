import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.controller.Controller;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {

    public static void main(String[] args) throws IllegalAccessException {
        Controller controller = new Controller();
        while(true) {
            if(!controller.run()) {
                return;
            }
        }
    }
}
