package com.hozzi.order.domain.option.service;

import com.hozzi.order.domain.option.dto.CreateOptionInDTO;
import com.hozzi.order.domain.option.dto.CreateOptionOutDTO;
import com.hozzi.order.domain.option.dto.ReadOptionOutDTO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

public interface OptionService {
    ReadOptionOutDTO readOrderManage(String optionName);
    CreateOptionOutDTO createOption(CreateOptionInDTO createOptionInDTO);
}
