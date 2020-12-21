package com.BoardGameNight.registration.payload.request;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

public class GroupRequest {
    @NotBlank
    @Size(min = 3, max = 80)
    private String name;

    @NotBlank
    @Size(max = 255)
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
