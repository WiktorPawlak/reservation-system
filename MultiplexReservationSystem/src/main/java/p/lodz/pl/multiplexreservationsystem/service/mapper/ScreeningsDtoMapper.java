package p.lodz.pl.multiplexreservationsystem.service.mapper;

import p.lodz.pl.multiplexreservationsystem.service.dto.ScreeningsDto;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

public class ScreeningsDtoMapper {
  public static List<ScreeningsDto> mapToScreeningsDtos(List<Object[]> screeningsWithMovies) {
    return screeningsWithMovies.stream()
            .map(ScreeningsDtoMapper::mapToScreeningsDto)
            .collect(Collectors.toList());
  }

  public static ScreeningsDto mapToScreeningsDto(Object[] object) {
    return ScreeningsDto.builder()
            //.id(((Screenings) object[0]).getId())
            //.movieId(((Screenings) object[0]).getMovieId())
            //.roomId(((Screenings) object[0]).getRoomId())
            //.date(((Screenings) object[0]).getDate())
            .title((String) object[1])
            .duration((LocalTime) object[2])
            .build();
  }
}
