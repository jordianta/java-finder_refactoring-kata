package algorithm;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

public class Finder
{
    private final List<Person> people;


    public Finder(final List<Person> people)
    {
        this.people = people;
    }


    public Optional<Couple> find(final Criteria criteria)
    {
        final List<Couple> couples = generateCouples();

        if (couples.isEmpty())
        {
            return Optional.empty();
        }

        return Optional.of(chooseCoupleByCriteria(couples, criteria));
    }


    private List<Couple> generateCouples()
    {
        return people.stream()
            .flatMap(person -> combineWithOtherPeople(person, people))
            .collect(toList());
    }


    private Stream<Couple> combineWithOtherPeople(final Person person, final List<Person> people)
    {
        return people.stream()
            .filter(otherPerson -> !otherPerson.equals(person))
            .map(otherPerson -> Couple.of(person, otherPerson));
    }


    private Couple chooseCoupleByCriteria(final List<Couple> couples, final Criteria criteria)
    {
        Couple selected = couples.get(0);
        for (final Couple candidate : couples)
        {
            switch (criteria)
            {
                case CLOSEST:
                    if (candidate.isCloser(selected))
                    {
                        selected = candidate;
                    }
                    break;

                case FARTHEST:
                    if (candidate.isFarther(selected))
                    {
                        selected = candidate;
                    }
                    break;
            }
        }
        return selected;
    }
}
