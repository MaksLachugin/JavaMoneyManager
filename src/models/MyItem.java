package first.models;


public abstract class MyItem implements IItem {
    private int ID;

    @Override
    public int getID() {
        return ID;
    }

    @Override
    public void setID(int ID) {
        this.ID = ID;
    }

    protected MyItem(int id) {
        setID(id);
    }

    public MyItem(String str) throws Exception {
        fromString(str);
    }

    public abstract MyItem Clone(String str) throws Exception;


    abstract void fromString(String str) throws Exception;
}
