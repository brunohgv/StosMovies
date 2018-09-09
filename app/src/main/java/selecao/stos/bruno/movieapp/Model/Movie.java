package selecao.stos.bruno.movieapp.Model;

import java.io.Serializable;

public class Movie implements Serializable {

    private int id;
    private String title;
    private String description;
    private String coverImage;
    private String imageURL;

    public Movie(int id, String title, String description, String coverImage, String imageURL) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.coverImage = coverImage;
        this.imageURL = imageURL;
    }

    public Movie(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCoverImage() {
        return coverImage;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }
}
