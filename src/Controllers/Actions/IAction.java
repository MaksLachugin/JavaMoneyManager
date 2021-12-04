package first.Controllers.Actions;

public interface IAction {
    String getName();

    String getComment();

    void setComment(String comment);

    void setName(String Name);

    String action(String str) throws Exception;
}
