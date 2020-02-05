package test;

import algorithm.Couple;
import algorithm.Criteria;
import algorithm.Finder;
import algorithm.Person;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FinderTests
{

    Person sue = new Person("Sue", new Date(50, 0, 1));
    Person greg = new Person("Greg", new Date(52, 5, 1));
    Person sarah = new Person("Sarah", new Date(82, 0, 1));
    Person mike = new Person("Mike", new Date(79, 0, 1));


    @Test
    public void Returns_Empty_Results_When_Given_Empty_List()
    {
        List<Person> people = new ArrayList<Person>();
        Finder finder = new Finder(people);

        Couple result = finder.find(Criteria.One);
        assertEquals(null, result.person1);

        assertEquals(null, result.person2);
    }


    @Test
    public void Returns_Empty_Results_When_Given_One_Person()
    {
        List<Person> people = new ArrayList<Person>();
        people.add(sue);

        Finder finder = new Finder(people);

        Couple result = finder.find(Criteria.One);

        assertEquals(null, result.person1);
        assertEquals(null, result.person2);
    }


    @Test
    public void Returns_Closest_Two_For_Two_People()
    {
        List<Person> people = new ArrayList<Person>();
        people.add(sue);
        people.add(greg);
        Finder finder = new Finder(people);

        Couple result = finder.find(Criteria.One);

        assertEquals(sue, result.person1);
        assertEquals(greg, result.person2);
    }


    @Test
    public void Returns_Furthest_Two_For_Two_People()
    {
        List<Person> people = new ArrayList<Person>();
        people.add(mike);
        people.add(greg);

        Finder finder = new Finder(people);

        Couple result = finder.find(Criteria.Two);

        assertEquals(greg, result.person1);
        assertEquals(mike, result.person2);
    }


    @Test
    public void Returns_Furthest_Two_For_Four_People()
    {
        List<Person> people = new ArrayList<Person>();
        people.add(sue);
        people.add(sarah);
        people.add(mike);
        people.add(greg);
        Finder finder = new Finder(people);

        Couple result = finder.find(Criteria.Two);

        assertEquals(sue, result.person1);
        assertEquals(sarah, result.person2);
    }


    @Test
    public void Returns_Closest_Two_For_Four_People()
    {
        List<Person> people = new ArrayList<Person>();
        people.add(sue);
        people.add(sarah);
        people.add(mike);
        people.add(greg);

        Finder finder = new Finder(people);

        Couple result = finder.find(Criteria.One);

        assertEquals(sue, result.person1);
        assertEquals(greg, result.person2);
    }

}
