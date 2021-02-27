package pl.javaleader.jpaspecifications.operations;

import org.springframework.data.jpa.domain.Specification;
import pl.javaleader.jpaspecifications.model.Movie;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class MovieSpecification implements Specification<Movie> {

    private List<SearchCriteria> searchCriteriaList;

    public MovieSpecification() {
        this.searchCriteriaList = new ArrayList<>();
    }

    public void add(SearchCriteria criteria) {
        searchCriteriaList.add(criteria);
    }

    @Override
    public Predicate toPredicate(Root<Movie> root, CriteriaQuery<?> query, CriteriaBuilder builder) {

        List<Predicate> predicates = new ArrayList<>();

        for (SearchCriteria criteria : searchCriteriaList) {
            if (criteria.getOperation().equals(SearchOperation.GREATER_THAN)) {
                predicates.add(
                        builder.greaterThan(
                                root.get(criteria.getKey()),
                                criteria.getValue().toString())
                );
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN)) {
                predicates.add(
                        builder.lessThan(
                                root.get(criteria.getKey()),
                                criteria.getValue().toString())
                );
            } else if (criteria.getOperation().equals(SearchOperation.GREATER_THAN_EQUAL)) {
                predicates.add(
                        builder.greaterThanOrEqualTo(
                                root.get(criteria.getKey()),
                                criteria.getValue().toString()
                        )
                );
            } else if (criteria.getOperation().equals(SearchOperation.LESS_THAN_EQUAL)) {
                predicates.add(
                        builder.lessThanOrEqualTo(
                                root.get(criteria.getKey()),
                                criteria.getValue().toString()
                        ));
            } else if (criteria.getOperation().equals(SearchOperation.NOT_EQUAL)) {
                predicates.add(
                        builder.notEqual(root.get(
                                criteria.getKey()), criteria.getValue())
                );
            } else if (criteria.getOperation().equals(SearchOperation.EQUAL)) {
                predicates.add(
                        builder.equal(root.get(
                                criteria.getKey()), criteria.getValue()));
            } else if (criteria.getOperation().equals(SearchOperation.MATCH)) {
                predicates.add(
                        builder.like(
                                builder.lower(root.get(criteria.getKey()))
                                , "%" + criteria.getValue().toString().toLowerCase() + "%")
                );
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_END)) {
                predicates.add(
                        builder.like(
                                builder.lower(root.get(criteria.getKey())),
                                criteria.getValue().toString().toLowerCase() + "%")
                );
            } else if (criteria.getOperation().equals(SearchOperation.MATCH_START)) {
                predicates.add
                        (builder.like(
                                builder.lower(root.get(criteria.getKey())),
                                "%" + criteria.getValue().toString().toLowerCase())
                        );
            } else if (criteria.getOperation().equals(SearchOperation.IN)) {
                predicates.add(
                        builder.in(
                                root.get(criteria.getKey())
                        ).value(criteria.getValue())
                );
            } else if (criteria.getOperation().equals(SearchOperation.NOT_IN)) {
                predicates.add(
                        builder.not(
                                root.get(criteria.getKey())
                        ).in(criteria.getValue()));
            }
        }

        return builder.and(predicates.toArray(new Predicate[0]));
    }
}