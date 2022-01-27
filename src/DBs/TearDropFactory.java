package first.DBs;

import first.models.MyItem;

public interface TearDropFactory<T extends MyItem> {

    public T newEl(String str) throws Exception;

}
