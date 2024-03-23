package haedal.tdd.instagram.repository.story;

import haedal.tdd.instagram.entity.story.StoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoryJpaRepository extends JpaRepository<StoryEntity, Long> {
}
