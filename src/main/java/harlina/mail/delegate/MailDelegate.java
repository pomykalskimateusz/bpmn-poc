package harlina.mail.delegate;

import harlina.model.User;

import harlina.mail.MailService;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;


public class MailDelegate implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution execution) throws Exception
    {
        MailService mailService = new MailService();

        User[] users = (User[]) execution.getVariable("users");

        mailService.send(prepareText(users), "epomis@elenx.net");
    }

    String prepareText(User[] users)
    {
        StringBuilder text = new StringBuilder();

        for(User user : users)
        {
            text.append(user.toString());
        }

        return text.toString();
    }
}
