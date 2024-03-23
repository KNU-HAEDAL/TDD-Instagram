package haedal.tdd.instagram.repository.story;

import haedal.tdd.instagram.entity.story.Story;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryRepository extends JpaRepository<Story, Long> {
}
