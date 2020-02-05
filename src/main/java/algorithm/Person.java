package algorithm;

import java.time.LocalDate;
import java.util.Objects;

public class Person
{
    private final String name;
    private final LocalDate birthDate;


    public Person(final String name, final LocalDate birthDate)
    {
        this.name = name;
        this.birthDate = birthDate;
    }


    public long getBirthDateTime()
    {
        return birthDate.toEpochDay();
    }


    public boolean isOlder(final Person person)
    {
        return this.getBirthDateTime() < person.getBirthDateTime();
    }


    @Override
    public boolean equals(final Object o)
    {
        if (this == o)
        {
            return true;
        }
        if (o == null || getClass() != o.getClass())
        {
            return false;
        }
        final Person person = (Person) o;
        return Objects.equals(name, person.name) &&
            Objects.equals(birthDate, person.birthDate);
    }


    @Override
    public int hashCode()
    {
        return Objects.hash(name, birthDate);
    }
}

