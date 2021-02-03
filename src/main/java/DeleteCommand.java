public class DeleteCommand extends Command {
    public DeleteCommand() {}
    public String execute(Storage storage, TaskList taskList, Ui ui, String command) {
        String[] splitCommand = command.split(" ");
        int index = Integer.parseInt(splitCommand[1]);
        try {
            Task currTask = taskList.get(index - 1);
            taskList.remove(index - 1);
            storage.saveTasks(taskList);
            return ui.getDeleteSuccess(currTask, taskList.size());
        }
        catch (ArrayIndexOutOfBoundsException e) {
            return ui.getDeleteFail();
        }
    }
}
