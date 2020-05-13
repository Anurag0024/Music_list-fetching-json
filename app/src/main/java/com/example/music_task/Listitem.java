package com.example.music_task;

public class Listitem  {

    private String artworkUrl;
    private String artistname;
    private String trackname;
    private  String primary_generename;

    public Listitem(String artworkUrl, String artistname, String trackname, String primary_generename) {
        this.artworkUrl = artworkUrl;
        this.artistname = artistname;
        this.trackname = trackname;
        this.primary_generename = primary_generename;
    }

    public String getArtworkUrl() {
        return artworkUrl;
    }

    public void setArtworkUrl(String artworkUrl) {
        this.artworkUrl = artworkUrl;
    }

    public String getArtistname() {
        return artistname;
    }

    public void setArtistname(String artistname) {
        this.artistname = artistname;
    }

    public String getTrackname() {
        return trackname;
    }

    public void setTrackname(String trackname) {
        this.trackname = trackname;
    }

    public String getPrimary_generename() {
        return primary_generename;
    }

    public void setPrimary_generename(String primary_generename) {
        this.primary_generename = primary_generename;
    }
}
