package org.launchcode.tournamentevents.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class EventDetails extends AbstractEntity {

    @NotBlank(message = "Description is required!")
    @Size(max = 500, message = "Description too long!")
    private String description;

    @NotBlank(message = "Location is required")
    @NotNull
    @Size(max = 50, message = "Location is too long!")
    private String location;

    @NotBlank(message = "Email required!")
    @Email(message = "Invalid email! Try again!")
    private String contactEmail;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotBlank(message = "Date is required!")
    @NotNull
    private String date;

    @NotBlank(message = "Entry Fee is required!")
    @NotNull
    private String entryFee;

    @NotBlank(message = "Total audience capacity is required!")
    @NotNull
    private String totalAudienceCapacity;

    @NotBlank(message = "Number of contestants required!")
    @NotNull
    private String numberOfContestants;

    public EventDetails(
            String description,
            String location,
            String contactEmail,
            String date,
            String entryFee,
            String totalAudienceCapacity,
            String numberOfContestants
    ) {
        this.description = description;
        this.location = location;
        this.contactEmail = contactEmail;
        this.date = date;
        this.entryFee = entryFee;
        this.totalAudienceCapacity = totalAudienceCapacity;
        this.numberOfContestants = numberOfContestants;
    }

    public EventDetails () {}

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public String getTotalAudienceCapacity() {
        return totalAudienceCapacity;
    }

    public void setTotalAudienceCapacity(String totalAudienceCapacity) {
        this.totalAudienceCapacity = totalAudienceCapacity;
    }

    public String getNumberOfContestants() {
        return numberOfContestants;
    }

    public void setNumberOfContestants(String numberOfContestants) {
        this.numberOfContestants = numberOfContestants;
    }
}