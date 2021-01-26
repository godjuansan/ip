public class Task {
    protected final String job;
    protected final Boolean done;
    public Task(String job) {
        this.job = job;
        this.done = false;
    }

    public Task(String job, Boolean done) {
        this.job = job;
        this.done = done;
    }

    public Task doTask() {
        return new Task(this.job, true);
    }

    public String getJob() {
        return this.job;
    }

    public Boolean getDone() {
        return this.done;
    }

    public String toString() {
        String status = "";
        if (done) {
            status = "[X] ";
        }
        else {
            status = "[ ] ";
        }
        return status + job;
    }
}
