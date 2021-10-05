namespace java net.panda.thrift.message
namespace py message.api

service MessageService {
    bool sendTextMessage(1:string phone, 2:string message);
    bool sendEmailMessage(1:string email, 2:string message);
}