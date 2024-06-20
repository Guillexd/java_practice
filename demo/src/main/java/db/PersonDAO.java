package db;

import domain.Person;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class PersonDAO {
    private static final String 
    SQL_SELECT = "SELECT * FROM people",
    SQL_INSERT = "INSERT INTO people (name, email) values (?, ?)",
    SQL_UPDATE = "UPDATE people SET name = ?, email = ? WHERE id = ?",
    SQL_DELETE = "DELETE FROM people WHERE id = ?";
    

    public List<Person> selectedPeople()
    {
       Connection conn = null;
       PreparedStatement stm = null;
       ResultSet rs = null;
       Person person = null;
       List<Person> people = new ArrayList<>();

       try {
           conn = Conexion.getConnection();
           stm = conn.prepareStatement(SQL_SELECT);
           rs = stm.executeQuery();

           while(rs.next())
           {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");
    
            person = new Person(id, name, email);
            people.add(person);
           }
       } catch (Exception e) {
            System.out.println(e);
       } finally {
            try {
                Conexion.close(rs);
                Conexion.close(stm);
                Conexion.close(conn);
            } catch (Exception e) {
                System.out.println(e);
            }
       }

       return people;
    } 

    public int insert(Person person)
    {
        Connection conn = null;
        PreparedStatement stm = null;
        int registers = 0;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_INSERT);
            stm.setString(1, person.getName());
            stm.setString(2, person.getEmail());
            registers = stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                Conexion.close(stm);
                Conexion.close(conn);
            } catch (Exception e) {
                System.out.println(e);
            }
       }
        return registers;
    }

    public int update(Person person)
    {
        Connection conn = null;
        PreparedStatement stm = null;
        int registers = 0;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_UPDATE);
            stm.setString(1, person.getName());
            stm.setString(2, person.getEmail());
            stm.setInt(3, person.getId());
            registers = stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                Conexion.close(stm);
                Conexion.close(conn);
            } catch (Exception e) {
                System.out.println(e);
            }
       }
        return registers;
    }

    public int delete(Person person)
    {
        Connection conn = null;
        PreparedStatement stm = null;
        int registers = 0;

        try {
            conn = Conexion.getConnection();
            stm = conn.prepareStatement(SQL_DELETE);
            stm.setInt(1, person.getId());
            registers = stm.executeUpdate();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                Conexion.close(stm);
                Conexion.close(conn);
            } catch (Exception e) {
                System.out.println(e);
            }
       }
        return registers;
    }
}
