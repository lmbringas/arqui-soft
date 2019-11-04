package ar.edu.ucc.arqsoft.test.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "User")
public class User extends ObjetoGenerico {

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "dni")
    private String dni;


    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDni() {
        return this.dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }


}
