package haojun.android_common.model;

/**
 * Created by haojun on 4/21/17.
 */

public class RepoModel extends TestModel {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return getId() + " " + getName();
    }
}
