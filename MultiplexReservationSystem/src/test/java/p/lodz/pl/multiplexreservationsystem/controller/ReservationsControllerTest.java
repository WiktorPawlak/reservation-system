package p.lodz.pl.multiplexreservationsystem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import p.lodz.pl.multiplexreservationsystem.model.Reservations;
import p.lodz.pl.multiplexreservationsystem.model.TicketType;
import p.lodz.pl.multiplexreservationsystem.model.Tickets;
import p.lodz.pl.multiplexreservationsystem.service.ReservationsService;
import p.lodz.pl.multiplexreservationsystem.service.dto.ReservationDto;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ReservationsController.class)
class ReservationsControllerTest {
    @Autowired
    MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @MockBean
    ReservationsService reservationsService;

    BigDecimal priceTest = BigDecimal.valueOf(12.5);
    LocalDateTime expirationTimeTest = LocalDateTime.of(2022,
            Month.APRIL, 28, 19, 29, 9);
    Tickets ticketTest1 = Tickets.builder()
            .id(1L)
            .seatId(1L)
            .type(TicketType.CHILD)
            .build();
    List<Tickets> ticketsTest = List.of(ticketTest1);

    Reservations reservation = Reservations.builder()
            .id(1L)
            .screeningId(1L)
            .name("Wiktor")
            .surname("Pawlak")
            .expirationTime(expirationTimeTest)
            .tickets(ticketsTest)
            .build();


    @Test
    void postReservation() throws Exception {
        ReservationDto reservationInfo = ReservationDto.builder()
                .price(priceTest)
                .expirationTime(expirationTimeTest)
                .build();
        ticketTest1.setReservation(reservation);

        Mockito.when(reservationsService.postReservation(reservation))
                .thenReturn(reservationInfo);

        MockHttpServletRequestBuilder mockRequest = MockMvcRequestBuilders.post("/reservations")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON)
                .content(mapper.writeValueAsString(reservation));


        mockMvc.perform(mockRequest)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", notNullValue()))
                .andExpect(jsonPath("$['price']", is(priceTest.doubleValue())))
                .andExpect(jsonPath("$['expirationTime']", is("2022-04-28T19:29:09")));
    }
}