package cl.crisgvera.ensayouno.service.dto;

import cl.crisgvera.ensayouno.model.Ayuda;
import lombok.Data;

@Data
public class BeneficiarioAyudaDto {
    private Long beneficiarioid;
    private Ayuda ayuda;
}
