package harlina.gitlab.service;

import com.google.gson.Gson;

import harlina.model.User;

import org.springframework.web.client.RestTemplate;


public class GitlabFetcher
{
    private static String GITLAB_PRIVATE_TOKEN = "";
    private static String API_USERS_URL = "https://elenx.net/api/v4/users?private_token="+GITLAB_PRIVATE_TOKEN+"&per_page=10";

    public User[] fetchEmails()
    {
        RestTemplate restTemplate = new RestTemplate();
        Gson gson = new Gson();

        String response = restTemplate.getForObject(API_USERS_URL, String.class);

        return gson.fromJson(response, User[].class);
    }
}
