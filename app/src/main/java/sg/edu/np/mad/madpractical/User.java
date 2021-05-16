package sg.edu.np.mad.madpractical;


public class User {
    public String name;
    public String description;
    public int id;
    public boolean followed;

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public Boolean getFollowed(){
        return followed;
    }

    public User(String name, String description, int id, boolean followed) {
        this.name = name;
        this.description = description;
        this.id = id;
        this.followed = followed;
    }

    public String toString() {
        return new StringBuilder()
                .append(name).append("\t")
                .append(description).append("\t")
                .append(id).append("\t")
                .append(followed).toString();
    }
}
