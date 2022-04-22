package SRL.FND.Application;

import SRL.FND.Application.global.plugin.ViewManager;
import SRL.FND.Application.loader.Loader;
import com.gn.decorator.GNDecorator;
import com.gn.decorator.options.ButtonType;
import com.sun.javafx.application.LauncherImpl;
import java.io.IOException;
import javafx.application.Application;
import javafx.application.HostServices;
import javafx.application.Preloader;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author M.Faisal1521
 */
public class App extends Application {

    private float increment = 0;
    private float progress = 0;
    public static final GNDecorator decorator = new GNDecorator();
    public static final Scene scene = decorator.getScene();

    public static ObservableList<String> stylesheets;
    public static HostServices hostServices;

    private void print(String p) {
        System.out.println(p);
    }

    @Override
    public void start(Stage primaryStage) {

        configServices();
        initialScene();

        print("Application Start 01");
        stylesheets = decorator.getScene().getStylesheets();
        print("Application Start 02");
        stylesheets.addAll(
                getClass().getResource("/SRL/FND/theme/css/fonts.css").toExternalForm(),
                getClass().getResource("/SRL/FND/theme/css/material-color.css").toExternalForm(),
                getClass().getResource("/SRL/FND/theme/css/skeleton.css").toExternalForm(),
                getClass().getResource("/SRL/FND/theme/css/light.css").toExternalForm(),
                getClass().getResource("/SRL/FND/theme/css/bootstrap.css").toExternalForm(),
                getClass().getResource("/SRL/FND/theme/css/shape.css").toExternalForm(),
                getClass().getResource("/SRL/FND/theme/css/typographic.css").toExternalForm(),
                getClass().getResource("/SRL/FND/theme/css/helpers.css").toExternalForm(),
                getClass().getResource("/SRL/FND/theme/css/master.css").toExternalForm()
        );

        decorator.setMaximized(true);

        decorator.getStage().getIcons().add(new Image("/SRL/FND/images/mini-logo.png"));
        print("Application Start 03");
        decorator.show();
        print("Application Start 04");
    }

    private void configServices() {
        hostServices = getHostServices();
    }

    private void initialScene() {
        decorator.setTitle("Sapphire CRM Application");
        decorator.setIcon(null);
        decorator.addButton(ButtonType.FULL_EFFECT);
        decorator.initTheme(GNDecorator.Theme.DEFAULT);
        decorator.setContent(ViewManager.getInstance().get("login"));
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
        LauncherImpl.launchApplication(App.class, Loader.class, args);
    }

    @Override
    public synchronized void init() {

        float total = 43; // the difference represents the views not loaded
        increment = 100f / total;
        load("FND", "Application/login", "login");
        load("FND", "Application/login", "account");
        load("FND", "Application/main", "main");

        //    load application Modules
        load("CC", "SMS", "SmsTemplate");
        load("CC", "SMS", "SendSMS");
        // delay

        try {
            wait(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    public static GNDecorator getDecorator() {
        return decorator;
    }

    private void load(String module, String Function, String name) {
        try {
            ViewManager.getInstance().put(
                    name,
                    FXMLLoader.load(getClass().getResource("/SRL/" + module + "/" + Function + "/" + name + ".fxml"))
            );
            preloaderNotify();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load(String company, String module, String Function, String name) {
        try {
            ViewManager.getInstance().put(
                    name,
                    FXMLLoader.load(getClass().getResource("/SRL/" + company + "/" + module + "/" + Function + "/" + name + ".fxml"))
            );
            preloaderNotify();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private synchronized void preloaderNotify() {
        progress += increment;
        LauncherImpl.notifyPreloader(this, new Preloader.ProgressNotification(progress));
    }

}
