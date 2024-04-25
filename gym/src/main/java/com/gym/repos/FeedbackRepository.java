package com.gym.repos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.gym.model.Feedback;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, String> {

	List<Feedback> findByEmail(String email);

}