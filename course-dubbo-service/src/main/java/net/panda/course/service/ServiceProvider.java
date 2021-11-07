package net.panda.course.service;

import net.panda.thrift.user.UserService;
import org.apache.thrift.TServiceClient;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TFramedTransport;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ServiceProvider {
    @Value("${thrift.user.ip}")
    private String serverIp;
    @Value("${thrift.user.port}")
    private int serverPort;

    private enum ServiceType {
        USER
    }

    public UserService.Client getUserService() {
        return getService(serverIp, serverPort, ServiceType.USER);
    }

    private <T> T getService(String ip, int port, ServiceType type) {
        TSocket socket = new TSocket(ip, port, 3000);
        TTransport transport = new TFramedTransport(socket);
        try {
            transport.open();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        TServiceClient client = null;
        TProtocol protocol = new TBinaryProtocol(transport);
        switch (type) {
            case USER:
                client = new UserService.Client(protocol);
                break;
            default:
                throw new IllegalArgumentException("wrong service type");
        }
        return (T)client;
    }
}
