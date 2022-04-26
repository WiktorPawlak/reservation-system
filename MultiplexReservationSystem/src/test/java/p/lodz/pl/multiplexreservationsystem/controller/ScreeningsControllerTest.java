package p.lodz.pl.multiplexreservationsystem.controller;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import p.lodz.pl.multiplexreservationsystem.repository.ScreeningsRepository;
import p.lodz.pl.multiplexreservationsystem.service.ScreeningsService;
import p.lodz.pl.multiplexreservationsystem.service.SeatsService;
import p.lodz.pl.multiplexreservationsystem.service.dto.RoomInfoDto;
import p.lodz.pl.multiplexreservationsystem.service.dto.ScreeningsDto;
import p.lodz.pl.multiplexreservationsystem.service.dto.SeatsDto;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.*;

@WebMvcTest(ScreeningsController.class)
class ScreeningsControllerTest {
  @Autowired
  MockMvc mockMvc;

  @MockBean
  ScreeningsRepository screeningsRepository;
  @MockBean
  ScreeningsService screeningsService;
  @MockBean
  SeatsService seatsService;

  SeatsDto availableSeat1 = new SeatsDto(1, 3);
  SeatsDto availableSeat2 = new SeatsDto(1, 4);
  List<SeatsDto> availableSeats = Arrays.asList(availableSeat1, availableSeat2);

  LocalTime time2 = LocalTime.of(1,30,0);
  LocalTime time3 = LocalTime.of(2,30,0);

  ScreeningsDto screening1 = new ScreeningsDto("film1", time2);
  ScreeningsDto screening2 = new ScreeningsDto("film2", time2);
  ScreeningsDto screening3 = new ScreeningsDto("film3", time3);

  @Test
  void getScreeningsWithMovies() throws Exception {
    List<ScreeningsDto> correctList = Arrays.asList(screening2, screening3);

    Mockito.when(screeningsService.getScreeningsWithMovies(0))
            .thenReturn(correctList);

    mockMvc.perform(MockMvcRequestBuilders
                    .get("/screenings?page=0")
                    .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].title", is("film2")))
            .andExpect(jsonPath("$[0].duration", is("01:30:00")))
            .andExpect(jsonPath("$[1].title", is("film3")))
            .andExpect(jsonPath("$[1].duration", is("02:30:00")));
  }

  @Test
  void getSingleScreening() throws Exception {
    RoomInfoDto correctInfo = new RoomInfoDto(1, availableSeats);

    Mockito.when(seatsService.getRoomInfo(1L))
            .thenReturn(correctInfo);

    mockMvc.perform(MockMvcRequestBuilders
              .get("/screenings/1")
              .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$['id']", is(1)))
            .andExpect(jsonPath("$['seats'][0]['row']", is(1)))
            .andExpect(jsonPath("$['seats'][0]['seatNumber']", is(3)))
            .andExpect(jsonPath("$['id']", is(1)))
            .andExpect(jsonPath("$['seats'][1]['row']", is(1)))
            .andExpect(jsonPath("$['seats'][1]['seatNumber']", is(4)));
  }

  @Test
  void getScreeningsWithinPeriod() throws Exception {
    List<ScreeningsDto> correctList =  Arrays.asList(screening1, screening2);
    LocalDateTime from = LocalDateTime.of(2022,
            Month.APRIL, 19, 11, 0, 0);
    LocalDateTime to = LocalDateTime.of(2022,
            Month.APRIL, 19, 14, 0, 0);

    Mockito.when(screeningsService.getScreeningsWithinPeriod(from, to, 0))
            .thenReturn(correctList);

    mockMvc.perform(MockMvcRequestBuilders
              .get("/screenings/2022-04-19T11:00,2022-04-19T14:00?page=0")
              .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$", hasSize(2)))
            .andExpect(jsonPath("$[0].title", is("film1")))
            .andExpect(jsonPath("$[1].title", is("film2")));
  }
}