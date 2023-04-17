package com.simonwinther.Refresh.dao;

import com.simonwinther.Refresh.entity.ShortUrl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ShortUrlDao extends JpaRepository<ShortUrl, Long>, QuerydslPredicateExecutor<ShortUrl> {
}
