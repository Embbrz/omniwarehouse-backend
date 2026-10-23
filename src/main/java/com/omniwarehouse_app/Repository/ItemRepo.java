package com.omniwarehouse_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.omniwarehouse_app.Entity.Item;

@Repository
public interface ItemRepo extends JpaRepository<Item, Long>{

}
