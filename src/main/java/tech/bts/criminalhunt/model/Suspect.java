package tech.bts.criminalhunt.model;

public class Suspect {

    // Builder pattern
    // software building patterns


    private String name;
    private int age;
    private double height;
    private double weight;
    private String hair;
    private String eye;
    private boolean male;

    private Suspect(){
        // nothing
    }

    private Suspect (String name, int age, double height, double weight, String hair, String eye, boolean male){
        this.name = name;
        this.age = age;
        this.height = height;
        this.weight = weight;
        this.hair = hair;
        this.eye = eye;
        this.male = male;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getHair() {
        return hair;
    }

    public void setHair(String hair) {
        this.hair = hair;
    }

    public String getEye() {
        return eye;
    }

    public void setEye(String eye) {
        this.eye = eye;
    }

    public boolean isMale() {
        return male;
    }

    public void setMale(boolean male) {
        this.male = male;
    }

    public static class Builder {

        // 1 - Option 1
        // Declare all the fields again
        // private String name;
        // private int age;
        // etc.
        // Add setter for those fields.
        // and in the building method, create an object with the values that I have in the fields

        // 2 - Option 2
        // Have a field of the class you wan to create.
        // Create an empty object in the constructor.
        // Add setter that change properties of the field.
        // In the build method, just return that field.

        private Suspect suspect;

        public Builder(){
            this.suspect = new Suspect();
        }

        // return the same builder for method chaining

        public Builder name(String name){
            suspect.name = name;
            return this;
        }

        public Builder age(int age){
            suspect.age = age;
            return this;
        }

        public Builder height (double height){
            suspect.height = height;
            return this;
        }

        public Builder weight (double weight){
            suspect.weight = weight;
            return this;
        }

        public Builder hair (String hair){
            suspect.hair = hair;
            return this;
        }

        public Builder eye (String eye){
            suspect.eye = eye;
            return this;
        }

        public Builder male(boolean male){
            suspect.male = male;
            return this;
        }

        public Suspect build() {

            // Here you could set more fields and/or check that everything was set correctly

            return this.suspect;
        }


    }

    @Override
    public boolean equals (Object obj){

        Suspect other = (Suspect) obj;

        int count = 0;

        if (this.isMale() == other.isMale()) {
            if (this.getName().equalsIgnoreCase(other.getName())) {
                count++;
            }
            if (Math.abs(this.getAge() - (other.getAge())) <= 1) {
                count++;
            }
            if (Math.abs(this.getHeight() - other.getHeight()) <= 2.0) {
                count++;
            }
            if (Math.abs(this.getWeight() - other.getWeight()) <= 5.0) {
                count++;
            }
            if (this.getHair().equals(other.getHair())) {
                count++;
            }
            if (this.getEye().equals(other.getEye())) {
                count++;
            }
            if (count >= 5 || (count == 4 && (this.getName().equalsIgnoreCase(other.getName())
                    && (this.getAge() == other.getAge()) && (this.getHeight() == other.getHeight())
                    && (this.getWeight() == other.getWeight()))));
            return true;
        } else {
            return false;
        }


    }

}

