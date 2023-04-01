package com.example.Hotel.ApiHotel.DTO;
import com.example.Hotel.ApiHotel.Models.CheckDAO;
import com.example.Hotel.ApiHotel.Models.ClientDAO;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CheckDTO {

    private Long idCheck;
    private Long idReserva;

    private String horarioCheckIn;
    private String horarioCheckOut;
    private Integer quantCart;

    private boolean ative;

    public CheckDAO toDAO(){
        return CheckDAO
                .builder()
                .idCheck(idCheck)
                .idReserva(idReserva)
                .horarioCheckIn(horarioCheckIn)
                .horarioCheckOut(horarioCheckOut)
                .quantCart(quantCart)
                .ative(true)
                .build();
    }

    public boolean fazerCheckIn(){
        return  this.ative = true;

    }
    public boolean fazerCheckOut(){
        return this.ative = false;

    }

    public CheckDTO( CheckDAO horizontePlanejamento){
        idCheck = getIdCheck();
        idReserva = getIdReserva();
        horarioCheckIn = getHorarioCheckIn();
        horarioCheckOut = getHorarioCheckOut();
        quantCart = getQuantCart();
    }
}