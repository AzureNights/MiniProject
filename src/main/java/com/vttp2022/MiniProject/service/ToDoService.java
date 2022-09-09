package com.vttp2022.MiniProject.service;

import java.net.URL;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ToDoService {
    private static final Logger logger = LoggerFactory.getLogger(ToDoService.class);

    //Enter API Site after confirming which API 
    //private static String URL = ""


    //messaging API or Google sheets API  
     
    private static String URL = "https://api.telegram.org/bot{token}";
    //put token in url or not 

    public Optional<what> getMessage (String message){
        String apiKey = System.getenv("telegramBotAPIKey");
        String teleURL = UriComponentsBuilder.fromUriString(URL)
            .queryParam("chat_ID", chatID)
            .queryParam("text", message)
            .queryParam("appID", apiKey)
            .toUriString();
    }

    //logger.info("") WHAT TO INCLUDE 
    //message --> user input message ?? or sth else 
    

    
}
