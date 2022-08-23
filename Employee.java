class Employee {
    public String name;
    public String departmentID;
    public Integer age;
    public String gender;

    public Employee(final String name, final Integer age, final String gender, final String departmentID) {
        this.name = name;
        this.departmentID = departmentID;
        this.age = age;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", departmentID='" + departmentID + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                '}';
    }

    public String getDepartmentID() {
        return departmentID;
    }

    public Integer getAge() {
        return age;
    }

    public String getGender() {
        return gender;
    }
}
