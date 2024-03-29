package first.models;

public class Entry extends MyItem {
    int IDComment;
    int IDClient;
    int IDCategory;
    int Cost;
    Long Time;

    public Entry(String toString) throws Exception {
        super(toString);
    }

    @Override
    public MyItem Clone(String str) throws Exception {
        return new Entry(str);
    }

    @Override
    public String format() {
        return formater();
    }

    static public String formater() {
        return "int id, int cost, Long time, int IDComment, int IDClient, int IDCategory";
    }


    public int getCost() {
        return Cost;
    }

    public void setCost(int cost) {
        Cost = cost;
    }

    public Long getTime() {
        return Time;
    }

    public void setTime(Long time) {
        Time = time;
    }

    public int getIDComment() {
        return IDComment;
    }

    public void setIDComment(int IDComment) {
        this.IDComment = IDComment;
    }

    public int getIDClient() {
        return IDClient;
    }

    public void setIDClient(int IDClient) {
        this.IDClient = IDClient;
    }

    public int getIDCategory() {
        return IDCategory;
    }

    public void setIDCategory(int IDCategory) {
        this.IDCategory = IDCategory;
    }

    public String getNormalTime() {
        return new java.text.SimpleDateFormat("dd/MM/yyyy").format(new java.util.Date(getTime() * 1000));
    }

    public Entry(int id, int cost, Long time) {
        super(id);
        Cost = cost;
        Time = time;
        this.IDComment = 0;
        this.IDClient = 0;
        this.IDCategory = 0;
    }

    public Entry(int id, int cost, Long time, int IDComment, int IDClient, int IDCategory) {
        super(id);
        this.IDComment = IDComment;
        this.IDClient = IDClient;
        this.IDCategory = IDCategory;
        Cost = cost;
        Time = time;
    }


    public String toString() {
        return getID() + ", " + getCost() + ", " + getTime() + ", " + getIDComment() + ", " + getIDClient() + ", " + getIDCategory();
    }

    void fromString(String str) throws Exception {
        var s = str.split(",");

        if (s.length == 6) {
            setID(Integer.parseInt(s[0].strip()));
            setCost(Integer.parseInt(s[1].strip()));
            setTime(Long.parseLong(s[2].strip()));
            setIDComment(Integer.parseInt(s[3].strip()));
            setIDClient(Integer.parseInt(s[4].strip()));
            setIDCategory(Integer.parseInt(s[5].strip()));
        } else if (s.length == 3) {
            setID(Integer.parseInt(s[0].strip()));
            setCost(Integer.parseInt(s[1].strip()));
            setTime(Long.parseLong(s[2].strip()));
        } else {
            throw new Exception("Не верное кол-во параметров для поступления");

        }

    }


}
