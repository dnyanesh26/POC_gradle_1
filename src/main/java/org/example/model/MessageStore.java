package org.example.model;


public class MessageStore {
    public String messageNew;

    public MessageStore() {

        System.out.println("message set in constructor");
        messageNew = "Hello Struts User from constructor";
    }



    public void setMessage(String message) {
        this.messageNew = message;
    }

    public String getMessageNew() {
        System.out.println("message returned: "+messageNew);
        return messageNew;
    }
}