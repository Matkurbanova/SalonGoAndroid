package kg.salongo.android.Data;

public class SubCategory {
    private String name;
    public SubCategory(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public SubCategory[] setName(String name) {
        this.name = name;
        return new SubCategory[0];
    }
}
