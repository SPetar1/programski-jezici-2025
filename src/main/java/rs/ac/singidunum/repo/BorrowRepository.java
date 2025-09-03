package rs.ac.singidunum.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import rs.ac.singidunum.entity.Borrow;

@Repository
public interface BorrowRepository extends JpaRepository<Borrow, Integer> {}
