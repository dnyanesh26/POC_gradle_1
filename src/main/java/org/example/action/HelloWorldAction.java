package org.example.action;

import org.apache.struts2.ActionContext;
import org.apache.struts2.ModelDriven;
import org.apache.struts2.util.CompoundRoot;
import org.apache.struts2.util.ValueStack;
import org.example.model.MessageStore;
import org.apache.struts2.ActionSupport;

import java.util.Arrays;

public class HelloWorldAction extends ActionSupport {
    private MessageStore messageStore = new MessageStore();


    public String execute() throws Exception {
        //messageStore = new MessageStore() ;
        messageStore.setMessage("Hello struts user from setter");
        System.out.println("object created: "+messageStore);
        printValueStack();
        return SUCCESS;
    }

    private void printValueStack() {
        ValueStack stack = ActionContext.getContext().getValueStack();
        CompoundRoot root = stack.getRoot();

        System.out.println("Printing all objects on the Value Stack:");
        int index = 0;
        for (Object obj : root) {
            String className = obj.getClass().getName();
            String methods = Arrays.toString(obj.getClass().getMethods());
            System.out.println("  Object " + index + ": " + className + " -> " + obj.toString());
            System.out.println("  Methods : " + methods + " -> " + obj.toString());
            // You can also inspect the object further if needed, e.g., using reflection
            index++;
        }
    }

    public MessageStore getMessageStore() {
        System.out.println("object returned: "+messageStore);
        return messageStore;
    }
}