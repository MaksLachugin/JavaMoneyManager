package first.DBs;

import first.models.MyItem;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public interface ITable<T extends MyItem> {

    public void add(T el);

    public void add(String el) throws Exception;

    public T getElementByID(int ID);

    public List<T> getLst();

    public void removeItemByID(int ID);

    public void editElement(String newElement) throws Exception;

    public String getTableOfItems();

    public void load(String path) throws Exception;

    public void save(String path) throws Exception;

    public String getEntityFormat();
}// код старый, т.к. начал переписывать, там сложности. Писал на старом коде. Да
