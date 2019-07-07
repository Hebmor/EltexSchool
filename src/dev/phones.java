package dev;

public class phones extends  abstract_devices{

    private StringBuilder typeBody;
    private String [] random_database_typeBode = {"классический","раскладушка"};

    public phones(String[] random_database_typeBode) {
        this.random_database_typeBode = random_database_typeBode;
    }

    public phones(StringBuilder typeBody) {
        this.typeBody = typeBody;
    }

    public phones() {

    }

    @Override
    public void update()
    {
        int variant = 0;
        super.update();


        while (true) {
            System.out.println("Введите (цифра) тип корпуса (1.классический, 2.раскладушка) (цифра без точки!)");
            variant = in.nextInt();
            switch (variant) {
                case 1: {
                    this.setTypeBody(new StringBuilder("классический"));
                    return;
                }
                case 2: {
                    this.setTypeBody(new StringBuilder("раскладушка"));
                    return;
                }
                default: {
                    System.out.println("Ошибка не корректный вариант! Повторите ввод");

                }
            }
        }

    }
    @Override
    public void delete()
    {
        super.delete();
        this.typeBody.delete(0,typeBody.length());
    }
    @Override
    public  void create()
    {
        super.create();
        setTypeBody((StringBuilder) getRandArrayElement(random_database_typeBode));
    }
    @Override
    public  void read()
    {
        super.read();
        System.out.println("Тип корпуса: " + this.getTypeBody());
    }

    public StringBuilder getTypeBody() {
        return typeBody;
    }

    public void setTypeBody(StringBuilder typeBody) {
        this.typeBody = typeBody;
    }
}
