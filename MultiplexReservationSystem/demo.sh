#!/bin/bash

dates="2023-04-19T11:00,2023-04-20T11:00"
pageNum=0

echo
echo
echo

echo -e "\n\033[0;32mSystem lists available screenings: \033[0m"

data=$(curl -s http://localhost:8080/screenings?page=0) &&

echo
echo $data
echo
echo

echo -e "\n\033[0;32mThe users chooses to see screenings within given period of time: \033[0m"

data=$(curl -s http://localhost:8080/screenings/$dates?page=$pageNum) &&

echo
echo $data
echo
echo

echo -e "\n\033[0;32mThe users chooses a particular screening.\033[0m"
echo -e "\n\033[0;32mThe system gives back room number (id) with available seats info: \033[0m"

data=$(curl -s http://localhost:8080/screenings/1) &&

echo
echo $data
echo
echo


echo -e "\n\033[0;32mThe user chooses seats, and gives the name of the person doing the reservation.\033[0m"
echo -e "\n\033[0;32mThe name is too short...\033[0m"

data=$(curl -s http://localhost:8080/reservations -H 'Content-type:application/json' \
-d \
    '{
        "screeningId": 2,
        "name": "T",
        "surname": "Sans",
        "tickets":
         [
            {
              "seatId": 3,
              "type": "ADULT"

            },
            {
              "seatId": 4,
              "type": "ADULT"
            }
         ]
      }') &&

echo
echo $data
echo
echo


echo -e "\n\033[0;32mThe user chooses seats, and gives the name of the person doing the reservation. \033[0m"
echo -e "\n\033[0;32mThe surname does not comply with business rules...\033[0m"

data=$(curl -s http://localhost:8080/reservations -H 'Content-type:application/json' \
-d \
    '{
        "screeningId": 2,
        "name": "Sam",
        "surname": "Sans-serif",
        "tickets":
         [
            {
              "seatId": 3,
              "type": "ADULT"

            },
            {
              "seatId": 4,
              "type": "ADULT"
            }
         ]
      }') &&

echo
echo $data
echo
echo


echo -e "\n\033[0;32mThe user chooses seats, and gives the name of the person doing the reservation. \033[0m"
echo -e "\n\033[0;32mSeat 1 is already booked, so booking 3rd seat would result in a gap between them...\033[0m"

data=$(curl -s http://localhost:8080/reservations -H 'Content-type:application/json' \
-d \
    '{
        "screeningId": 2,
        "name": "Sam",
        "surname": "Sans-Serif",
        "tickets":
         [
            {
              "seatId": 3,
              "type": "ADULT"

            },
            {
              "seatId": 4,
              "type": "ADULT"
            }
         ]
      }') &&

echo
echo $data
echo
echo


echo -e "\n\033[0;32mThe user chooses seats, and gives the name of the person doing the reservation. \033[0m"
echo -e "\n\033[0;32mNo seats were choosen...\033[0m"

data=$(curl -s http://localhost:8080/reservations -H 'Content-type:application/json' \
-d \
    '{
        "screeningId": 2,
        "name": "Sam",
        "surname": "Sans-Serif",
        "tickets":
         [
         ]
      }') &&

echo
echo $data
echo
echo


echo -e "\n\033[0;32mThe user chooses seats, and gives the name of the person doing the reservation. \033[0m"
echo -e "\n\033[0;32mChoosen screening is booked too late...\033[0m"

data=$(curl -s http://localhost:8080/reservations -H 'Content-type:application/json' \
-d \
    '{
        "screeningId": 1,
        "name": "Sam",
        "surname": "Sans-Serif",
        "tickets":
         [
            {
              "seatId": 2,
              "type": "ADULT"

            },
            {
              "seatId": 3,
              "type": "CHILD"
            }
         ]
      }') &&

echo
echo $data
echo
echo


echo -e "\n\033[0;32mThe user chooses seats, and gives the name of the person doing the reservation. \033[0m"
echo -e "\n\033[0;32mEverything is correct. The systems gives back total price and reservation expiration time - "
echo -e "\n\033[0;32m(start of screening + movie's duration)\033[0m"

data=$(curl -s http://localhost:8080/reservations -H 'Content-type:application/json' \
-d \
    '{
        "screeningId": 2,
        "name": "Sam",
        "surname": "Sans-Serif",
        "tickets":
         [
            {
              "seatId": 17,
              "type": "ADULT"

            },
            {
              "seatId": 18,
              "type": "CHILD"
            }
         ]
      }') &&

echo
echo $data
echo
echo
