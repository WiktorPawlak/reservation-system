package p.lodz.pl.multiplexreservationsystem.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import p.lodz.pl.multiplexreservationsystem.service.ScreeningsService;
import p.lodz.pl.multiplexreservationsystem.service.SeatsService;
import p.lodz.pl.multiplexreservationsystem.service.dto.RoomInfoDto;
import p.lodz.pl.multiplexreservationsystem.service.dto.ScreeningsDto;

import java.time.LocalDateTime;
import java.util.List;


@RestController
@RequiredArgsConstructor
public class ScreeningsController {

    private final ScreeningsService screeningsService;

    private final SeatsService seatsService;

    @GetMapping("/screenings")
    public List<ScreeningsDto> getScreeningsWithMovies(@RequestParam(required = false) Integer page) {
        return screeningsService.getScreeningsWithMovies(page);
    }

    @GetMapping("/screenings/{id:[\\d+]}")
    public RoomInfoDto getSingleScreening(@PathVariable("id") Long id) {
        return seatsService.getRoomInfo(id);
    }

    @GetMapping("/screenings/{from},{to}")
    public List<ScreeningsDto> getScreeningsWithinPeriod(
            @PathVariable("from") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime from,
            @PathVariable("to") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm") LocalDateTime to,
            @RequestParam(required = false) Integer page) {
        return screeningsService.getScreeningsWithinPeriod(from, to, page);
    } //2022-04-19T11:00
}
