import java.sql.Date;

public class Emp {
    private String id;
    private String name;
    private Boolean depart;
    private String gender;
    private float sal;
    private Date hireDate;

    public Boolean getDepart() {
        return depart;
    }

    public void setDepart(Boolean depart) {
        this.depart = depart;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getSal() {
        return sal;
    }

    public void setSal(float sal) {
        this.sal = sal;
    }
}

