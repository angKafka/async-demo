package org.rdutta.bmiservice.entity;
/*

{
    "weight": {"value": "85.00", "unit": "kg"},
    "height": {"value": "170.00", "unit": "cm"},
    "sex": "m",
    "age": "24",
    "waist": "34.00",
    "hip": "40.00"
}

*/
public class BMI {
    private Weight weight;
    private Height height;
    private String sex;
    private String age;
    private String waist;
    private String hip;

    public BMI() {}

    public BMI(Weight weight, Height height, String sex, String age, String waist, String hip) {
        this.weight = weight;
        this.height = height;
        this.sex = sex;
        this.age = age;
        this.waist = waist;
        this.hip = hip;
    }


    public Weight getWeight() {
        return weight;
    }

    public void setWeight(Weight weight) {
        this.weight = weight;
    }

    public Height getHeight() {
        return height;
    }

    public void setHeight(Height height) {
        this.height = height;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getWaist() {
        return waist;
    }

    public void setWaist(String waist) {
        this.waist = waist;
    }

    public String getHip() {
        return hip;
    }

    public void setHip(String hip) {
        this.hip = hip;
    }
}
