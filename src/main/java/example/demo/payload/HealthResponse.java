package example.demo.payload;

public class HealthResponse {
    private String environment;
    private String serverIp;
    private String timestamp;

    public HealthResponse(String environment, String serverIp, String timestamp){
        this.environment = environment;
        this.serverIp = serverIp;
        this.timestamp = timestamp;
    }


    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }

    public String getServerIp() {
        return serverIp;
    }

    public void setServerIp(String serverIp) {
        this.serverIp = serverIp;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
