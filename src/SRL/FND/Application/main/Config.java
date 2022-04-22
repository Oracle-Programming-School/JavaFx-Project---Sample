package SRL.FND.Application.main;

import SRL.FND.Application.App;
import SRL.FND.Application.global.plugin.ViewManager;
import com.gn.decorator.GNDecorator;
import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author Gleidson Neves da Silveira | gleidisonmt@gmail.com
 * Create on  27/10/2018
 * Version 1.0
 */
public class Config implements Initializable {

    @FXML
    private JFXButton btn_theme;

    @FXML
    public VBox options;

    public static  Config ctrl;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ctrl = this;
    }

    private boolean invert = false;
    @FXML
    private void altTheme() {
        invertTheme(!invert);
    }

    private void invertTheme(boolean dark) {
        String theme;
        App.stylesheets.clear();
        String path = "/SRL/FND/theme/css/";

        if (dark) {
            App.decorator.initTheme(GNDecorator.Theme.DARKULA);
            theme = "dark.css";
            btn_theme.setText("Theme dark : actived");
            invert = true;
        } else {
            App.decorator.initTheme(GNDecorator.Theme.DEFAULT);
            theme = "light.css";
            btn_theme.setText("Theme dark : desactived");
            invert = false;
        }

        ObservableList<String> stylesheets = App.decorator.getStage().getScene().getStylesheets();

        stylesheets.addAll(
                getClass().getResource(path + "fonts.css").toExternalForm(),
                getClass().getResource(path + "material-color.css").toExternalForm(),
                getClass().getResource(path + "skeleton.css").toExternalForm(),
                getClass().getResource(path + "" + theme).toExternalForm(),
                getClass().getResource(path + "bootstrap.css").toExternalForm(),
                getClass().getResource(path + "simple-green.css").toExternalForm(),
                getClass().getResource(path + "shape.css").toExternalForm(),
                getClass().getResource(path + "typographic.css").toExternalForm(),
                getClass().getResource(path + "helpers.css").toExternalForm(),
                getClass().getResource(path + "master.css").toExternalForm()
        );

        for (Node node : ViewManager.getInstance().getAll()) {
            ((StackPane) node).getStylesheets().clear();
            ((StackPane) node).getStylesheets().setAll(stylesheets);
        }

        Main.popConfig.hide();

        Platform.runLater(() -> {
//          force pop's transition

            Main.popup.getRoot().getStylesheets().remove(Main.popup.getRoot().getStylesheets().size() - 1);
            Main.popConfig.getRoot().getStylesheets().remove(Main.popConfig.getRoot().getStylesheets().size() - 1);

            Main.popup.getRoot().getStylesheets().add(path + "pop" + theme);
            Main.popConfig.getRoot().getStylesheets().add(path + "pop" + theme);
        });

    }
}
