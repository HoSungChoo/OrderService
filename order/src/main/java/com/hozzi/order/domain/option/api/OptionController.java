package com.hozzi.order.domain.option.api;

import com.hozzi.order.domain.option.dto.CreateOptionInDTO;
import com.hozzi.order.domain.option.dto.CreateOptionOutDTO;
import com.hozzi.order.domain.option.dto.ReadOptionOutDTO;
import com.hozzi.order.domain.option.service.OptionService;
import com.hozzi.order.domain.order.dto.ReadOrderManageOutDTOs;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/option")
public class OptionController {
    private final OptionService optionService;

    public OptionController(OptionService optionService) {
        this.optionService = optionService;
    }

    @GetMapping("/{optionName}")
    private ResponseEntity<ReadOptionOutDTO> readOrderManage(@PathVariable String optionName){
        ReadOptionOutDTO readOptionOutDTO = optionService.readOrderManage(optionName);

        return ResponseEntity.status(HttpStatus.OK).body(readOptionOutDTO);
    }
    @PostMapping()
    private ResponseEntity<CreateOptionOutDTO> createOption(@RequestBody CreateOptionInDTO createOptionInDTO){
        CreateOptionOutDTO createOptionOutDTO = optionService.createOption(createOptionInDTO);

        return ResponseEntity.status(HttpStatus.OK).body(createOptionOutDTO);
    }
}
