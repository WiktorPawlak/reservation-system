package p.lodz.pl.multiplexreservationsystem.service.mapper;


import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import p.lodz.pl.multiplexreservationsystem.service.dto.ScreeningsDto;

import java.time.LocalTime;
import java.util.List;


@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ScreeningsDtoMapper {

    public static List<ScreeningsDto> mapToScreeningsDtos(List<Object[]> screeningsWithMovies) {
        return screeningsWithMovies.stream()
                .map(ScreeningsDtoMapper::mapToScreeningsDto)
                .toList();
    }

    public static ScreeningsDto mapToScreeningsDto(Object[] object) {
        return ScreeningsDto.builder()
                .title((String) object[1])
                .duration((LocalTime) object[2])
                .build();
    }
}
