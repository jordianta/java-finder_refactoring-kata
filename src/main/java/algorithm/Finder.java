package algorithm;

import java.util.ArrayList;
import java.util.List;

public class Finder
{
    private final List<Person> people;


    public Finder(final List<Person> people)
    {
        this.people = people;
    }


    public Couple find(final Criteria criteria)
    {
        final List<Couple> couples = new ArrayList<Couple>();

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

        if (couples.isEmpty())
        {
            return new Couple();
        }

        Couple selected = couples.get(0);
        for (final Couple candidate : couples)
        {
            switch (criteria)
            {
                case CLOSEST:
                    if (candidate.getDistance() < selected.getDistance())
                    {
                        selected = candidate;
                    }
                    break;

                case FARTHEST:
                    if (candidate.getDistance() > selected.getDistance())
                    {
                        selected = candidate;
                    }
                    break;
            }
        }

        return selected;
    }
}
