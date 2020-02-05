package algorithm;

import java.time.LocalDate;

public class Person
{
    private final String name;
    private final LocalDate birthDate;


    public Person(final String name, final LocalDate birthDate)
    {
        this.name = name;
        this.birthDate = birthDate;
    }


    public String getName()
    {
        return name;
    }


    public long getBirthDateTime()
    {
        return birthDate.toEpochDay();
    }


    public boolean isOlder(final Person person)
    {
        return this.getBirthDateTime() < person.getBirthDateTime();
    }
}

