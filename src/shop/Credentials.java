package shop;

public class Credentials {

    private int ID = 0;
    private String Familia;
    private  String Name;
    private String Ochestvo;
    private  String email;

    public Credentials(int ID, String familia, String name, String ochestvo, String email) {
        this.ID = ID;
        Familia = familia;
        Name = name;
        Ochestvo = ochestvo;
        this.email = email;
    }
    public int getID() {
        return ID;
    }

    public String getFamilia() {
        return Familia;
    }

    public String getName() {
        return Name;
    }

    public String getOchestvo() {
        return Ochestvo;
    }

    public String getEmail() {
        return email;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setFamilia(String familia) {
        Familia = familia;
    }

    public void setName(String name) {
        Name = name;
    }

    public void setOchestvo(String ochestvo) {
        Ochestvo = ochestvo;
    }

    public void setEmail(String email) {
        this.email = email;
    }


}
