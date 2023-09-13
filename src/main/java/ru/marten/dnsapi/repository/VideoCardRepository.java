package ru.marten.dnsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.marten.dnsapi.model.VideoCard;

@Repository
public interface VideoCardRepository extends JpaRepository<VideoCard, Long> {
}
