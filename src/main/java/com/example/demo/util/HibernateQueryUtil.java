package com.example.demo.util;

import com.example.demo.model.ApprovalAction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HibernateQueryUtil {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Find approval actions by approverId using Criteria API
     * (HCQL style)
     */
    public List<ApprovalAction>
    findActionsByApproverUsingCriteria(Long approverId) {

        // Edge case: null approverId
        if (approverId == null) {
            return new ArrayList<>();
        }

        CriteriaBuilder cb =
                entityManager.getCriteriaBuilder();

        CriteriaQuery<ApprovalAction> cq =
                cb.createQuery(ApprovalAction.class);

        Root<ApprovalAction> root =
                cq.from(ApprovalAction.class);

        Predicate condition =
                cb.equal(
                        root.get("approverId"),
                        approverId);

        cq.select(root).where(condition);

        return entityManager
                .createQuery(cq)
                .getResultList();
    }
}
