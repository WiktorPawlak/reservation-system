package p.lodz.pl.multiplexreservationsystem.service;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import p.lodz.pl.multiplexreservationsystem.model.Screenings;
import p.lodz.pl.multiplexreservationsystem.repository.ScreeningsRepository;
import p.lodz.pl.multiplexreservationsystem.service.dto.ScreeningsDto;

import java.time.LocalDateTime;
import java.util.List;

import static p.lodz.pl.multiplexreservationsystem.service.mapper.ScreeningsDtoMapper.mapToScreeningsDtos;


@Service
@RequiredArgsConstructor
public class ScreeningsService {

    private static final int PAGE_SIZE = 8;

    private final ScreeningsRepository screeningsRepository;

    public List<ScreeningsDto> getScreeningsWithMovies(Integer page) {
        if (page == null || page < 0) {
            page = 0;
        }

        return mapToScreeningsDtos(screeningsRepository
                .findAllScreeningsJoinMovies(PageRequest
                        .of(page, PAGE_SIZE,
                                Sort.by(Sort.Order.asc("m.title"),
                                        Sort.Order.asc("m.duration"))
                        ))
        );
    }

    public Screenings getSingleScreening(final Long id) {
        return screeningsRepository.findById(id).orElseThrow();
    }

    public List<ScreeningsDto> getScreeningsWithinPeriod(final LocalDateTime from, final LocalDateTime to, Integer page) {
        if (page == null || page < 0) {
            page = 0;
        }

        return mapToScreeningsDtos(screeningsRepository.findAllScreeningsWithinPeriod(from, to,
                PageRequest.of(page, PAGE_SIZE,
                        Sort.by(Sort.Order.asc("m.title"),
                                Sort.Order.asc("m.duration"))
                ))
        );
    }
}
