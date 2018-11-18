package com.study.gallery.gallery;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "tb_gallery")
public class Gallery {
//
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "gallery_id", nullable = false)
	private Long galleryId;

	@Column(name = "url", nullable = false)
	private String url;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "goal", nullable = false)
	private String goal;

}
