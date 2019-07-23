package ru.eltex.app.java.products;

import com.fasterxml.jackson.annotation.*;

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
        include = JsonTypeInfo.As.PROPERTY,
        property = "type")
@JsonSubTypes({
        @JsonSubTypes.Type(value = Tablets.class, name = "tablets"),
        @JsonSubTypes.Type(value = Tablets.screen_resolution.class, name = "screen_resolution"),


})
public class Tablets extends Devices implements Serializable {

    @JsonProperty("GPU")
    private String GPU;
    @JsonProperty("screen_resolution screen")
    private  screen_resolution screen = new screen_resolution(0,0);

    //    нестатические внутренние классы (включая анонимные) имеют набор скрытых переменных,
//    добавляемых компилятором, передаваемых через (скрытый) конструктор
//    Jackson не сможет провести парсинг не статического внутреннего класса!
    public static class screen_resolution implements Serializable {

        @JsonProperty("height")
        int height = 0;
        @JsonProperty("width")
        int width = 0;

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public screen_resolution(@JsonProperty("height") int height, @JsonProperty("width") int width) {
            this.height = height;
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void clear() {
            this.height = 0;
            this.width = 0;
        }

    }

    @JsonIgnore
    private transient String[] random_database_GPU = {"Apple A12X Bionic GPU", "Qualcomm Adreno 640", "ARM Mali-G76 MP10", "PowerVR GXA6850", "NVIDIA Tegra K1 Kepler GPU", "ARM Mali-400 MP2", "PowerVR SGX530"};
    @JsonIgnore
    private transient String[] random_database_screen_resolution = {"640x480", "800x600", "1024x748", "1360x768", "1920x1080", "2560x1440", "3440x1440"};

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
                   @JsonProperty("OS") String _OS, @JsonProperty("Name") String _Name, @JsonProperty("GPU") String GPU, @JsonProperty("height") int height, @JsonProperty("width") int width) {
        super(_ID, _price, _firm, _model, _OS, _Name);
        this.GPU = GPU;
        this.screen = new screen_resolution(height, width);
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

        int width = 0;
        int height = 0;
        System.out.println("Введите разрешение по горизонтале");
        width = in.nextInt();
        System.out.println("Введите разрешение по вертикале");
        height = in.nextInt();
        screen.setHeight(height);
        screen.setWidth(width);
    }

    @JsonIgnore
    @Override
    public  void update() {
        System.out.println("Введите тип  видеопроцессор");
        this.GPU = in.nextLine();
        System.out.println("Введите тип  разрешение экрана");
        this.setScreen_resolution();
    }

    @JsonIgnore
    @Override
    public void delete() {
        this.screen.clear();
        this.GPU = "";
    }

    @JsonIgnore
    @Override
    public  void create() {
        super.create();
        GPU = (String) getRandArrayElement(random_database_GPU);
        screen.setHeight(new Random().nextInt(4000));
        screen.setWidth(new Random().nextInt(4000));
    }

    @JsonIgnore
    @Override
    public  void read() {
        super.read();
        System.out.println("GPU: " + this.GPU);
        System.out.println("Разрешение экрана: " + screen.getHeight() + "x" + screen.getWidth());
    }
}
