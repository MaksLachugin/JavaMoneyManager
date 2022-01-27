package first.models;

import first.DBs.TearDropFactory;

public class Category extends ItemWithStr {
    public static final TearDropFactory<Category> tdf = new TearDropFactory<>(){


        public Category newEl(String str) throws Exception {
            return new Category(str);
        }
    };
    public Category(int ID, String Name, String type) {
        this(ID, Name, TypeOfCategory.getType(type));
    }
    public Category(int ID, String Name, TypeOfCategory type) {
        super(ID, Name);
        this.Type = type;
    }

    public Category(int ID, String Name) {
        this(ID, Name, TypeOfCategory.Both);
    }

    public Category(String str) throws Exception {
        super(str);
    }

    @Override
    public MyItem Clone(String str) throws Exception {
        return new Category(str);
    }

    static public String formater() {
        return "int ID, String Name, TypeOfCategory type";
    }

    public void setName(String Context) {
        super.setContent(Context);
    }

    public String getName() {
        return super.getContent();
    }

    @Override
    public String format() {
        return formater();
    }

    public TypeOfCategory Type;

    public TypeOfCategory getType() {
        return Type;
    }

    public void setType(TypeOfCategory type) {
        Type = type;
    }

    public String toString() {
        return getID() + ", " + getName() + ", " + getType();
    }

    void fromString(String str) throws Exception {
        var s = str.split(", ");
        if (s.length == 2) {
           // setID(Integer.parseInt(s[0]));
            setName(s[0].trim());
            setType(TypeOfCategory.getType(s[1].trim()));
        } else if (s.length == 1) {
         //   setID(Integer.parseInt(s[0]));
            setName(s[0].trim());
            setType(TypeOfCategory.Both);
        } else {
            throw new Exception("Не верное кол-во параметров для категории");

        }

    }
}
