import java.util.List;

public class FindCommand extends Command{
    public FindCommand() {}
    public String execute(Storage storage, TaskList taskList, Ui ui, String command) {
        try {
            String toSearch = command.substring(5);
            List<Task> searchedTaskList = taskList.find(toSearch);
            return ui.getFindSuccess(searchedTaskList);
        } catch (StringIndexOutOfBoundsException e) {
            return ui.getFindFail(new NoMeaningException(
                    "☹ OOPS!!! The description of a find cannot be empty."));
        }
    }
}
