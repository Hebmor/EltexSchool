package ru.eltex.app.java.model.products;

import com.fasterxml.jackson.annotation.*;
import ru.eltex.app.java.config.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.ANY;
import static com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility.NONE;

@JsonAutoDetect(
        fieldVisibility = ANY,
        getterVisibility = NONE,
        setterVisibility = NONE,
        creatorVisibility = NONE
)
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Tablets.class, name = "tablets"),
})
@Entity
@Table(name = "tablets")
public class Tablets extends Devices implements Serializable {

    @Column(name = "screen_resolution")
    @JsonProperty("screen_resolution")
    @JsonView(View.Summary.class)
    private String screen_resolution;
    @Column(name = "gpu")
    @JsonProperty("GPU")
    @JsonView(View.Summary.class)
    private String GPU;


    @JsonIgnore
    private transient String[] random_database_GPU = {
            "Apple A12X Bionic GPU",
            "Qualcomm Adreno 640",
            "ARM Mali-G76 MP10",
            "PowerVR GXA6850",
            "NVIDIA Tegra K1 Kepler GPU",
            "ARM Mali-400 MP2",
            "PowerVR SGX530"
    };
    @JsonIgnore
    private transient String[] random_database_screen_resolution = {
            "640x480",
            "800x600",
            "1024x748",
            "1360x768",
            "1920x1080",
            "2560x1440",
            "3440x1440"
    };

    @JsonIgnore
    public Tablets(int _Price, String _Firma, String _Model, String _OS, String _Name, String GPU) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.GPU = GPU;
    }

    @JsonIgnore
    public Tablets(int _Price, String _Firma, String _Model, String _OS, String _Name, String[] random_database_screen_resolution) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.random_database_screen_resolution = random_database_screen_resolution;
    }

    @JsonCreator
    public Tablets(@JsonProperty("ID") UUID _ID, @JsonProperty("Price") int _price, @JsonProperty("Firm") String _firm, @JsonProperty("Model") String _model,
                   @JsonProperty("OS") String _OS, @JsonProperty("Name") String _Name, @JsonProperty("GPU") String GPU, @JsonProperty("screen_resolution") String screen_resolution) {
        super(_ID, _price, _firm, _model, _OS, _Name);
        this.GPU = GPU;
        this.screen_resolution = screen_resolution;
    }

    @JsonIgnore
    public Tablets(String GPU) {
        this.GPU = GPU;
    }

    @JsonIgnore
    public Tablets(String[] random_database_GPU) {
        this.random_database_GPU = random_database_GPU;
    }

    @JsonIgnore
    public Tablets() {

    }

    @JsonIgnore
    public void setScreen_resolution() {

        int width;
        int height;
        System.out.println("Введите разрешение по горизонтале");
        width = in.nextInt();
        System.out.println("Введите разрешение по вертикале");
        height = in.nextInt();
        this.screen_resolution = width + "x" + height;
    }

    @JsonIgnore
    public void setScreen_resolution(int width, int height) {

        this.screen_resolution = width + "x" + height;
    }
    @JsonIgnore
    @Override
    public void update() {
        System.out.println("Введите тип  видеопроцессор");
        this.GPU = in.nextLine();
        System.out.println("Введите тип  разрешение экрана");
        this.setScreen_resolution();
    }

    @JsonIgnore
    @Override
    public void delete() {
        this.screen_resolution = "";
        this.GPU = "";
    }

    @JsonIgnore
    @Override
    public void create() {
        super.create();
        GPU = (String) getRandArrayElement(random_database_GPU);
        setScreen_resolution(new Random().nextInt(4000), new Random().nextInt(4000));
    }

    @JsonIgnore
    @Override
    public void read() {
        super.read();
        System.out.println("GPU: " + this.GPU);
        System.out.println("Разрешение экрана: " + this.screen_resolution);
    }
}