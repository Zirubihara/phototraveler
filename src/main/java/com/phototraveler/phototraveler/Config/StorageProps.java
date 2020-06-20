package com.phototraveler.phototraveler.Config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;


@Component
@ConfigurationProperties("storage")
public class StorageProps {

    private String location = "upload-dir";

    public String getLocation () {return location;}

    public void setLocation(String location) {this.location = location;}
}
