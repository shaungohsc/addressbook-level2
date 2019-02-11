package seedu.addressbook.commands;

import org.junit.Test;
import org.junit.Assert;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.person.*;

import java.lang.String;
import java.util.HashSet;

public class CountCommandTest {

    private static final int NUM_PERSONS_IN_ADDRESSBOOK = 6;
    private static final boolean DEFAULT_PRIVACY = false;
    private static final String DEFAULT_PHONE = "123456789";
    private static final String DEFAULT_EMAIL = "abc@gmail.com";
    private static final String DEFAULT_ADDRESS = "10 Singapore Road, Singapore 999";

    /**
     * Asserts that for a new addressbook with generated persons, Command Count counts the persons correctly
     * invalid persons data throws an IllegalValueException
     */
    @Test
    public void execute_newAddressBook_returnsCount() {
        AddressBook testBook = new AddressBook(); //

        try {
            for (int i = 0; i < NUM_PERSONS_IN_ADDRESSBOOK; i++) {
                char alphabet = (char) i;

                Person p = new Person(
                        new Name("John Doe" + alphabet),
                        new Phone(DEFAULT_PHONE + i, DEFAULT_PRIVACY),
                        new Email(DEFAULT_EMAIL, DEFAULT_PRIVACY),
                        new Address(DEFAULT_ADDRESS, DEFAULT_PRIVACY), new HashSet<>()
                );
                testBook.addPerson(p);
            }

        } catch(Exception e) {
            System.out.println(e);
            Assert.fail();
        } finally {
            CountCommand testCommand = new CountCommand();
            testCommand.setData(testBook,null); // "null" relevant persons is not under use

            char testCountOutput = testCommand.execute().feedbackToUser.charAt(0);

            Assert.assertEquals(String.valueOf(NUM_PERSONS_IN_ADDRESSBOOK), String.valueOf(testCountOutput));
        }
    }
}
