package me.dio.spring.boot.api.domain.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_news")    
public class News extends BaseItem {

}
