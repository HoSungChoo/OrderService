package com.hozzi.order.domain.option.service.impl;

import com.hozzi.order.domain.option.dto.CreateOptionInDTO;
import com.hozzi.order.domain.option.dto.CreateOptionOutDTO;
import com.hozzi.order.domain.option.dto.ReadOptionOutDTO;
import com.hozzi.order.domain.option.entity.Option;
import com.hozzi.order.domain.option.mapper.OptionMapper;
import com.hozzi.order.domain.option.repo.OptionRepo;
import com.hozzi.order.domain.option.service.OptionService;
import org.springframework.stereotype.Service;

@Service
public class OptionServiceImpl implements OptionService {
    private final OptionRepo optionRepo;
    public OptionServiceImpl(OptionRepo optionRepo) {
        this.optionRepo = optionRepo;
    }

    @Override
    public ReadOptionOutDTO readOrderManage(String optionName) {
        Option option = optionRepo.findByOptionName(optionName).orElseThrow(()->new IllegalArgumentException("Bad Request"));

        return OptionMapper.optionMapper.toReadOptionOutDTO(option);
    }

    @Override
    public CreateOptionOutDTO createOption(CreateOptionInDTO createOptionInDTO) {
        Option option = Option.builder()
                .optionName(createOptionInDTO.getOptionName())
                .detail(createOptionInDTO.getDetail())
                .value(createOptionInDTO.getValue())
                .build();

        optionRepo.save(option);

        return OptionMapper.optionMapper.toCreateOptionOutDTO(option);
    }
}
