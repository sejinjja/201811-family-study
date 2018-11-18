package com.study.gallery.gallery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.study.gallery.StdResponse;

@RestController
@RequestMapping("/gallery/v1")
public class GalleryController {
	@Autowired
	private GalleryService galleryService;

	@GetMapping("getGallery")
	public StdResponse<Gallery> getGallery(@RequestParam(required=false) Long galleryId, @RequestParam(required=false) String url) {
		Gallery gallery = this.galleryService.getGallery(galleryId, url);

		StdResponse<Gallery> res = new StdResponse<>();

		if (gallery != null) {
			res.setCode(200);
			res.setMessage("success");
			res.setPayload(gallery);
		} else {
			res.setCode(404);
			res.setMessage("not found");
		}

		return res;
	}



}
