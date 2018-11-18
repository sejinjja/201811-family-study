package com.study.gallery.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GalleryService {
	@Autowired
	GalleryRepository galleryRepository;

    public Gallery getGallery( Long galleryId, String url ) {
        return this.galleryRepository.findByGalleryIdOrUrl(galleryId, url);
    }

}
