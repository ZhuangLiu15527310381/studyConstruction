package com.example.demo.mapstruct.inter;


import com.example.demo.entity.Apee;
import com.example.demo.entity.PersionDTO;
import com.example.demo.entity.PersonVO;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@Mapper
public interface MyMapper {

    MyMapper INSTANCE = Mappers.getMapper(MyMapper.class);

    @Mapping(source = "describe", target = "des")
    PersonVO transToViewObject(PersionDTO persionDTO);



    @Mapping(source = "persionDTO.describe", target = "des")
    @Mapping(source = "apee.ap", target = "choice")
    PersonVO transToViewObject(PersionDTO persionDTO, Apee apee);






    @AfterMapping
    default void changeDateIntoString(@MappingTarget PersonVO personVO, PersionDTO persionDTO) {
        Date birthDay = persionDTO.getBirthDay();
        if (Objects.nonNull(birthDay)){
            personVO.setBirth(transData(birthDay));
        }

    }



    default String transData(Date date){
        if (date ==  null){
            return null;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String format = simpleDateFormat.format(date);
        return format;
    }


}
