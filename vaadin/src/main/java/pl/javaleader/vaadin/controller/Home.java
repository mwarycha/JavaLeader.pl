package pl.javaleader.vaadin.controller;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.component.textfield.TextField;

import com.vaadin.flow.router.Route;

@Route("app")
public class Home extends AppLayout {

    TextField textArea        = new TextField("Rejestracja na wydarzenie");
    ComboBox<String> comboBox = new ComboBox<>("Wydarzenia");

    public Home() {

        Image img = new Image("https://i.imgur.com/GPpnszs.png", "Vaadin Logo");
        img.setHeight("44px");
        addToNavbar(new DrawerToggle(), img);
        Tabs tabs = new Tabs(new Tab("Home"), new Tab("About"));
        tabs.setOrientation(Tabs.Orientation.VERTICAL);
        addToDrawer(tabs);

        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(getLayoutTextBoxComboBox());

        setContent(horizontalLayout);
    }

    private HorizontalLayout getLayoutTextBoxComboBox() {
        HorizontalLayout horizontalLayout = new HorizontalLayout();
        horizontalLayout.add(getTextBoxLayout());
        horizontalLayout.add(getComboBoxLayout());
        return horizontalLayout;
    }

    private VerticalLayout getTextBoxLayout() {
        VerticalLayout vertical = new VerticalLayout();
        Label label = new Label();

        textArea.setPlaceholder("adres email");

        textArea.addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {
                label.setText(" nic nie wybrano");
            } else {
                label.setText("[wybrano] " + event.getValue());
            }
        });

        vertical.add(textArea);
        vertical.add(label);
        vertical.add(getSaveButton());
        return vertical;
    }

    private VerticalLayout getComboBoxLayout() {
        VerticalLayout vertical = new VerticalLayout();
        Label label = new Label();

        comboBox.setWidthFull();
        comboBox.setItems("Spring Boot", "konferencja GIT", "webinar Java 8");

        comboBox.addValueChangeListener(event -> {
            if (event.getSource().isEmpty()) {
                label.setText(" nic nie wybrano");

            } else {
                label.setText("[wybrano] " + event.getValue());
            }
        });

        vertical.add(comboBox);
        vertical.add(label);

        return vertical;
    }

    private Button getSaveButton() {
        final Button button = new Button("zapisz się!", event -> {
            Dialog dialog = new Dialog();
            dialog.add(new Label("podsumowanie zapisu na wydarzenie"));

            VerticalLayout verticalLayout = new VerticalLayout();
            verticalLayout.add(new Label("[email] " + textArea.getValue()));
            verticalLayout.add(new Label("[wydarzenie] " + comboBox.getValue()));

            dialog.add(verticalLayout);

            dialog.setWidth("400px");
            dialog.setHeight("150px");
            dialog.open();
        });
        return button;
    }
}
