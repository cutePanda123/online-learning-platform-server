from message.api import MessageService


class MessageServiceHandler:

    def sendTextMessage(self, phone, message):
        print ("send text message")
        return True

    def sendEmailMessage(self, email, message):
        print ("send email message")
        return True


if __name__ == '__main__':
    handler = MessageServiceHandler()
    processor = MessageService.Processor(handler)
