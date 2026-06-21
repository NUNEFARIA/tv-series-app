package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Serie {
    
    private int id;
    private String name;
    private String language;
    private List<String> genres;
    private float average;
    private String status;
    private String premiered;
    private String ended;
    private String broadcaster;
    
    public Serie(int id) {
        genres = new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public List<String> getGenres() {
        return genres;
    }
    
    public float getAverage() {
        return average;
    }
    
    public String getStatus() {
        return status;
    }
    
    public String getPremiered() {
        return premiered;
    }
    
    public String getEnded() {
        return ended;
    }
    
    public String getBroadcaster() {
        return broadcaster;
    }
    
    public void setBroadcaster(String broadcaster) {
        this.broadcaster = broadcaster;
    }
    
    public void setEnded(String ended) {
        this.ended = ended;
    }
    
    public void setPremiered(String premiered) {
        this.premiered = premiered;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public void setAverage(float average) {
        this.average = average;
    }
    
    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }
    
    public void setLanguage(String language) {
        this.language = language;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    @Override
    public String toString() {
        return name;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;

        if (!(o instanceof Serie)) return false;

        Serie serie = (Serie) o;

        return id == serie.id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
    
    public String toStrigDetails() {
        
        final StringBuilder sb = new StringBuilder("Serie{");
        
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", genres=").append(genres);
        sb.append(", average=").append(average);
        sb.append(", status='").append(status).append('\'');
        sb.append(", premiered='").append(premiered).append('\'');
        sb.append(", ended='").append(ended).append('\'');
        sb.append(", broadcaster='").append(broadcaster).append('\'');
        sb.append('}');
        
        return sb.toString();
        
    }
}
