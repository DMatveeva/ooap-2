package task_13;

public abstract class AbstractNotification {
    private String status;

    // В Java нельзя переопределить private метод, но можно расширить область видимости метода
    // default (метод доступен лишь в текущем пакете) расширяется до public в классе PostNotification
    // и остается default в классе MailNotification
    void setStatus(String status) {
        this.status = status;
    }
    public abstract void send();
}

class PostNotification extends AbstractNotification {

    @Override
    public void setStatus(String status) {
        // статус сообщения будет менять клиент, взаимодействующий с почтовой службой, поэтому метод делаем публичным
    }

    @Override
    public void send() {
        // метод был публичным в родительском классе, и остается публичным в дочернем
    }

}

class MailNotification extends AbstractNotification {

    @Override
    void setStatus(String status) {
        // статус сообщения будет менять лишь наша логика, поэтому метод остается default
    }

    @Override
    public void send() {
        // метод был публичным в родительском классе, и остается публичным в дочернем
    }
}

