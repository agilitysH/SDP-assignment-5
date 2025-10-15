import App.Facade;
public class Main {
    public static void main(String[] args) throws Exception {
        Facade facade = new Facade();
        App.App app = new App.App(facade);
        app.start();
    }
}
