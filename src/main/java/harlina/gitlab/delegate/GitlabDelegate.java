package harlina.gitlab.delegate;

import harlina.gitlab.service.GitlabFetcher;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;

public class GitlabDelegate implements JavaDelegate
{
    @Override
    public void execute(DelegateExecution execution) throws Exception
    {
        GitlabFetcher gitlabFetcher = new GitlabFetcher();

        execution.setVariable("users", gitlabFetcher.fetchEmails());
    }
}
