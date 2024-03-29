package com.iscae._election_etudient.controller.request_response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VoteRequest {
    String email;
    String syndicatNom;
    BigInteger INE;
    String code;

}
