package first.Apps;


import first.Controllers.*;
import first.DBs.ITableProvider;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleApp implements IApp {
    Scanner console;
    List<IController> Controls;
    IController current;
    String path = "";

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
/*
    public ConsoleApp(int i) throws Exception {
        this("", i);
    }
*/
    public ConsoleApp(ITableProvider tp) throws Exception {
        //ArrayTableProvider ft = new ArrayTableProvider();
        //List<ITable<? extends MyItem>> lst = ft.getTable(i);
        console = new Scanner(System.in);
        Controls = new ArrayList<>();
        Controls.add(new CategoryController(tp.getCategoryTable()));
        Controls.add(new CommentController(tp.getCommentTable()));
        Controls.add(new ClientController(tp.getClientTable()));
        Controls.add(new EntryController(tp.getEntryTable()));

        setPath(path);
        load();
    }
/*
    public ConsoleApp(String path, List<IController> controllers) throws Exception {
        console = new Scanner(System.in);
        setPath(path);
        Controls = controllers;
        load();
    }
*/
    @Override
    public void run() throws Exception {
        while (true) {
            if (changeObject()) {
                System.out.println("Работа консоли завершается");
                if (neeedSave()) {
                    save();
                }
                break;
            }
            System.out.println("-----");
        }

    }

    private boolean changeObject() throws Exception {
        printNameObjects();
        return changeObject(getInt());
    }

    private boolean changeObject(int choice) throws Exception {
        if (choice >= 0 && choice < Controls.size()) {
            current = Controls.get(choice);
            changeActionObject();
        } else if (choice == -1) {
            return true;
        } else {
            System.out.println("Попробуйте ещё раз");
        }
        return false;
    }

    private void changeActionObject() throws Exception {
        if (current == null) {
            return;
        }
        printNameAction();


    }

    private boolean neeedSave() throws Exception {
        System.out.println("Надо сохранить данные? 1/0");
        return getInt() == 1;
    }


    private void changeActionObject(int choice) throws Exception {
        if (current.forAction(choice) != null) {
            System.out.println(current.forAction(choice));
            System.out.println(current.changeAction(choice, getString()));
        }
    }

    private String getString() {
        return console.nextLine().trim().toLowerCase();
    }

    private int getInt() {
        String str = getString();
        if (str.length() < 1) {
            return -1;

        }
        return Integer.parseInt(str);
    }

    private void printNameAction() throws Exception {
        if (current != null) {
            System.out.println(current.getName());
            System.out.println(current.Actions());
            changeActionObject(getInt());
        }

    }

    private void printNameObjects() {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (IController controller : Controls
        ) {
            sb.append(String.format("%d. %s", i++, controller.getName()));
            sb.append('\n');
        }
        System.out.println(sb);
    }

    private void load() throws Exception {
        load(getPath());
    }

    private void load(String path) throws Exception {
        for (IController controller :
                Controls
        ) {
            controller.load(path + String.format("DB\\%s.txt", controller.getName()));
        }
    }//

    private void save() throws Exception {
        save(getPath());
    }

    private void save(String path) throws Exception {
        for (IController controller :
                Controls
        ) {
            controller.save(path + String.format("DB\\%s.txt", controller.getName()));
        }
    }
}
