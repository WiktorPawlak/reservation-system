package p.lodz.pl.multiplexreservationsystem.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.service.dto.ScreeningsDto;
import p.lodz.pl.multiplexreservationsystem.model.Screenings;
import p.lodz.pl.multiplexreservationsystem.repository.ScreeningsRepository;

import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ScreeningsService {
  private static final int PAGE_SIZE = 8;
  private final ScreeningsRepository screeningsRepository;

  public List<Screenings> getScreenings(int page) {
    return screeningsRepository.findAllScreenings(PageRequest.of(page, PAGE_SIZE));
  }

  public Screenings getSingleScreening(long id) {
    return screeningsRepository.findById(id)
            .orElseThrow();
  }

  public List<ScreeningsDto> getScreeningsWithMovies(int page) {
    return mapToScreeningsDtos(screeningsRepository
            .findAllScreeningsJoinMovies(PageRequest
            .of(page, PAGE_SIZE,
                Sort.by(Sort.Order.asc("m.title"),
                        Sort.Order.asc("m.duration"))
               ))
    );
  }


  private List<ScreeningsDto> mapToScreeningsDtos(List<Object[]> screeningsWithMovies) {
    return screeningsWithMovies.stream()
            .map(this::mapToScreeningsDto)
            .collect(Collectors.toList());
  }

  private ScreeningsDto mapToScreeningsDto(Object[] object) {
    return ScreeningsDto.builder()
            .id(((Screenings) object[0]).getId())
            .movieId(((Screenings) object[0]).getMovieId())
            .roomId(((Screenings) object[0]).getRoomId())
            .date(((Screenings) object[0]).getDate())
            .title((String) object[1])
            .duration((LocalTime) object[2])
            .build();
  }
}
