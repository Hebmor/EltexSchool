package dev;

public class phones extends  abstract_devices{

    private String typeBody;
    private String [] random_database_typeBode = {"классический","раскладушка"};

    public phones(String[] random_database_typeBode) {
        this.random_database_typeBode = random_database_typeBode;
    }

    public phones(String typeBody) {
        this.typeBody = typeBody;
    }

    @Override
    public void update()
    {
        super.update();

        System.out.println("Введите тип корпуса (классический, раскладушка)");
        this.setTypeBody(in.nextLine());
    }
    @Override
    public void delete()
    {
        this.setTypeBody("");
    }
    @Override
    public  void create()
    {
        super.create();
        setTypeBody((String) getRandArrayElement(random_database_typeBode));
    }
    @Override
    public  void read()
    {
        super.read();
        System.out.println("Тип корпуса: " + this.getTypeBody());
    }

    public String getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(String typeBody) {
        this.typeBody = typeBody;
    }
}
