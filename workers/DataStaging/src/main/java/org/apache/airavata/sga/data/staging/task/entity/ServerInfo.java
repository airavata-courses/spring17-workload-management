package org.apache.airavata.sga.data.staging.task.entity;

import com.google.common.io.ByteSink;
import com.google.common.io.Files;
import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.OutputStream;
import java.io.StringWriter;
import java.net.URL;

/**
 * Created by Ajinkya on 2/16/17.
 */
public class ServerInfo {

    private static final Logger logger = LoggerFactory.getLogger(ServerInfo.class);
    private static int DEFAULT_PORT = 22;
    private String host;
    private String userName;
    private int port;
    private String privateKey = "dcoskey";
    private String passphrase = "aq1sw2de3";

    public ServerInfo(String userName, String host, String privateKey) {
        this(userName, host, privateKey, DEFAULT_PORT);
    }

    public ServerInfo(String userName, String host, String privateKey, int port) {
        this.host = host;
        this.userName = userName;
        this.port = port;
        try {
            URL url = ServerInfo.class.getClassLoader().getResource("dcoskey");
            File tempFile = File.createTempFile("dcoskey", ".key");
            ByteSink byteSink = Files.asByteSink(tempFile);
            OutputStream os = byteSink.openStream();
            Resources.copy(url, os);
            this.privateKey = tempFile.getAbsolutePath();
        } catch (Exception ex) {
            logger.error("ServerInfo() -> Failed to get private key. Reason: " + ex.getMessage(), ex);
        }
        logger.debug("ServerInfo() -> Private key path: " + this.privateKey);
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
