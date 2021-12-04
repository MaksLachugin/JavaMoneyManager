package first.DBs;

import first.models.MyItem;

public class TearDropFactory<T extends MyItem> {
    public MyItem item;

    public TearDropFactory(MyItem temp) {
        item = temp;
    }

    public T newEl(String str) throws Exception {
        return (T) item.Clone(str);
    }

}
