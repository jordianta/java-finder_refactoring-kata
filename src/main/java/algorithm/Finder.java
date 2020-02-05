package algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        final List<Couple> couples = new ArrayList<>();

        for (int i = 0; i < people.size() - 1; i++)
        {
            for (int j = i + 1; j < people.size(); j++)
            {
                final Couple couple;
                if (people.get(i).isOlder(people.get(j)))
                {
                    couple = new Couple(people.get(i), people.get(j));
                }
                else
                {
                    couple = new Couple(people.get(j), people.get(i));
                }
                couples.add(couple);
            }
        }
        return couples;
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
