package com.hozzi.order.domain.user.mapper;

import com.hozzi.order.domain.user.dto.DeleteUserOutDTO;
import com.hozzi.order.domain.user.dto.DeleteUserOutDTO.DeleteUserOutDTOBuilder;
import com.hozzi.order.domain.user.dto.ReadUserOutDTO;
import com.hozzi.order.domain.user.dto.ReadUserOutDTO.ReadUserOutDTOBuilder;
import com.hozzi.order.domain.user.dto.UpdateUserOutDTO;
import com.hozzi.order.domain.user.dto.UpdateUserOutDTO.UpdateUserOutDTOBuilder;
import com.hozzi.order.domain.user.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-06-05T11:58:08+0900",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-8.7.jar, environment: Java 21.0.2 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public ReadUserOutDTO toReadUserOutDTO(User user) {
        if ( user == null ) {
            return null;
        }

        ReadUserOutDTOBuilder readUserOutDTO = ReadUserOutDTO.builder();

        readUserOutDTO.userId( user.getUserId() );
        readUserOutDTO.gender( user.getGender() );
        readUserOutDTO.userName( user.getUserName() );
        readUserOutDTO.age( user.getAge() );
        readUserOutDTO.userType( user.getUserType() );
        readUserOutDTO.balance( user.getBalance() );
        readUserOutDTO.point( user.getPoint() );
        readUserOutDTO.createAt( user.getCreateAt() );
        readUserOutDTO.updateAt( user.getUpdateAt() );

        return readUserOutDTO.build();
    }

    @Override
    public UpdateUserOutDTO toUpdateUserOutDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UpdateUserOutDTOBuilder updateUserOutDTO = UpdateUserOutDTO.builder();

        updateUserOutDTO.userId( user.getUserId() );
        updateUserOutDTO.gender( user.getGender() );
        updateUserOutDTO.userName( user.getUserName() );
        updateUserOutDTO.age( user.getAge() );
        updateUserOutDTO.userType( user.getUserType() );
        updateUserOutDTO.balance( user.getBalance() );
        updateUserOutDTO.point( user.getPoint() );
        updateUserOutDTO.createAt( user.getCreateAt() );
        updateUserOutDTO.updateAt( user.getUpdateAt() );

        return updateUserOutDTO.build();
    }

    @Override
    public DeleteUserOutDTO toDeleteUserOutDTO(User user) {
        if ( user == null ) {
            return null;
        }

        DeleteUserOutDTOBuilder deleteUserOutDTO = DeleteUserOutDTO.builder();

        deleteUserOutDTO.userId( user.getUserId() );
        deleteUserOutDTO.gender( user.getGender() );
        deleteUserOutDTO.userName( user.getUserName() );
        deleteUserOutDTO.age( user.getAge() );
        deleteUserOutDTO.userType( user.getUserType() );
        deleteUserOutDTO.balance( user.getBalance() );
        deleteUserOutDTO.point( user.getPoint() );
        deleteUserOutDTO.createAt( user.getCreateAt() );
        deleteUserOutDTO.updateAt( user.getUpdateAt() );

        return deleteUserOutDTO.build();
    }
}
