package algorithm;

import java.util.Date;

public class Person
{
    private final String name;
    private final Date birthDate;


    public Person(final String name, final Date birthDate)
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
        return birthDate.getTime();
    }
}

