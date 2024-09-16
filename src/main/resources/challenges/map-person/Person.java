@Node
public class Person {
    @Id
    //Id field

    //additional 8 fields

    //constructor
    public Person(String imdbId, ...//additional fields) {
        this.imdbId = imdbId;
        //additional fields here
    }

    //getter and setter methods for each field
    public String getImdbId() {
    return imdbId;
}

    public void setImdbId(String imdbId) {
    this.imdbId = imdbId;
}
}