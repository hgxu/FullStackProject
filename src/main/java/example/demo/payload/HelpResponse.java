package example.demo.payload;

public class HelpResponse {

    private String health;
    private String process;

    public HelpResponse(String health, String process){
        this.health = health;
        this.process = process;
    }

    public String getHealth() {
        return health;
    }

    public void setHealth(String health) {
        this.health = health;
    }

    public String getProcess() {
        return process;
    }

    public void setProcess(String process) {
        this.process = process;
    }
}
