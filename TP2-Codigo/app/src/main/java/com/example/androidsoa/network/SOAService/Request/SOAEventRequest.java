package com.example.androidsoa.network.SOAService.Request;

import com.google.gson.annotations.SerializedName;

public class SOAEventRequest {
    @SerializedName("env")
    private String env;

    @SerializedName("type_events")
    private String typeEvents;

    @SerializedName("description")
    private String description;

    public SOAEventRequest(String env, String typeEvents, String description) {
        this.env = env;
        this.typeEvents = typeEvents;
        this.description = description;
    }

    public String getEnv() {
        return env;
    }

    public void setEnv(String env) {
        this.env = env;
    }

    public String getTypeEvents() {
        return typeEvents;
    }

    public void setTypeEvents(String typeEvents) {
        this.typeEvents = typeEvents;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
