package algorithm;
import java.util.ArrayList;
import java.util.List;

public class Finder {
	private final List<Person> people;

	public Finder(List<Person> people) {
		this.people = people;
	}

	public Couple find(Criteria criteria) {
		List<Couple> tr = new ArrayList<Couple>();

		for (int i = 0; i < people.size() - 1; i++) {
			for (int j = i + 1; j < people.size(); j++) {
				Couple couple = new Couple();
				if (people.get(i).getBirthDate().getTime() < people.get(j).getBirthDate().getTime()) {
					couple.person1 = people.get(i);
					couple.person2 = people.get(j);
				} else {
					couple.person1 = people.get(j);
					couple.person2 = people.get(i);
				}
				couple.distance = couple.person2.getBirthDate().getTime() - couple.person1.getBirthDate().getTime();
				tr.add(couple);
			}
		}

		if (tr.size() < 1) {
			return new Couple();
		}

		Couple answer = tr.get(0);
		for (Couple result : tr) {
			switch (criteria) {
				case One :
					if (result.distance < answer.distance) {
						answer = result;
					}
					break;

				case Two :
					if (result.distance > answer.distance) {
						answer = result;
					}
					break;
			}
		}

		return answer;
	}
}
