import domain.controller.Controller;

public class Application {

    public static void main(String[] args) throws IllegalAccessException {

        Controller controller = new Controller();
        while (true) {
            if (!controller.run()) {
                return;
            }
        }
    }
}
