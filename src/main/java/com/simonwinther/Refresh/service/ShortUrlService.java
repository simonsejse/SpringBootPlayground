package com.simonwinther.Refresh.service;

import com.querydsl.core.types.dsl.BooleanExpression;
import com.simonwinther.Refresh.dao.ShortUrlDao;
import com.simonwinther.Refresh.dto.ShortUrlDTO;
import com.simonwinther.Refresh.entity.QShortUrl;
import com.simonwinther.Refresh.entity.QStudent;
import com.simonwinther.Refresh.entity.ShortUrl;
import com.simonwinther.Refresh.exceptions.ShortenedUrlDoesNotExist;
import com.simonwinther.Refresh.exceptions.ShortenedUrlExists;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.RedirectView;

import java.util.Optional;

@Service
public class ShortUrlService {
    private final ShortUrlDao shortUrlDao;

    public ShortUrlService(ShortUrlDao shortUrlDao) {
        this.shortUrlDao = shortUrlDao;
    }

    public ShortUrlDTO createShortenedUrl(String slug, String redirectUrl) {
        boolean exists = shortUrlDao.exists(QShortUrl.shortUrl.slug.eq(slug).and(QShortUrl.shortUrl.redirectUrl.eq(redirectUrl)));

        if (exists)
            throw new ShortenedUrlExists();

        ShortUrl save = shortUrlDao.save(ShortUrl.builder()
                .redirectUrl(redirectUrl)
                .slug(slug)
                .build()
        );
        return ShortUrlDTO.builder().redirectUrl(save.getRedirectUrl()).slug(save.getSlug()).build();
    }


    public RedirectView redirectBySlug(String slug) {
        ShortUrl shortUrl = shortUrlDao.findOne(QShortUrl.shortUrl.slug.eq(slug)).orElseThrow(ShortenedUrlDoesNotExist::new);
        RedirectView view = new RedirectView();
        view.setUrl(shortUrl.getRedirectUrl());
        return view;
    }
}
