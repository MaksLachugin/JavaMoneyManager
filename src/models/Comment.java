package first.models;

public class Comment extends ItemWithStr {
    public Comment(int ID, String Comment) {
        super(ID, Comment);
    }

    public Comment(String toString) throws Exception {
        super(toString);
    }

    @Override
    public MyItem Clone(String str) throws Exception {
        return new Comment(str);
    }

    static public String formater() {
        return "int ID, String Comment";
    }

    public void setComment(String Comment) {
        super.setContent(Comment);
    }

    public String getComment() {
        return super.getContent();
    }

    public String toString() {
        return getID() + ", " + getComment();
    }
    @Override
    public String format() {
        return formater();
    }
    void fromString(String str) throws Exception {
        var s = str.split(", ");
        if (s.length == 2) {
            setID(Integer.parseInt(s[0]));
            setComment(s[1].trim());
        } else {
            throw new Exception("Неверное кол-во параметров для категории");
        }
    }
}
