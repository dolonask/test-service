package kg.easyit.testservice.models.dto;

import lombok.Data;

import java.util.List;

@Data
public class ResBody {

    private Status status;
    private List<SignatureClass> result;
}

