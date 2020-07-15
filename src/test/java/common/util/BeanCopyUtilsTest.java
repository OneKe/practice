package common.util;

import org.junit.Test;

import java.util.StringJoiner;

public class BeanCopyUtilsTest {

    @Test
    public void copy() {
        Name1 name1 = new Name1();
        name1.setName("huhu");
        name1.setSex(5);
        Name2 name2 = new Name2();
        name2.setAge("h");
//        BeanCopyUtils.copy(name1, name2);
        System.out.println(name2);
    }

    static class Name1 {
        private String name;
        private String age;
        private int sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Name1.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("age='" + age + "'")
                    .add("sex=" + sex)
                    .toString();
        }
    }

    static class Name2 {
        private String name;
        private String age;
        private int sex;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        @Override
        public String toString() {
            return new StringJoiner(", ", Name2.class.getSimpleName() + "[", "]")
                    .add("name='" + name + "'")
                    .add("age='" + age + "'")
                    .add("sex=" + sex)
                    .toString();
        }
    }
}

