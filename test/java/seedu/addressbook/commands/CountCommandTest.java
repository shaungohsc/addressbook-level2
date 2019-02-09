package seedu.addressbook.commands;

import org.junit.Test;
import org.junit.Assert;
import seedu.addressbook.data.AddressBook;
import seedu.addressbook.data.exception.IllegalValueException;
import seedu.addressbook.data.person.Person;
import seedu.addressbook.data.person.Name;
import seedu.addressbook.data.person.Phone;
import seedu.addressbook.data.person.Email;
import seedu.addressbook.data.person.Address;
import java.lang.String;

class CountCommandTest {

    public static final int NUM_PERSONS_IN_ADDRESSBOOK = 6;
    public static final boolean DEFAULT_PRIVACY = false;
    public static final String DEFAULT_PHONE = "123456789";
    public static final String DEFAULT_EMAIL = "abc@123.com";
    public static final String DEFAULT_ADDRESS = "10 Singapore Road, Singapore 999";

    /**
     * Asserts that for a new addressbook with generated persons, Command Count counts the persons correctly
     * invalid persons data throws an IllegalValueException
     */
    @Test
    void execute_newAddressBook_returnsCount() {
        AddressBook book = new AddressBook();

        try {
            for (int i = 0; i < NUM_PERSONS_IN_ADDRESSBOOK; i++) {
                Person p = new Person(
                        new Name(Integer.toString(i)),
                        new Phone(DEFAULT_PHONE, DEFAULT_PRIVACY),
                new Email(DEFAULT_EMAIL, DEFAULT_PRIVACY),
                new Address(DEFAULT_ADDRESS, DEFAULT_PRIVACY), null
                );

                book.addPerson(p);
            }
        } catch(IllegalValueException e) {
            Assert.fail();
        } finally {
            CountCommand testCommand = new CountCommand();
            testCommand.setData(book,null); // "null" relevant persons is not under use
            char outputChar = testCommand.execute().feedbackToUser.charAt(0);

            Assert.assertEquals(NUM_PERSONS_IN_ADDRESSBOOK, String.valueOf(outputChar));
        }
    }
}