package com.iscae._election_etudient.controller.request_response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SyndicatResponse {
     String     syndicatNom;
      int      nombreVote;
      int        position ;
      String  logo;
}
