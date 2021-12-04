package first.DBs;

import first.models.MyItem;

import java.util.List;

public abstract class ATable<T extends MyItem> implements ITable<T> {
    private final TearDropFactory<T> localFactory;

    public ATable(TearDropFactory<T> localFactory) {
        this.localFactory = localFactory;
    }

    @Override
    public void add(String el) throws Exception {
        add(localFactory.newEl(el));
    }

    @Override
    public void editElement(String newElement) throws Exception {
        removeItemByID(Integer.parseInt(newElement.split(", ", 2)[0]));
        add(newElement);
    }

    @Override
    public String getTableOfItems() {
        StringBuilder sb = new StringBuilder();
        for (MyItem item :
                getLst()) {
            sb.append(item.toString());
            sb.append('\n');
        }
        return sb.toString();
    }

    @Override
    public String getEntityFormat() {

        return localFactory.item.format();

    }
}
