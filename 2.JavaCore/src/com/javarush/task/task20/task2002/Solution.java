package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = new File("C:\\Users\\User\\Desktop\\Test\\file.txt");
            OutputStream outputStream = new FileOutputStream(yourFile);
            InputStream inputStream = new FileInputStream(yourFile);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            User usr = new User();
            usr.setFirstName("Ivan");
            usr.setLastName("Ivanov");
            usr.setBirthDate(new GregorianCalendar(1980, 11, 25).getTime());
            usr.setCountry(User.Country.RUSSIA);
            usr.setMale(true);

//            User usr2 = new User();
//            usr2.setFirstName("Leonid");
//            usr2.setLastName("Valetov");
//            usr2.setBirthDate(new GregorianCalendar(1983, 02, 26).getTime());
//            usr2.setCountry(User.Country.RUSSIA);
//            usr2.setMale(true);

            javaRush.users.add(usr);
//            javaRush.users.add(usr2);


            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            if (javaRush.equals(loadedObject)) System.out.println("Равны!");
            else System.out.println("Не равны!");

            for (User u: javaRush.users) {
                System.out.println(u.getFirstName());
                System.out.println(u.getLastName());
                System.out.println(u.getBirthDate());
                System.out.println(u.isMale());
                System.out.println(u.getCountry());
            }

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter writer = new PrintWriter(outputStream);

                for (User u: users) {
                    writer.println(u.getFirstName());
                    writer.println(u.getLastName());
                    writer.println(u.getBirthDate().getTime());
                    writer.println(u.isMale());
                    writer.println(u.getCountry());
                }
            writer.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

                while (reader.ready()) {
                    User user = new User();
                    user.setFirstName(reader.readLine());
                    user.setLastName(reader.readLine());
                    user.setBirthDate(new Date(Long.parseLong(reader.readLine())));
                    String isMale = reader.readLine();
                    if (isMale.equals("true")) user.setMale(true);
                    else user.setMale(false);
                    user.setCountry(User.Country.valueOf(reader.readLine()));

                    users.add(user);
                }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
