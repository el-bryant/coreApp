package bootcamp.core.data;

public class ImageData {
    public int imageResource;
    public String imageDescription;

    public ImageData(int imageResource, String imageDescription) {
        this.imageResource = imageResource;
        this.imageDescription = imageDescription;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getImageDescription() {
        return imageDescription;
    }

    public void setImageDescription(String imageDescription) {
        this.imageDescription = imageDescription;
    }
}
