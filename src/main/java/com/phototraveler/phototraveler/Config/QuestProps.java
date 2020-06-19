package com.phototraveler.phototraveler.Config;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "pt.quests")
@Data

public class QuestProps {
    private int pageSize = 15;
}
