package first.models;

public class TearDropFactory<T extends MyItem> {
    MyItem item;

    public TearDropFactory(MyItem temp) {
        item = temp;
    }
    public T newEl(String str) throws Exception {
        return (T) item.Clone(str);
    }

}
