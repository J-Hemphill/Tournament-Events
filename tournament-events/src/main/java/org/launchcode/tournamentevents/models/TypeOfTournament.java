package org.launchcode.tournamentevents.models;

public enum TypeOfTournament {

    TEAMPLAY("Team play"),
    SINGLEPLAY("Single play");

    private final String displayName;

    TypeOfTournament(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
