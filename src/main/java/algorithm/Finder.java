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
        final List<Couple> tr = new ArrayList<Couple>();

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
                tr.add(couple);
            }
        }

        if (tr.isEmpty())
        {
            return new Couple();
        }

        Couple answer = tr.get(0);
        for (final Couple result : tr)
        {
            switch (criteria)
            {
                case One:
                    if (result.getDistance() < answer.getDistance())
                    {
                        answer = result;
                    }
                    break;

                case Two:
                    if (result.getDistance() > answer.getDistance())
                    {
                        answer = result;
                    }
                    break;
            }
        }

        return answer;
    }
}
