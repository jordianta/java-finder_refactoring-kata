package test;

import algorithm.Couple;
import algorithm.Criteria;
import algorithm.Finder;
import algorithm.Person;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTests
{

    final Person sue = new Person("Sue", LocalDate.of(50, Month.JANUARY, 1));
    final Person greg = new Person("Greg", LocalDate.of(52, Month.JUNE, 1));
    final Person sarah = new Person("Sarah", LocalDate.of(82, Month.JANUARY, 1));
    final Person mike = new Person("Mike", LocalDate.of(79, Month.JANUARY, 1));


    @Test
    public void Returns_Empty_Results_When_Given_Empty_List()
    {
        final List<Person> people = new ArrayList<>();
        final Finder finder = new Finder(people);

        final Optional<Couple> result = finder.find(Criteria.CLOSEST);

        assertFalse(result.isPresent());
    }


    @Test
    public void Returns_Empty_Results_When_Given_One_Person()
    {
        final List<Person> people = new ArrayList<>();
        people.add(sue);

        final Finder finder = new Finder(people);

        final Optional<Couple> result = finder.find(Criteria.CLOSEST);

        assertFalse(result.isPresent());
    }


    @Test
    public void Returns_Closest_Two_For_Two_People()
    {
        final List<Person> people = new ArrayList<>();
        people.add(sue);
        people.add(greg);
        final Finder finder = new Finder(people);

        final Optional<Couple> result = finder.find(Criteria.CLOSEST);

        assertTrue(result.isPresent());
        assertEquals(sue, result.get().getOldest());
        assertEquals(greg, result.get().getYoungest());
    }


    @Test
    public void Returns_Furthest_Two_For_Two_People()
    {
        final List<Person> people = new ArrayList<>();
        people.add(mike);
        people.add(greg);

        final Finder finder = new Finder(people);

        final Optional<Couple> result = finder.find(Criteria.FARTHEST);

        assertTrue(result.isPresent());
        assertEquals(greg, result.get().getOldest());
        assertEquals(mike, result.get().getYoungest());
    }


    @Test
    public void Returns_Furthest_Two_For_Four_People()
    {
        final List<Person> people = new ArrayList<>();
        people.add(sue);
        people.add(sarah);
        people.add(mike);
        people.add(greg);
        final Finder finder = new Finder(people);

        final Optional<Couple> result = finder.find(Criteria.FARTHEST);

        assertTrue(result.isPresent());
        assertEquals(sue, result.get().getOldest());
        assertEquals(sarah, result.get().getYoungest());
    }


    @Test
    public void Returns_Closest_Two_For_Four_People()
    {
        final List<Person> people = new ArrayList<>();
        people.add(sue);
        people.add(sarah);
        people.add(mike);
        people.add(greg);

        final Finder finder = new Finder(people);

        final Optional<Couple> result = finder.find(Criteria.CLOSEST);

        assertTrue(result.isPresent());
        assertEquals(sue, result.get().getOldest());
        assertEquals(greg, result.get().getYoungest());
    }

}
