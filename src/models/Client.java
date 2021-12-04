package first.models;

public class Client extends ItemWithStr {
    public Client(int ID, String Name) {
        super(ID, Name);
    }

    public Client(String toString) throws Exception {
        super(toString);
    }

    @Override
    public MyItem Clone(String str) throws Exception {
        return new Client(str);
    }


    static public String formater() {
        return "int ID, String Name";
    }

    public void setName(String Context) {
        super.setContent(Context);
    }

    public String getName() {
        return super.getContent();
    }

    public String toString() {
        return getID() + ", " + getName();
    }
    @Override
    public String format() {
        return formater();
    }
    void fromString(String str) throws Exception {
        var s = str.split(", ");
        if (s.length == 2) {
            setID(Integer.parseInt(s[0]));
            setName(s[1].trim());
        } else {
            throw new Exception("Неверное кол-во параметров для Клиента");
        }
    }
}
