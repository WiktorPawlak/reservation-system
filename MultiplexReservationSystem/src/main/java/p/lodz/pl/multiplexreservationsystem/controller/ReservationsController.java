package p.lodz.pl.multiplexreservationsystem.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import p.lodz.pl.multiplexreservationsystem.model.Reservations;
import p.lodz.pl.multiplexreservationsystem.service.ReservationsService;
import p.lodz.pl.multiplexreservationsystem.service.dto.ReservationDto;

import javax.validation.Valid;


@RestController
@RequiredArgsConstructor
public class ReservationsController {

    private final ReservationsService reservationsService;

    @PostMapping("/reservations")
    ReservationDto postReservation(@RequestBody @Valid Reservations newReservation) {
        return reservationsService.postReservation(newReservation);
    }
// SAMPLE INPUT
//      {
//        "screeningId": 2,
//        "name": "Wiktor",
//        "surname": "Pawlak",
//        "tickets":
//         [
//            {
//              "seatId": 17,
//              "type": "ADULT"
//
//            },
//            {
//              "seatId": 18,
//              "type": "ADULT"
//            }
//         ]
//      }
}
