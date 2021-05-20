package Model;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.image.ImageView;

public class Country {
    private Infection infection;
    private SimpleStringProperty name;
    private SimpleIntegerProperty cases;
    private SimpleIntegerProperty deaths;
    private SimpleIntegerProperty recovered;
    private ImageView flag;

    public String getName() {
        return name.get();
    }
    public void setName(String name){
        this.name = new SimpleStringProperty(name);
    }
    public SimpleStringProperty nameProperty() {
        return name;
    }
    public int getCases() {
        return cases.get();
    }
    public int getDeaths() {
        return deaths.get();
    }
    public int getRecoveries() {
        return recovered.get();
    }
    public ImageView getFlag() {
        return flag;
    }

    /*On instantiation, creates a Country with an image (flag), name, and an infection*/
    public Country(ImageView cImage, String theName, Infection theInfection) {
        flag = cImage;
        name = new SimpleStringProperty(theName);
        infection = theInfection;
        cases = new SimpleIntegerProperty(infection.getCases());
        deaths = new SimpleIntegerProperty(infection.getDeaths());
        recovered = new SimpleIntegerProperty(infection.getRecoveries());
    }
}
