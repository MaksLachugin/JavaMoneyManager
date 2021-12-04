package first.models;

public interface IItem {
    int getID();

    void setID(int ID);

    String toString();

    IItem Clone(String str) throws Exception;

    default String format() {
        return formater();
    }

    static String formater() {
        return "int ID";
    }
}
