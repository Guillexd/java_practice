
import db.PersonDAO;
import domain.Person;
import java.util.List;


public class TestJavaDB {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        personDAO.update(new Person(5));

        List<Person> people = personDAO.selectedPeople();

        people.forEach(person -> {
            System.out.println(person);
        });
    }
}
