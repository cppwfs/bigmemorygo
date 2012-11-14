package org.terracotta;

import org.junit.Test;
import static org.junit.Assert.*;

public class PersonTest {
    @Test
    public void canConstructAPersonWithAName() {
        Person person = new Person("Larry",25,"MALE");
        assertEquals("Larry", person.getName());
    }
}
