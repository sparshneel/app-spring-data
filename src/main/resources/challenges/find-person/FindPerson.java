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

public interface PersonRepository extends Neo4jRepository<Person, String> {
}

@RestController
@RequestMapping("/people")
public class PersonController {
    //inject repository

    //constructor with injected repository

    @GetMapping()
    //findAll method implementation

    @GetMapping("/{imdbId}")
    //findById method implementation
}
