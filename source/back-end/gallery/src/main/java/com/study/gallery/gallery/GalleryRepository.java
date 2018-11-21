package com.study.gallery.gallery;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GalleryRepository extends JpaRepository<Gallery, Long> {

	public Gallery findByGalleryIdOrUrl(Long galleryId, String url);

}
