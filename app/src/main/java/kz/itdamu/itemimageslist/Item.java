package kz.itdamu.itemimageslist;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Aibol on 16.07.2016.
 */
public class Item {
    private int id;
    private String name;
    private List<String> imgUris = new ArrayList<>();

    public Item(int id, String name, String... imgUris) {
        this.id = id;
        this.name = name;
        addImgUris(imgUris);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImgUris() {
        return imgUris;
    }

    public void setImgUris(List<String> imgUris) {
        this.imgUris = imgUris;
    }

    public void addImgUris(String... uri){
        for(String u: uri){
            this.imgUris.add(u);
        }
    }
}
