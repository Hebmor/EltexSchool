package ru.eltex.app.java.model.products;

import com.fasterxml.jackson.annotation.*;
import ru.eltex.app.java.config.View;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Random;
import java.util.UUID;

@JsonAutoDetect(
        fieldVisibility = JsonAutoDetect.Visibility.ANY,
        getterVisibility = JsonAutoDetect.Visibility.NONE,
        setterVisibility = JsonAutoDetect.Visibility.NONE,
        creatorVisibility = JsonAutoDetect.Visibility.NONE
)
@Entity
@Table(name = "smartphones")
public class Smartphones extends Devices implements Serializable {

    public Smartphones(String[] random_database_typeSIMcard) {
        this.random_database_typeSIMcard = random_database_typeSIMcard;
    }

    @Column(name = "typesimcard")
    @JsonProperty("typeSIMcard")
    @JsonView(View.Summary.class)
    public String typeSIMcard;
    @JsonIgnore
    private transient String[] random_database_typeSIMcard = {"micro-SIM", "обычная"};
    @JsonProperty("countSIMcard")
    @JsonView(View.Summary.class)
    public int countSIMcard = 0;

    public Smartphones(String typeSIMcard) {
        this.typeSIMcard = typeSIMcard;
    }

    @JsonCreator
    public Smartphones(@JsonProperty("ID") UUID _ID, @JsonProperty("Price") int _price, @JsonProperty("Firm") String _firm, @JsonProperty("Model") String _model, @JsonProperty("OS") String _OS, @JsonProperty("Name") String _Name, @JsonProperty("typeSIMcard") String typeSIMcard, @JsonProperty("countSIMcard") int countSIMcard) {
        super(_ID, _price, _firm, _model, _OS, _Name);
        this.typeSIMcard = typeSIMcard;
        this.countSIMcard = countSIMcard;
    }

    @JsonIgnore
    public Smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, String typeSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.typeSIMcard = typeSIMcard;
    }

    @JsonIgnore
    public Smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, String[] random_database_typeSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.random_database_typeSIMcard = random_database_typeSIMcard;
    }

    @JsonIgnore
    public Smartphones(int _Price, String _Firma, String _Model, String _OS, String _Name, int countSIMcard) {
        super(_Price, _Firma, _Model, _OS, _Name);
        this.countSIMcard = countSIMcard;
    }

    @JsonIgnore
    public Smartphones(int countSIMcard) {
        this.countSIMcard = countSIMcard;
    }

    public Smartphones() {

    }

    @JsonIgnore
    public void setTypeSIMcard(String typeSIMcard) {
        this.typeSIMcard = typeSIMcard;
    }

    @JsonIgnore
    public void setCountSIMcard(int countSIMcard) {
        this.countSIMcard = countSIMcard;
    }

    @JsonIgnore
    @Override
    public void update() {
        int variant = 0;
        super.update();
        while (true) {
            System.out.println("Введите (цифра) тип корпуса (1.micro-SIM, 2.обычная) (цифра без точки!)");
            variant = in.nextInt();
            switch (variant) {
                case 1: {
                    this.typeSIMcard = "micro-SIM";
                    return;
                }
                case 2: {
                    this.typeSIMcard = "обычная";
                    return;
                }
                default: {
                    System.out.println("Ошибка не корректный вариант! Повторите ввод");

                }
            }
        }

    }

    @JsonIgnore
    @Override
    public void delete() {
        this.typeSIMcard = "";
        this.countSIMcard = 0;
    }

    @JsonIgnore
    @Override
    public void create() {
        super.create();
        typeSIMcard = (String) getRandArrayElement(random_database_typeSIMcard);
        countSIMcard = new Random().nextInt(2) + 1;
    }

    @JsonIgnore
    @Override
    public void read() {
        super.read();
        System.out.println("Тип СИМ: " + this.typeSIMcard);
        System.out.println("Кол-во СИМ: " + this.countSIMcard);
    }
}
