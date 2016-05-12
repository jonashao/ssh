package po;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class User {
    private String ID;
    private String phone;
    private String email;
    private long password;

    public User(String ID, String phone, long password) {
        this.ID = ID;
        this.phone = phone;
        this.password = password;
    }

    public User() {
    }

    @Id
    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getPassword() {
        return password;
    }

    public void setPassword(long password) {
        this.password = password;
    }
}