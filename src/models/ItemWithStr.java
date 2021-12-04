package first.models;

public abstract class ItemWithStr extends MyItem {
    private String Context;

    public ItemWithStr(int ID, String Context) {
        super(ID);
        setContent(Context);
    }

    public ItemWithStr(String toString) throws Exception {
        super(toString);
    }

    public void setContent(String Context) {
        this.Context = Context;
    }

    public String getContent() {
        return Context;
    }
}
