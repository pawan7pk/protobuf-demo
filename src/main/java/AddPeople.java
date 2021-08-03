import protos.AddressBook;
import protos.AddressBookOuterClass;
import protos.Person;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class AddPeople {

    public static Person addPerson() {
        Person.Builder person = Person.newBuilder();
        person.setId(1);
        person.setName("Pawan");
        person.setEmail("pawan@pk.com");

        Person.PhoneNumber.Builder phoneNumber = Person.PhoneNumber.newBuilder();
        phoneNumber.setNumber("0909090909");
        phoneNumber.setPhoneType(Person.PhoneType.MOBILE);
        person.addPhones(phoneNumber);

        return person.build();
    }

    public static void showPersonDetails(AddressBook addressBook) {
        for (Person person : addressBook.getPeopleList()) {
            System.out.println("Name :" + person.getName());
            System.out.println("Id " + person.getId());
            System.out.println("Email Address : " + person.getEmail());

            for (Person.PhoneNumber phoneNumber : person.getPhonesList()) {
                if (phoneNumber.getPhoneType().equals(Person.PhoneType.MOBILE))
                    System.out.print("Mobile Number : ");
                else if (phoneNumber.getPhoneType().equals(Person.PhoneType.WORK))
                    System.out.print("Mobile Number : ");
                else if (phoneNumber.getPhoneType().equals(Person.PhoneType.HOME))
                    System.out.print("Mobile Number : ");

                System.out.println(phoneNumber.getNumber());
            }
        }
    }

    public static void main(String[] args) throws IOException {

        AddressBook.Builder address = AddressBook.newBuilder();
//        address.mergeFrom(new FileInputStream(args[0]));
        address.addPeople(addPerson());
//        FileOutputStream output = new FileOutputStream(args[0]);
//        address.build().writeTo(output);
//        output.close();

//        AddressBook addressBook = AddressBook.parseFrom(new FileInputStream(args[0]));
        showPersonDetails(address.build());
    }
}
