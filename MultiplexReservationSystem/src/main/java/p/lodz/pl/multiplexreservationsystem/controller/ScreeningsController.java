package p.lodz.pl.multiplexreservationsystem.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import p.lodz.pl.multiplexreservationsystem.service.dto.ScreeningsDto;
import p.lodz.pl.multiplexreservationsystem.service.ScreeningsService;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ScreeningsController {

  private final ScreeningsService screeningsService;

  @GetMapping("/screenings")
  public List<ScreeningsDto> getScreeningsWithMovies(@RequestParam(required = false) int page) {
    return screeningsService.getScreeningsWithMovies(page);
  }

//  private List<ScreeningsDto> mapToScreeningsDtos(List<Screenings> screeningsWithMovies) {
//    return screeningsWithMovies.stream()
//            .map(screening, movie -> mapToScreeningsDto(screening, movie))
//            .collect(Collectors.toList());
//  }
//
//  private ScreeningsDto mapToScreeningsDto(Screenings screening, Movies movie) {
//    return ScreeningsDto.builder()
//            .id(screening.getId())
//            .movieId(screening.getMovieId())
//            .roomId(screening.getRoomId())
//            .date(screening.getDate())
//            .title(movie.getTitle())
//            .duration(movie.getDuration())
//            .build();
//  }

//  @GetMapping("/posts")
//  public List<PostDto> getPosts(@RequestParam(required = false) int page, Sort.Direction sort) {
//    int pagetNumber = page >= 0 ? page : 0;
//    return PostDtoMapper.mapToPostDtos(postService.getPosts(pagetNumber, sort));
//  }
}
