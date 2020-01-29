package kg.salongo.android.Data;

public class SubCategory {
    private int id;
    private String name;

    public SubCategory(){}
    public SubCategory(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SubCategory[] setName(String name) {
        this.name = name;
        return new SubCategory[0];
    }
}
