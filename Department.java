public class Department {

    public String departmentID;
    public String name;
    public String location;

    public Department(final String departmentID, final String name, final String location) {
        this.departmentID = departmentID;
        this.name = name;
        this.location = location;
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(final String departmentID) {
        this.departmentID = departmentID;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(final String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentID='" + departmentID + '\'' +
                ", name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
