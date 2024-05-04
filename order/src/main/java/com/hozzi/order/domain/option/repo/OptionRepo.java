package com.hozzi.order.domain.option.repo;

import com.hozzi.order.domain.option.entity.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OptionRepo extends JpaRepository<Option, Long> {
    Optional<Option> findByOptionName(String optionName);
}
