package first.DBs.array;

import first.DBs.ATable;
import first.DBs.ITable;
import first.DBs.TearDropFactory;
import first.models.MyItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class ArrayTable<T extends MyItem> extends ATable<T> {

    List<T> tList;

    public ArrayTable(TearDropFactory<T> factory) {
        super(factory);
        tList = new ArrayList<>();
    }

    public void add(T el) {
        tList.add(el);
    }


    public T getElementByID(int ID) {
        for (T e : getLst()
        ) {
            if (e.getID() == ID)
                return e;
        }
        return null;
    }

    public List<T> getLst() {
        return tList;

    }

    public void removeItemByID(int ID) {
        for (int i = 0; i < tList.size(); i++) {
            if (tList.get(i).getID() == ID) {
                tList.remove(i);
                break;
            }
        }
    }

    public void load(String path) throws Exception {

        FileReader FR = new FileReader(path);
        BufferedReader reader = new BufferedReader(FR);
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            add(line);
        }
        FR.close();
    }

    public void save(String path) throws Exception {
        FileWriter FW = new FileWriter(path);
        for (T item : getLst()
        ) {
            FW.write(item.toString());
            FW.write('\n');
        }
        FW.close();
    }

}