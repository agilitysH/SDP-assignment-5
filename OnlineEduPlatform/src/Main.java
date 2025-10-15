import Facade.App;
import Facade.Facade;
public class Main {
    public static void main(String[] args) throws Exception {
        Facade facade = new Facade();
        App app = new App(facade);
        app.start();
    }
}
