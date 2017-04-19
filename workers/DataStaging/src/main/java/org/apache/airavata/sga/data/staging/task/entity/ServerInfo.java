package org.apache.airavata.sga.data.staging.task.entity;

/**
 * Created by Ajinkya on 2/16/17.
 */
public class ServerInfo {
    private static int DEFAULT_PORT = 22;
    private String host;
    private String userName;
    private int port;
    private String privateKey = "/Users/goshenoy/.ssh/id_rsa";
    private String passphrase = "aq1sw2de3";

    public ServerInfo(String userName, String host, String privateKey) {
        this(userName, host, privateKey, DEFAULT_PORT);
    }

    public ServerInfo(String userName, String host, String privateKey, int port) {
        this.host = host;
        this.userName = userName;
        this.port = port;
        //this.privateKey = privateKey;
    }

    public String getHost() {
        return host;
    }

    public String getUserName() {
        return userName;
    }

    public int getPort() {
        return port;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public String getPassphrase() { return passphrase; }

    @Override
    public String toString() {
        return "ServerInfo{" +
                "host='" + host + '\'' +
                ", userName='" + userName + '\'' +
                ", port=" + port +
                ", privateKey='" + privateKey + '\'' +
                '}';
    }
}
