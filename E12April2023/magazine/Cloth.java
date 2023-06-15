package magazine;

public class Cloth {
    private String color;
    private int size;
    private String type;

    public Cloth(String color, int size, String type) {
        this.color = color;
        this.size = size;
        this.type = type;
    }

    public String getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return String.format("Product: %s with size %d, color %s", type, size, color);
    }
}
