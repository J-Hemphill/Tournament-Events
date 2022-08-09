package org.launchcode.tournamentevents.models;

import javax.persistence.Entity;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
public class EventDetails extends AbstractEntity {

    @Size(max = 500, message = "Description must be 500 or under!")
    @NotBlank(message = "Description required!")
    @NotNull
    private String description;

    @NotBlank(message = "Location required!")
    @NotNull
    @Size(max = 50, message = "Location is way too long!")
    private String location;

    @NotBlank(message = "Email required!")
    @Email(message = "Invalid email! Try again!")
    private String contactEmail;

    @NotBlank(message = "Date required!")
    @NotNull
    private Date date;

    @NotBlank(message = "Entry Fee required!")
    @NotNull
    private String entryFee;

    private TypeOfTournament type;

    @NotBlank(message = "Age required!")
    @NotNull
    @Size(min = 6, message = "Age: 6 is minimum limit!")
    private int ageRequirement;

    @NotBlank(message = "Number of contestants required!")
    @NotNull
    @Size(max = 200, message = "Contestant max is 200!")
    private int numberOfContestants;

//    public EventDetails(
//            String description,
//            String location,
//            String contactEmail,
//            Date date,
//            String entryFee,
//            TypeOfTournament type,
//            int ageRequirement,
//            int numberOfContestants
//    ) {
//        this.description = description;
//        this.location = location;
//        this.contactEmail = contactEmail;
//        this.date = date;
//        this.entryFee = entryFee;
//        this.type = type;
//        this.ageRequirement = ageRequirement;
//        this.numberOfContestants = numberOfContestants;
//    }

    public EventDetails() {}

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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEntryFee() {
        return entryFee;
    }

    public void setEntryFee(String entryFee) {
        this.entryFee = entryFee;
    }

    public TypeOfTournament getType() {
        return type;
    }

    public void setType(TypeOfTournament type) {
        this.type = type;
    }

    public int getAgeRequirement() {
        return ageRequirement;
    }

    public void setAgeRequired(int ageRequirement) {
        this.ageRequirement = ageRequirement;
    }

    public int getNumberOfContestants() {
        return numberOfContestants;
    }

    public void setNumberOfContestants(int numberOfContestants) {
        this.numberOfContestants = numberOfContestants;
    }
}
