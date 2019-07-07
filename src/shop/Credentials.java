package shop;

public class Credentials {

    private int ID = 0;
    private String Familia;
    private  String Name;
    private String Ochestvo;
    private  String email;
    static private int countCredentials = 0;

    public  Credentials()
    {
        countCredentials++;
        ID = countCredentials;
    }
    public Credentials(int ID, String familia, String name, String ochestvo, String email) {
        this.ID = ID;
        this.Familia = familia;
        this.Name = name;
        this.Ochestvo = ochestvo;
        this.email = email;
    }
    public Credentials(String familia, String name, String ochestvo, String email) {
        this.Familia = familia;
        this.Name = name;
        this.Ochestvo = ochestvo;
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
