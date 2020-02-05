package algorithm;

public enum Criteria
{
    CLOSEST(Couple::isCloser),
    FARTHEST(Couple::isFarther);

    private final CriteriaFunction<Couple, Boolean> criteriaFunction;


    Criteria(final CriteriaFunction<Couple, Boolean> criteriaFunction)
    {
        this.criteriaFunction = criteriaFunction;
    }


    public boolean match(final Couple couple1, final Couple couple2)
    {
        return criteriaFunction.matches(couple1, couple2);
    }


    @FunctionalInterface
    interface CriteriaFunction<C, B>
    {
        B matches(C couple1, C couple2);
    }

}

