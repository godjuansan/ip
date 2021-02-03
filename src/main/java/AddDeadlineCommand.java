import java.time.LocalDate;
import java.time.LocalTime;

public class AddDeadlineCommand extends Command {
    public AddDeadlineCommand() {}
    public String execute(Storage storage, TaskList taskList, Ui ui, String command) {
        try {
            String commandContent = command.substring(9);
            String[] deadlineWords = commandContent.split("/by");
            String deadlineWord = deadlineWords[0];
            String deadlineTime = deadlineWords[1];

            String[] deadlineDateHours = deadlineTime.split(" ");
            LocalDate deadlineDate = LocalDate.parse(deadlineDateHours[1]);
            LocalTime deadlineHour = LocalTime.parse(deadlineDateHours[2]);
            Deadline deadline = new Deadline(deadlineWord, deadlineDate, deadlineHour);
            taskList.add(deadline);
            storage.saveTasks(taskList);
            return ui.getTaskFinally(deadline, taskList.size());
        }  catch (StringIndexOutOfBoundsException e) {
            return ui.getTaskFail(new NoMeaningException(
                    "☹ OOPS!!! The description of a deadline cannot be empty.")
            );
        }
    }
}
