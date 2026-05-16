import java.util.*;

class User {
    private String name;
    private int age;
    private String email;

    private User(Builder builder) {
        this.name = builder.name;
        this.age = builder.age;
        this.email = builder.email;
    }

    public String getName() {
        return name;
    }

    public static class Builder {

        private String name;
        private int age;
        private String email;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}

public class Builder {
    public static void main(String[] args) {
        User user = new User.Builder()
                .setName("John Doe")
                .setAge(30)
                .setEmail("john.doe@example.com")
                .build();
        System.out.println(user.getName());
    }

}